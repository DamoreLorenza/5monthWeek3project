package lorenza.week3project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User{
    @Id
    @GeneratedValue
    private UUID uuid;

    private String username;
    private String password;
    private boolean isOrganizer;

}