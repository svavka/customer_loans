package ru.sbt.demo.castomerloans.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.demo.castomerloans.model.ClientOffer;
import ru.sbt.demo.castomerloans.repository.ClientOfferRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final ClientOfferRepository clientOfferRepository;

    public ClientOffer getOfferForClient(String clientLogin) {
        if (clientLogin.equalsIgnoreCase("qwerty")) {
            return new ClientOffer();
        }
        long offerId = ThreadLocalRandom.current().nextLong(1, clientOfferRepository.count());
        return clientOfferRepository.getOne(offerId);
    }

    public ClientOffer addOffer(ClientOffer newClientOffer) {
        return clientOfferRepository.save(newClientOffer);
    }

    public Collection<ClientOffer> getOffers() {
        return clientOfferRepository.findAll();
    }

    @Override
    public ClientOffer getOfferById(Long idClientOffer) {
        return clientOfferRepository.getOne(idClientOffer);
    }

    @Override
    public void removeOffer(ClientOffer clientOffer) {
        clientOfferRepository.delete(clientOffer);
    }

}
