package com.stage.safezone.specification;

import com.stage.safezone.exception.ValidationException;
import com.stage.safezone.model.SolicitacaoIngresso;
import com.stage.safezone.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SolicitacaoIngressoSpecification implements Specification<SolicitacaoIngresso> {

    private final BasicRepository repository;

    @Autowired
    public SolicitacaoIngressoSpecification(BasicRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(SolicitacaoIngresso entidade) {
        this.checkUsuarioJaPossuiSolicitacaoAbertaParaEsteTime(entidade);
    }

    private void checkUsuarioJaPossuiSolicitacaoAbertaParaEsteTime(SolicitacaoIngresso entidade) {

        boolean empty = true;
//                .selectFrom(solicitacaoIngresso)
//                .where(solicitacaoIngresso.usuario.id.eq(entidade.getUsuario().getId()))
//                .where(solicitacaoIngresso.time.id.eq(entidade.getTime().getId()))
//                .where(solicitacaoIngresso.situacao.in(PENDENTE, APROVADA))
//                .fetchResults()
//                .isEmpty();

        if (!empty) {
            throw new ValidationException("Usuário já possui uma inscrição para este time");
        }

    }

}
