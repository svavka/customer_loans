package ru.sbt.demo.castomerloans.converter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;
import ru.sbt.demo.castomerloans.dto.ClientOfferDto;
import ru.sbt.demo.castomerloans.model.ClientOffer;
import ru.sbt.demo.castomerloans.repository.ClientOfferRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ClientOfferConverterImpl implements ClientOfferConverter {

    private final ModelMapper modelMapper;

    @Override
    public ClientOffer createFrom(final ClientOfferDto dto) {
        return updateEntity(new ClientOffer(), dto);
    }

    @Override
    public ClientOfferDto createFrom(final ClientOffer entity) {
        return modelMapper.map(entity, ClientOfferDto.class);
    }

    @Override
    public ClientOffer updateEntity(final ClientOffer entity, ClientOfferDto dto) {
        return modelMapper.map(dto, ClientOffer.class);
    }
}
