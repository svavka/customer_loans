package ru.sbt.demo.castomerloans.dto;

import lombok.Data;

@Data
public class ClientOfferDto {
    private Long id;
    private String loginClient;
    private Long limitMoney;
    private Byte percent;
}
