package com.stage.safezone.specification;

import com.stage.safezone.model.SolicitacaoIngresso;
import com.stage.safezone.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.stage.safezone.model.QSolicitacaoIngresso.solicitacaoIngresso;
import static com.stage.safezone.model.enums.SituacaoSolicitacao.APROVADA;
import static com.stage.safezone.model.enums.SituacaoSolicitacao.PENDENTE;

public class SolicitacaoIngressoSpecification implements Validate<SolicitacaoIngresso> {

    private final Validator validator;
    private final BasicRepository repository;

    @Autowired
    public SolicitacaoIngressoSpecification(final Validator validator, final BasicRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    @Override
    public void validate(final SolicitacaoIngresso entidade) {
        this.validator.validate(entidade, this.checkUsuarioJaPossuiSolicitacaoAbertaParaEsteTime(this.repository));
    }

    private Specification<SolicitacaoIngresso> checkUsuarioJaPossuiSolicitacaoAbertaParaEsteTime(final BasicRepository repository) {

        return new Specification<SolicitacaoIngresso>() {
            @Override
            protected boolean validate(final SolicitacaoIngresso entidade) {
                this.setMensagem("Usuário já possui uma inscrição para este time");

                return repository.query()
                        .select(solicitacaoIngresso)
                        .where(solicitacaoIngresso.usuario.id.eq(entidade.getUsuario().getId()))
                        .where(solicitacaoIngresso.time.id.eq(entidade.getTime().getId()))
                        .where(solicitacaoIngresso.situacao.in(PENDENTE, APROVADA))
                        .fetchResults()
                        .isEmpty();
            }
        };

    }

}
