package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

//TODO: Add annotations for the @NotEmpty for the parameters here

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserCreditCardRequest {
    @NotBlank(message = "Credit Card Number field can't be empty or null")
    private String creditCardNumber;
    @NotBlank(message = "Card Holder Name field can't be empty or null")
    private String cardholderName;
    @NotBlank(message = "expiration date field can't be empty or null")
    private String expirationDate;
    @NotBlank(message = "CVV field can't be empty or null")
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
