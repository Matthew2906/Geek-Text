package com.geektext19.restapi.controllers.profile_management;

import com.geektext19.restapi.GeekText19RestapiApplication;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserCreditCardRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.entities.CreditCard;
import com.geektext19.restapi.entities.User;
import com.geektext19.restapi.repositories.profile_management.CreditCardRepository;
import com.geektext19.restapi.repositories.profile_management.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = GeekText19RestapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfileManagementControllerIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository cardRepository;

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;

    private HttpHeaders headers;

    private final User user = createUserObject();

    private final CreditCard creditCard = creditCardObject();

    @BeforeEach
    public void setup() {
        restTemplate = new TestRestTemplate();
        restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        headers = new HttpHeaders();

    }

    @AfterEach
    public void tearDown() {
        cardRepository.delete(creditCard);
        userRepository.delete(user);
    }

    @Test
    public void testGetUserDetails() {
        // precondition: have user in database
        userRepository.save(user);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        // action: call get endpoint
        ResponseEntity<UserResponse> response = restTemplate.exchange(
                createURLWithPort(ProfileManagementController.BASE_ENDPOINT + "/" + user.getUsername()),
                HttpMethod.GET,
                entity,
                UserResponse.class);

        // validate result
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        Assertions.assertEquals(user.getUsername(), response.getBody().getUsername());
        Assertions.assertEquals(user.getAddress(), response.getBody().getAddress());
        Assertions.assertEquals(user.getEmail(), response.getBody().getEmail());
        Assertions.assertEquals(user.getFullName(), response.getBody().getFullName());

    }

    @Test
    public void testCreateUser() {
        // Create a new user object for testing
        User newUser = createUserObject();

        // Create the request object for the create user endpoint
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUsername(newUser.getUsername());
        createUserRequest.setPassword(newUser.getPassword());
        createUserRequest.setFullName(newUser.getFullName());
        createUserRequest.setEmail(newUser.getEmail());
        createUserRequest.setAddress(newUser.getAddress());

        // Create headers with JSON content type
        HttpHeaders createHeaders = new HttpHeaders();
        createHeaders.setContentType(MediaType.APPLICATION_JSON);

        // Create the request entity with the create user request object as the request body and headers
        HttpEntity<CreateUserRequest> entity = new HttpEntity<>(createUserRequest, createHeaders);

        // Call the create user endpoint
        ResponseEntity<Void> response = restTemplate.exchange(
                createURLWithPort(ProfileManagementController.BASE_ENDPOINT),
                HttpMethod.POST,
                entity,
                Void.class);

        // Validate result
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
    }


    @Test
    public void testUpdateUser() {
        // precondition: have user in database
        userRepository.save(user);

        // Create an UpdateUserRequest with the updated information
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setFullName("Pedro Santos");  // Fix: Use setFullName instead of setPassword
        updateUserRequest.setPassword("*1234");
        updateUserRequest.setAddress("1235 NW");

        // Create an HttpEntity with the update request and headers
        HttpEntity<UpdateUserRequest> entity = new HttpEntity<>(updateUserRequest, headers);

        // action: call get endpoint
        ResponseEntity<Void> response = restTemplate.exchange(
                createURLWithPort(ProfileManagementController.BASE_ENDPOINT + "/" + user.getUsername()),
                HttpMethod.PATCH,
                entity,
                Void.class);

        // validate result
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        User updatedU = userRepository.findByUsername(user.getUsername());

        Assertions.assertEquals(user.getUsername(), updatedU.getUsername());
        Assertions.assertEquals(updateUserRequest.getAddress(), updatedU.getAddress());
        Assertions.assertEquals(updateUserRequest.getFullName(), updatedU.getFullName());
        Assertions.assertEquals(updateUserRequest.getPassword(), updatedU.getPassword());
        Assertions.assertEquals(user.getEmail(), updatedU.getEmail());
    }


    @Test
    public void testUserCreditCard() {
        userRepository.save(user);

        CreateUserCreditCardRequest createUserCreditCardRequest = new CreateUserCreditCardRequest();
        createUserCreditCardRequest.setCreditCardNumber(creditCard.getCreditCardNumber());
        createUserCreditCardRequest.setCardholderName(creditCard.getCardholderName());
        createUserCreditCardRequest.setExpirationDate(creditCard.getExpirationDate());
        createUserCreditCardRequest.setCvv(creditCard.getCVV());

        // Create headers with JSON content type
        HttpHeaders createHeaders = new HttpHeaders();
        createHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateUserCreditCardRequest> entity = new HttpEntity<>(createUserCreditCardRequest, createHeaders);

        ResponseEntity<Void> response = restTemplate.exchange(
                createURLWithPort(ProfileManagementController.BASE_ENDPOINT + "/credit-card/" + user.getUsername()),
                HttpMethod.POST,
                entity,
                Void.class);

        // Validate result
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());

        CreditCard updatedCreditCard = cardRepository.findByCreditCardNumber(creditCard.getCreditCardNumber());

        Assertions.assertEquals(user.getUsername(), updatedCreditCard.getUser().getUsername());
        Assertions.assertEquals(createUserCreditCardRequest.getCreditCardNumber(), updatedCreditCard.getCreditCardNumber());
        Assertions.assertEquals(createUserCreditCardRequest.getCardholderName(), updatedCreditCard.getCardholderName());
        Assertions.assertEquals(createUserCreditCardRequest.getCvv(), updatedCreditCard.getCVV());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + this.port + uri;
    }

    private static User createUserObject() {
        return new User("test_bot",
                "test_psw001",
                "Test Bot",
                "tbot@pm.com",
                "address");
    }

    private static CreditCard creditCardObject() {
        return new CreditCard("1234567812345678",
                "Test Bot",
                "12/23",
                "123",
                createUserObject());
    }
}