package ua.nure.animalsheltersystem.animal;

import org.springframework.stereotype.Service;
import ua.nure.animalsheltersystem.user.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalService {
    private final AnimalDAOImpl animalDAO;

    public AnimalService(AnimalDAOImpl animalDAO) {
        this.animalDAO = animalDAO;
    }

    public Animal getAnimal(Long id) throws SQLException {
        return animalDAO.get(id);
    }

    public List<Animal> getAnimals() throws SQLException {
        return animalDAO.getAll();
    }

    public void addNewAnimal(Animal animal) throws SQLException  {
        animalDAO.insert(animal);
    }

    public void deleteAnimal(Long id) throws SQLException  {
        animalDAO.delete(id);
    }

    public void updateAnimal(Long id,
                             String species,
                             String breed,
                             String name,
                             LocalDate date_of_birth,
                             String gender,
                             String description,
                             String color) throws SQLException  {
        Animal animal = new Animal(id, species, breed, name, date_of_birth, gender, description, color);
        animalDAO.update(animal);
    }
}
