package com.geektext19.restapi.entities;

import jakarta.persistence.*;

@Entity
public class CreditCard {
    @Id
    private String creditCardNumber;
    private String cardholderName;
    private String expirationDate;
    private String CVV;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
    public CreditCard() {
    }

    public CreditCard(String creditCardNumber, String cardholderName, String expirationDate, String CVV, User user) {
        this.creditCardNumber = creditCardNumber;
        this.cardholderName = cardholderName;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
        this.user = user;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
