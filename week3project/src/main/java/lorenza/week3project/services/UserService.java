package lorenza.week3project.services;

import lorenza.week3project.entities.User;
import lorenza.week3project.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private UserDAO userDAO;

    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

}