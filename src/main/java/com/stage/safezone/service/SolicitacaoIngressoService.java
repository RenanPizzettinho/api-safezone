package com.stage.safezone.service;

import com.stage.safezone.model.Operador;
import com.stage.safezone.model.SolicitacaoIngresso;
import com.stage.safezone.model.Time;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.specification.SolicitacaoIngressoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stage.safezone.model.QSolicitacaoIngresso.solicitacaoIngresso;
import static com.stage.safezone.model.enums.SituacaoOperador.OPERANDO;
import static com.stage.safezone.model.enums.SituacaoSolicitacao.*;

@Service
public class SolicitacaoIngressoService implements CrudService<SolicitacaoIngresso> {

    private final BasicRepository repository;
    private final OperadorService operadorService;
    private final UsuarioService usuarioService;
    private final TimeService timeService;

    @Autowired
    public SolicitacaoIngressoService(final BasicRepository repository, final OperadorService operadorService, final UsuarioService usuarioService, final TimeService timeService) {
        this.repository = repository;
        this.operadorService = operadorService;
        this.usuarioService = usuarioService;
        this.timeService = timeService;
    }

    @Override
    public SolicitacaoIngresso save(final SolicitacaoIngresso solicitacaoIngresso) {
        return this.repository.save(SolicitacaoIngresso.class, solicitacaoIngresso);
    }

    @Override
    public SolicitacaoIngresso find(final Long id) {
        return this.repository.find(SolicitacaoIngresso.class, id);
    }

    @Override
    public List<SolicitacaoIngresso> findAll() {
        return this.repository.findAll(SolicitacaoIngresso.class);
    }

    @Override
    public void delete(final Long id) {
        this.repository.delete(SolicitacaoIngresso.class, id);
    }

    public SolicitacaoIngresso solicitar(final Long timeId) {

        final Usuario usuario = this.usuarioService.usuarioContexto();
        final Time time = this.timeService.find(timeId);
        final SolicitacaoIngresso solicitacaoIngresso = new SolicitacaoIngresso(usuario, time, PENDENTE, null);

        new SolicitacaoIngressoSpecification(this.repository).validate(solicitacaoIngresso);

        return this.save(solicitacaoIngresso);

    }

    public SolicitacaoIngresso aprovar(final Long id) {

        final SolicitacaoIngresso solicitacaoIngresso = this.find(id);
        solicitacaoIngresso.setSituacao(APROVADA);
        final Integer identificadorPorTime = this.operadorService.getMaxIdentificadorPorTime(solicitacaoIngresso.getTime().getId());
        final Operador novoOperador = new Operador(solicitacaoIngresso.getUsuario(), solicitacaoIngresso.getTime(), identificadorPorTime, OPERANDO);
        final Operador operador = this.operadorService.save(novoOperador);
        solicitacaoIngresso.setOperador(operador);

        return this.save(solicitacaoIngresso);

    }

    public SolicitacaoIngresso negar(final Long id) {

        final SolicitacaoIngresso solicitacaoIngresso = this.find(id);
        solicitacaoIngresso.setSituacao(NEGADA);

        return this.save(solicitacaoIngresso);

    }

    public List<SolicitacaoIngresso> porTime(final Long id) {
        return this.repository.query()
                .select(solicitacaoIngresso)
                .where(solicitacaoIngresso.time.id.eq(id))
                .fetch();
    }

    public List<SolicitacaoIngresso> minhas() {
        return this.repository.query()
                .select(solicitacaoIngresso)
                .where(solicitacaoIngresso.usuario.id.eq(this.usuarioService.usuarioContexto().getId()))
                .fetch();
    }
}
