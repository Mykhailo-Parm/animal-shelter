package ua.nure.animalsheltersystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.nure.animalsheltersystem.domain.entities.compositeKeys.BookedWalkCK;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "booked_walks")
public class BookedWalkEntity {
    @EmbeddedId
    private BookedWalkCK id;

    @Column(name = "date_of_walk")
    private LocalDate dateOfWalk;

    private String duration;

//    @PrePersist
//    public void prePersist() {
//        // Ensure the embedded ID is properly set before persisting
//        if (id == null) {
//            id = new BookedWalkCK();
//            id.setUser(user);
//            id.setAnimal(animal);
//        }
//    }
}
