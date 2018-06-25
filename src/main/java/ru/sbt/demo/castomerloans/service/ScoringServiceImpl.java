package ru.sbt.demo.castomerloans.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.demo.castomerloans.model.ClientOffer;
import ru.sbt.demo.castomerloans.repository.ClientOfferRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ScoringServiceImpl implements ScoringService {
    private final ClientOfferRepository clientOfferRepository;

    public boolean approvalProcess(String client, ClientOffer clientOffer) {
        Collection<ClientOffer> existingClient = clientOfferRepository.findByLoginClient(client);
        return (!existingClient.isEmpty() && existingClient.iterator().next().getLimitMoney() > clientOffer.getLimitMoney());
    }

}
