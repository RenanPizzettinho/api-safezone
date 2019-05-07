package com.stage.safezone.specification;

import com.stage.safezone.exception.ValidationException;
import com.stage.safezone.model.Inscricao;
import com.stage.safezone.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.stage.safezone.model.QInscricao.inscricao;
import static com.stage.safezone.model.enums.InscricaoStatus.CONFIRMADO;
import static com.stage.safezone.model.enums.InscricaoStatus.PENDENTE;

public class InscricaoSpecification implements Specification<Inscricao> {

    private final BasicRepository repository;

    @Autowired
    public InscricaoSpecification(final BasicRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(final Inscricao entidade) {
        this.checkJaPossuiInscricaoValidaNoEvento(entidade);
    }

    private void checkJaPossuiInscricaoValidaNoEvento(final Inscricao entidade) {

        final boolean empty = this.repository.query()
                .select(inscricao)
                .where(inscricao.evento.id.eq(entidade.getEvento().getId()))
                .where(inscricao.usuario.id.eq(entidade.getUsuario().getId()))
                .where(inscricao.status.in(CONFIRMADO, PENDENTE))
                .fetchResults()
                .isEmpty();

        if (!empty) {
            throw new ValidationException("Voce já possui uma inscrição para este evento");
        }

    }

}
