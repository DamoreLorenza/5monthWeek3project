package lorenza.week3project.controller;

import lorenza.week3project.entities.User;
import lorenza.week3project.services.UserService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String orderBy) {
        return userService.getUserByUsername(page, size, orderBy);
    }

    @GetMapping("/{userUUID}")
    public User getUserByUUID(@PathVariable UUID userUUID) {
        return userService.findByUUID(userUUID);
    }


    @PutMapping("/{userUUID}")
    public User getUserByUUIDAndUpdate(@PathVariable UUID userUUID, @RequestBody User modifiedUserPayload) {
        return userService.findByUUIDAndUpdate(userUUID, modifiedUserPayload);
    }

    @DeleteMapping("/{userUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getUserByUUIDAndDelete(@PathVariable UUID userUUID) {
        userService.findByUUIDAndDelete(userUUID);
    }

}