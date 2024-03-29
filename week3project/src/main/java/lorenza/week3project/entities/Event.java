package lorenza.week3project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "event")
@Getter
@Setter
@ToString
public class Event {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String title;
    private String description;
    private LocalDateTime date;
    private String location;
    private int freeSeats;

    @OneToOne(mappedBy = "event")
    private Organizers organizersr;

}