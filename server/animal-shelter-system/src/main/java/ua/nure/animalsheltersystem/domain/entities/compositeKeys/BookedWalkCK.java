package ua.nure.animalsheltersystem.domain.entities.compositeKeys;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;
import ua.nure.animalsheltersystem.domain.entities.UserEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookedWalkCK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id")
    private AnimalEntity animal;
}
