package ru.sbt.demo.castomerloans.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbt.demo.castomerloans.model.ClientOffer;
import ru.sbt.demo.castomerloans.repository.ClientOfferRepository;
import ru.sbt.demo.checkGranting.CreditGrantChecker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final ClientOfferRepository clientOfferRepository;
    private final CreditGrantChecker creditGrantChecker;

    private Map<String, ClientOffer> approvedOfferForClient = new HashMap<>();

    public String createCredit(String clientLogin, ClientOffer clientOffer, Long amount) {
        System.out.println("Обращаюсь к серверу, используя ключ " + creditGrantChecker.getAccessKey());
        if (!approvedOfferForClient.containsKey(clientLogin)) {
            if (clientOffer.getLimitMoney() < amount) {
                return "Сумма кредита превышает предложение";
            } else if (ThreadLocalRandom.current().nextBoolean()) {

                approvedOfferForClient.put(clientLogin, clientOffer);
                clientOffer.setLimitMoney(clientOffer.getLimitMoney() - amount);
                clientOfferRepository.save(clientOffer);
                //вызов другого сервиса из кредитной системы
                return String.format("Уважаемый %s, кредит одобрен, ожидайте смс о поступлении", clientLogin);
            }
            return "В кредите отказано";
        } else {
            return String.format("Уважаемый %s - не жадничай", clientLogin);
        }
    }


}
