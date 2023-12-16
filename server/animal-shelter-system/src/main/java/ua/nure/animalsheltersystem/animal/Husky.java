package ua.nure.animalsheltersystem.animal;

import java.time.LocalDate;

class Husky extends Dog {
    public Husky(Long id,
                 String species,
                 String breed,
                 String name,
                 LocalDate date_of_birth,
                 String gender,
                 String description,
                 String color) {
        super(id, species, breed, name, date_of_birth, gender, description, color);
    }

    public Husky(Animal animal) {
        super(animal);
    }
}
