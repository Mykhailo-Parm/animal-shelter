package ua.nure.animalsheltersystem.animal;

import java.time.LocalDate;

public class Cat extends Animal {
    public Cat(Long id,
               String species,
               String breed,
               String name,
               LocalDate date_of_birth,
               String gender,
               String description,
               String color) {
        super(id, species, breed, name, date_of_birth, gender, description, color);
    }

    public Cat(Animal animal) {
        super(animal);
    }
}
