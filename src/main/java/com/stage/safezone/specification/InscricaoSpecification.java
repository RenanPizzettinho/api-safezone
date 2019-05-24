package com.stage.safezone.specification;

import com.stage.safezone.model.Inscricao;
import com.stage.safezone.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.stage.safezone.model.QInscricao.inscricao;
import static com.stage.safezone.model.enums.InscricaoStatus.CONFIRMADO;
import static com.stage.safezone.model.enums.InscricaoStatus.PENDENTE;

public class InscricaoSpecification implements Validate<Inscricao> {

    private final BasicRepository repository;
    private final Validator validator;

    @Autowired
    public InscricaoSpecification(final BasicRepository repository, final Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void validate(final Inscricao entidade) {
        this.validator.validate(entidade, this.checkJaPossuiInscricaoValidaNoEvento(this.repository));
    }

    private Specification<Inscricao> checkJaPossuiInscricaoValidaNoEvento(final BasicRepository repository) {
        return new Specification<Inscricao>() {
            @Override
            public boolean validate(final Inscricao entidade) {
                this.setMensagem("Voce já possui uma inscrição para este evento");
                return repository.query()
                        .select(inscricao)
                        .where(inscricao.evento.id.eq(entidade.getEvento().getId()))
                        .where(inscricao.usuario.id.eq(entidade.getUsuario().getId()))
                        .where(inscricao.status.in(CONFIRMADO, PENDENTE))
                        .fetchResults()
                        .isEmpty();
            }
        };

    }

}
