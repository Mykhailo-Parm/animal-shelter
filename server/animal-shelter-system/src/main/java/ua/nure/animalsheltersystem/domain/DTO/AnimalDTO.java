package ua.nure.animalsheltersystem.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDTO {
    private Long id;

    private String species;

    private String breed;

    private String name;

    private LocalDate dateOfBirth;

    private String gender;

    private String description;

    private String color;
}