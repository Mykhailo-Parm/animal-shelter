package ua.nure.animalsheltersystem.domain.DTO;

import java.time.LocalDate;

public class Animal {
    private Long id;
    private String species;
    private String breed;
    private String name;
    private LocalDate date_of_birth;
    private String gender;
    private String description;
    private String color;

    public Animal(Long id, String species, String breed, String name, LocalDate date_of_birth, String gender, String description, String color) {
        this.id = id;
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.description = description;
        this.color = color;
    }
    public Animal (Animal animal) {
        this.id = animal.getId();
        this.species = animal.getSpecies();
        this.breed = animal.getBreed();
        this.name = animal.getName();
        this.date_of_birth = animal.getDate_of_birth();
        this.gender = animal.getGender();
        this.description = animal.getDescription();
        this.color = animal.getColor();
    }

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}