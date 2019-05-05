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

import static com.stage.safezone.model.enums.SituacaoOperador.OPERANDO;
import static com.stage.safezone.model.enums.SituacaoSolicitacao.*;

@Service
public class SolicitacaoIngressoService implements CrudService<SolicitacaoIngresso> {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private OperadorService operadorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TimeService timeService;

    @Override
    public SolicitacaoIngresso save(SolicitacaoIngresso solicitacaoIngresso) {
        return repository.save(SolicitacaoIngresso.class, solicitacaoIngresso);
    }

    @Override
    public SolicitacaoIngresso find(Long id) {
        return null;
    }

    @Override
    public List<SolicitacaoIngresso> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public SolicitacaoIngresso solicitar(Long timeId) {

        final Usuario usuario = usuarioService.usuarioContexto();
        final Time time = timeService.find(timeId);
        final SolicitacaoIngresso solicitacaoIngresso = new SolicitacaoIngresso(usuario, time, PENDENTE, null);

        new SolicitacaoIngressoSpecification(repository).validate(solicitacaoIngresso);

        return this.save(solicitacaoIngresso);

    }

    public SolicitacaoIngresso aprovar(Long id) {

        final SolicitacaoIngresso solicitacaoIngresso = this.find(id);
        solicitacaoIngresso.setSituacao(APROVADA);
        final Integer identificadorPorTime = operadorService.getMaxIdentificadorPorTime(solicitacaoIngresso.getTime().getId());
        final Operador operador = operadorService.save(new Operador(solicitacaoIngresso.getUsuario(), solicitacaoIngresso.getTime(), identificadorPorTime, OPERANDO));
        solicitacaoIngresso.setOperador(operador);

        return this.save(solicitacaoIngresso);

    }

    public SolicitacaoIngresso negar(Long id) {

        SolicitacaoIngresso solicitacaoIngresso = this.find(id);
        solicitacaoIngresso.setSituacao(NEGADA);

        return this.save(solicitacaoIngresso);

    }

    public List<SolicitacaoIngresso> porTime(Long id) {
//        return repository.query()
//                .selectFrom(solicitacaoIngresso)
//                .where(solicitacaoIngresso.time.id.eq(id))
//                .fetch();
        return null;
    }

    public List<SolicitacaoIngresso> minhas() {
//        return repository.query()
//                .selectFrom(solicitacaoIngresso)
//                .where(solicitacaoIngresso.usuario.id.eq(usuarioService.usuarioContexto().getId()))
//                .fetch();

        return null;
    }
}
