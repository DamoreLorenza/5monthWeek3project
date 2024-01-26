package lorenza.week3project.services;

import lorenza.week3project.entities.User;
import lorenza.week3project.repositories.UserDAO;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.UUID;

@Service
public class UserService  {
    @Autowired
    private UserDAO userDAO;

    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
    public Page<User> getUser(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return userDAO.findAll(pageable);
    }


    public User findByUUID(UUID uuid) {
        return userDAO.findById(uuid).orElseThrow(() -> new NotFoundException(uuid));
    }

    public User findByUUIDAndUpdate(UUID uuid, User body) {
        User found = this.findByUUID(uuid);
        found.setUsername(body.getUsername());
        found.setPassword(body.getPassword());
        return userDAO.save(found);
    }

    public void findByUUIDAndDelete(UUID uuid) {
        User found = this.findByUUID(uuid);
        userDAO.delete(found);
    }
}