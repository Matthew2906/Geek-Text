package com.geektext19.restapi.repositories.profile_management;

import com.geektext19.restapi.entities.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepository extends CrudRepository<CreditCard, String> {
    CreditCard findByCreditCardNumber(String creditCardNumber);
}
