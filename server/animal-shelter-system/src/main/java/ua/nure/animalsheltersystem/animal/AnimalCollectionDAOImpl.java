package ua.nure.animalsheltersystem.animal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnimalCollectionDAOImpl implements AnimalDAO {
    private static final List<Animal> animals = new ArrayList<Animal>();

    static {
        animals.add(new Animal(1L,
                "dog",
                "Husky",
                "Rick",
                LocalDate.parse("2020-06-15"),
                "male",
                "Say hello to our Husky, " +
                        "a spirited friend with a heart of gold! This lovable dog's radiant coat and " +
                        "friendly demeanor make it an ideal cuddle buddy and an enthusiastic adventurer, " +
                        "all wrapped in one furry package.",
                "grey"));
        animals.add(new Animal(2L,
                "car",
                "Persian",
                "Mia",
                LocalDate.parse("2023-12-12"),
                "female",
                "Meet our Persian cat, the epitome of grace and elegance! With its luxurious, " +
                        "flowing coat and gentle disposition, " +
                        "this feline companion embodies sophistication and tranquility, " +
                        "adding a touch of regal charm to any home.",
                "black"));
        animals.add(new Animal(1L,
                "dog",
                "Husky",
                "John",
                LocalDate.parse("2023-12-10"),
                "male",
                "Some info",
                "grey"));
    }
    @Override
    public Animal get(Long id) throws SQLException {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() throws SQLException {
        return animals;
    }

    @Override
    public int save(Animal animal) throws SQLException {
        if (animal.getId()!=null && get(animal.getId()) != null) {
            update(animal);
        } else {
            insert(animal);
        }
        return 0;
    }

    @Override
    public void insert(Animal animal) throws SQLException {
        animals.add(animal);
    }

    @Override
    public void update(Animal updatedAnimal) throws SQLException {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), updatedAnimal.getId())) {
                animal.setSpecies(updatedAnimal.getSpecies());
                animal.setBreed(updatedAnimal.getBreed());
                animal.setName(updatedAnimal.getName());
                animal.setDate_of_birth(updatedAnimal.getDate_of_birth());
                animal.setGender(updatedAnimal.getGender());
                animal.setDescription(updatedAnimal.getDescription());
                animal.setColor(updatedAnimal.getColor());
            }
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        animals.removeIf(animal -> Objects.equals(animal.getId(), id));
    }
}
