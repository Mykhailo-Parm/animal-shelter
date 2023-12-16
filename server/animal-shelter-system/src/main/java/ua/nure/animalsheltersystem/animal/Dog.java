package ua.nure.animalsheltersystem.animal;

import java.time.LocalDate;

public class Dog extends Animal {
    public Dog(Long id,
               String species,
               String breed,
               String name,
               LocalDate date_of_birth,
               String gender,
               String description,
               String color) {
        super(id, species, breed, name, date_of_birth, gender, description, color);
    }

    public Dog(Animal animal) {
        super(animal);
    }
}