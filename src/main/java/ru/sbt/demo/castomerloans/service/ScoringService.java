package ru.sbt.demo.castomerloans.service;

import ru.sbt.demo.castomerloans.model.ClientOffer;

/**
 * Сервис одобрения
 */
public interface ScoringService {

    /**
     * Одобряет кредит для клиента
     *
     * @param client      - логин
     * @param clientOffer - выбранный офер
     * @return результат скоринга
     */
    boolean approvalProcess(String client, ClientOffer clientOffer);

}
