package ua.nure.animalsheltersystem.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;
import ua.nure.animalsheltersystem.domain.entities.UserEntity;
import ua.nure.animalsheltersystem.domain.entities.compositeKeys.BookedWalkCK;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookedWalkDTO {
    private Long userId;

    private Long animalId;

    private LocalDate dateOfWalk;

    private int duration;
}
