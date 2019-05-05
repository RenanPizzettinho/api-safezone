package com.stage.safezone.specification;

import com.stage.safezone.exception.ValidationException;
import com.stage.safezone.model.Inscricao;
import com.stage.safezone.repository.ContextoUsuarioRepository;

public class InscricaoSpecification implements Specification<Inscricao> {

    private ContextoUsuarioRepository repository;

    public InscricaoSpecification(ContextoUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Inscricao entidade) {
        this.checkJaPossuiInscricaoValidaNoEvento(entidade);
    }

    private void checkJaPossuiInscricaoValidaNoEvento(Inscricao entidade) {

        boolean empty = true;
//                repository.query()
//                .selectFrom(inscricao)
//                .where(inscricao.evento.id.eq(entidade.getEvento().getId()))
//                .where(inscricao.usuario.id.eq(entidade.getUsuario().getId()))
//                .where(inscricao.status.in(CONFIRMADO, PENDENTE))
//                .fetchResults()
//                .isEmpty();

        if (!empty) {
            throw new ValidationException("Voce já possui uma inscrição para este evento");
        }

    }

}
