package com.geektext19.restapi.controllers.profile_management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geektext19.restapi.controllers.profile_management.ProfileManagementController;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserCreditCardRequest;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.services.profile_management.ProfileManagement;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(ProfileManagementController.class)
public class ProfileManagementControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProfileManagement profileManagement;

    @InjectMocks
    private ProfileManagementController profileManagementController;

    @Autowired
    private Validator validator;

    @Test
    void testGetUserDetails() throws Exception {
        String username = "testUser";
        UserResponse userResponse = new UserResponse("andres",
                "Andres Gonzalez","anres@gmail.com", "3435435 NW 114th");

        when(profileManagement.getUserDetails(username)).thenReturn(userResponse);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/profile-management/{username}", username)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testCreateUser() throws Exception {
        CreateUserRequest createUserRequest = new CreateUserRequest("andres", "aea93*",
                "Andres Gonzalez","anres@gmail.com", "3435435 NW 114th");

        mockMvc.perform(MockMvcRequestBuilders.post("/profile-management")
                        .content(asJsonString(createUserRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateUser() throws Exception {
        String username = "testUser";
        UpdateUserRequest updateUserRequest = new UpdateUserRequest("aea93*",
                "Andres Gonzalez", "3435435 NW 114th");

        mockMvc.perform(MockMvcRequestBuilders.patch("/profile-management/{username}", username)
                        .content(asJsonString(updateUserRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateCreditCard() throws Exception {
        String username = "testUser";
        CreateUserCreditCardRequest createCreditCardRequest = new CreateUserCreditCardRequest("1234565",
                "Juanda A.", "11/25", "110");

        mockMvc.perform(MockMvcRequestBuilders.post("/profile-management/credit-card/{username}", username)
                        .content(asJsonString(createCreditCardRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}