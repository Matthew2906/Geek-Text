package com.geektext19.restapi.controllers.profile_management;

import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.services.profile_management.ProfileManagement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProfileManagementController.BASE_ENDPOINT)
public class ProfileManagementController {
    public final static String BASE_ENDPOINT = "/profile-management";
    private final ProfileManagement profileManagement;

    public ProfileManagementController(ProfileManagement profileManagement) {
        this.profileManagement = profileManagement;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserDetails(@PathVariable String username){
        UserResponse user = profileManagement.getUserDetails(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request){
        profileManagement.createUser(request);
        return ResponseEntity.noContent().build();
    }
}
