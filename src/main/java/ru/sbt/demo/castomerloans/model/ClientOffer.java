package ru.sbt.demo.castomerloans.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ClientOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String loginClient;
    private Long limitMoney;
    private Byte percent;

    public ClientOffer() {
    }

    public ClientOffer(String client, Long limitMoney, Byte percent) {
        this.loginClient = client;
        this.limitMoney = limitMoney;
        this.percent = percent;
    }

    public String toString() {
        return String.format("ClientOffer [id=%d, loginClient=%s, percent=%d ]", id, loginClient, percent);
    }
}
