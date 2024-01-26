package lorenza.week3project.controller;
import lorenza.week3project.entities.User;
import lorenza.week3project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public User getProfile(@AuthenticationPrincipal User currentUser) {
        return currentUser;
    }


    @PutMapping("/me")
    public User getMeAndUpdate(@AuthenticationPrincipal User currentUser, @RequestBody User body) {
        return userService.findByUUIDAndUpdate(currentUser.getUuid(), body);
    }

    @DeleteMapping("/me")
    public void getMeAnDelete(@AuthenticationPrincipal User currentUser) {
        userService.findByUUIDAndDelete(currentUser.getUuid());
    }


    @GetMapping("/{userUUID}")
    public User getUserByUUID(@PathVariable UUID userUUID) {
        return userService.findByUUID(userUUID);
    }


    @PutMapping("/{userUUID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User getUserByUUIDAndUpdate(@PathVariable UUID userUUID, @RequestBody User modifiedUserPayload) {
        return userService.findByUUIDAndUpdate(userUUID, modifiedUserPayload);
    }

    @DeleteMapping("/{userUUID}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getUserByUUIDAndDelete(@PathVariable UUID userUUID) {
        userService.findByUUIDAndDelete(userUUID);
    }


}