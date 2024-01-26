package lorenza.week3project.controller;

import lorenza.week3project.entities.User;
import lorenza.week3project.exceptions.BadRequestException;
import lorenza.week3project.payload.NewUserDTO;
import lorenza.week3project.payload.NewUserResponseDTO;
import lorenza.week3project.services.UserService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserResponseDTO createUser(@RequestBody @Validated NewUserDTO newUserPayload, BindingResult validation) {
        System.out.println(validation);
        if (validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("Errori nel payload");
        } else {
            User newUser = userService.save(newUserPayload);
        }

    }


}