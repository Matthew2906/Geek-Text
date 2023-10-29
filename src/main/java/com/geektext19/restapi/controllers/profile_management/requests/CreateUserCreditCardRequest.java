package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//TODO: Add annotations for the @NotEmpty for the parameters here

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserCreditCardRequest {
    private String creditCardNumber;
    private String cardholderName;
    private String expirationDate;
    private String cvv;

    public CreateUserCreditCardRequest() {
    }

    public CreateUserCreditCardRequest(String creditCardNumber, String cardholderName, String expirationDate, String cvv) {
        this.creditCardNumber = creditCardNumber;
        this.cardholderName = cardholderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
