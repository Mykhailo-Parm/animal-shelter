package ua.nure.animalsheltersystem.animal;

import java.time.LocalDate;

class Persian extends Cat {
    public Persian(Long id,
                   String species,
                   String breed,
                   String name,
                   LocalDate date_of_birth,
                   String gender,
                   String description,
                   String color) {
        super(id, species, breed, name, date_of_birth, gender, description, color);
    }

    public Persian(Animal animal) {
        super(animal);
    }
}
