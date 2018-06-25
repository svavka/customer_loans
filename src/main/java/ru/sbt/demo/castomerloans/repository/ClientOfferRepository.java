package ru.sbt.demo.castomerloans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.demo.castomerloans.model.ClientOffer;

import java.util.Collection;


public interface ClientOfferRepository extends JpaRepository<ClientOffer, Long> {
    Collection<ClientOffer> findByLoginClient(String login);
}
