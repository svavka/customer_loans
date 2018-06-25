package ru.sbt.demo.castomerloans.service;

import ru.sbt.demo.castomerloans.model.ClientOffer;

public interface CreditService {

    /**
     * Отправляет предложение на создание кредита
     * @param clientOffer предложение по кредиту
     * @param clientLogin для кого кредит
     * @param amount сумма кредита
     * @return успех операции
     */
    String createCredit(String clientLogin, ClientOffer clientOffer, Long amount);
}
