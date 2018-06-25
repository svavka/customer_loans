package ru.sbt.demo.castomerloans.service;

import ru.sbt.demo.castomerloans.model.ClientOffer;

import java.util.Collection;

/**
 * Управление предложениями
 */
public interface OfferService {
    /**
     * @return Получить предложение по кредиту
     * @param clientLogin
     */
    ClientOffer getOfferForClient(String clientLogin);

    ClientOffer addOffer(ClientOffer newClientOffer);

    void removeOffer(ClientOffer clientOffer);

    Collection<ClientOffer> getOffers();

    ClientOffer getOfferById(Long idClientOffer);
}
