package lorenza.week3project.controller;

import lorenza.week3project.entities.User;
import lorenza.week3project.exceptions.BadRequestException;
import lorenza.week3project.payload.NewUserDTO;
import lorenza.week3project.payload.NewUserResponseDTO;
import lorenza.week3project.payload.UserLoginDTO;
import lorenza.week3project.payload.UserLoginResponseDTO;
import lorenza.week3project.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body) {
        String accessToken = authService.authenticateUser(body);
        return new UserLoginResponseDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserResponseDTO createUser(@RequestBody @Validated NewUserDTO newUserPayload, BindingResult validation) {
        System.out.println(validation);
        if (validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("Ci sono errori nel payload!");
        } else {
            User newUser = authService.save(newUserPayload);

            return new NewUserResponseDTO(newUser.getUuid());
        }
    }
}