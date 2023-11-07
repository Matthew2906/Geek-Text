package com.geektext19.restapi.controllers.profile_management;

import com.geektext19.restapi.controllers.profile_management.requests.CreateUserCreditCardRequest;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.services.profile_management.ProfileManagement;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.geektext19.restapi.controllers.profile_management.exceptions.UserNotFoundException;

@RestController
@RequestMapping(ProfileManagementController.BASE_ENDPOINT)
public class ProfileManagementController {
    public final static String BASE_ENDPOINT = "/profile-management";
    private final ProfileManagement profile_management;

    public ProfileManagementController(ProfileManagement profile_management) {
        this.profile_management = profile_management;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserDetails(@PathVariable String username){
        try {
            UserResponse user = profile_management.getUserDetails(username);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request){
        try {
            profile_management.createUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{username}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String username,
                                                   @Valid @RequestBody UpdateUserRequest request){
        try {
            profile_management.updateUser(username, request);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/credit-card/{username}")
    public ResponseEntity<Object> createCreditCard(@PathVariable String username,
                                                   @Valid @RequestBody CreateUserCreditCardRequest request){
        try {
            profile_management.addCreditCardToUser(username, request);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
