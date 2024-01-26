package lorenza.week3project.repositories;

import lorenza.week3project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDAO extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}