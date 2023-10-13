package com.geektext19.restapi.controllers.profile_management;

import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
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
        // TODO: Try catch for returning 404 OR 500
        UserResponse user = profileManagement.getUserDetails(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request){
        // TODO: Try catch for returning 500
        profileManagement.createUser(request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{username}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String username,
                                                   @RequestBody UpdateUserRequest request){
        // TODO: Error in DB try and catch returns 500 or 404
        profileManagement.updateUser(username,request);
        return ResponseEntity.noContent().build();
    }
}
