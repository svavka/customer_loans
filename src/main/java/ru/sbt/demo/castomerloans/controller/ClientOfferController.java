package ru.sbt.demo.castomerloans.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.sbt.demo.castomerloans.converter.ClientOfferConverter;
import ru.sbt.demo.castomerloans.dto.ClientOfferDto;
import ru.sbt.demo.castomerloans.model.ClientOffer;
import ru.sbt.demo.castomerloans.service.CreditService;
import ru.sbt.demo.castomerloans.service.OfferService;
import ru.sbt.demo.castomerloans.service.ScoringService;

import javax.validation.Valid;
import java.util.Collection;

@RestController()
@RequiredArgsConstructor
public class ClientOfferController {

    private static final String RESPONSE_TEMPLATE = "{\"result\":\"%s\"}";

    private final OfferService offerService;
    private final ClientOfferConverter<ClientOffer, ClientOfferDto> clientOfferConverter;
    private final ScoringService scoringService;
    private final CreditService creditService;


    @GetMapping("/offer/getForMe")
    @ResponseBody
    public ClientOfferDto giveOffer(@RequestParam String clientLogin) {
        ClientOffer offer = offerService.getOfferForClient(clientLogin);
        return clientOfferConverter.createFrom(offer);
    }

    @GetMapping("/offer/list")
    public Collection<ClientOfferDto> offers() {
        Collection<ClientOffer> allClientOffers = offerService.getOffers();
        return clientOfferConverter.createFromEntities(allClientOffers);
    }

    //@PostMapping(value = "/createCredit",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "createCredit",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createCredit(@RequestParam String clientLogin,@RequestParam Long idClientOffer,@RequestParam Long amount) {
        ClientOffer offer = offerService.getOfferById(idClientOffer);
        String responseText = creditService.createCredit(clientLogin, offer, amount);
        return String.format(RESPONSE_TEMPLATE, responseText);
    }

    @PostMapping(value = "/approveOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String approveOffer(String clientLogin, @Valid ClientOfferDto clientOfferDto) {
        ClientOffer offer = clientOfferConverter.createFrom(clientOfferDto);
        boolean scoringResult = scoringService.approvalProcess(clientLogin, offer);

        return String.format(RESPONSE_TEMPLATE, scoringResult);
    }

}
