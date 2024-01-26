package lorenza.week3project.services;

import lorenza.week3project.entities.Role;
import lorenza.week3project.entities.User;
import lorenza.week3project.exceptions.BadRequestException;
import lorenza.week3project.exceptions.UnauthorizedException;
import lorenza.week3project.payload.NewUserDTO;
import lorenza.week3project.payload.UserLoginDTO;
import lorenza.week3project.repositories.UserDAO;
import lorenza.week3project.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder bcrypt;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateUser(UserLoginDTO body) {
        User user = userService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Credenziali non valide");
        }
    }

    public User save(NewUserDTO body) {
        userDAO.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("Email " + user.getEmail() + " è già in uso");
        });

        User newUser = new User();
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setRole(Role.USER);
        return userDAO.save(newUser);
    }
}