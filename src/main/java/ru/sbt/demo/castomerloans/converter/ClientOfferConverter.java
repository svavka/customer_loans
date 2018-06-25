package ru.sbt.demo.castomerloans.converter;

import org.springframework.core.convert.converter.GenericConverter;
import ru.sbt.demo.castomerloans.dto.ClientOfferDto;
import ru.sbt.demo.castomerloans.model.ClientOffer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface ClientOfferConverter<E extends ClientOffer, D extends ClientOfferDto> {

    E createFrom(final D dto);

    D createFrom(final E entity);

    E updateEntity(final E entity,final D dto);

    default Collection<D> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    default Collection<E> createFromDtos(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }
}
