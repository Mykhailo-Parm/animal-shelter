package ua.nure.animalsheltersystem.animal;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.animalsheltersystem.user.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/animals")
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(path = "{animalId}")
    public Animal getAnimal(@PathVariable("animalId") Long id) throws SQLException {
        return animalService.getAnimal(id);
    }

    @GetMapping
    public List<Animal> getAnimals() throws SQLException {
        return animalService.getAnimals();
    }

    @PostMapping
    public void registerNewAnimal(@RequestBody Animal animal) throws SQLException {
        System.out.println(animal);
        animalService.addNewAnimal(animal);

    }

    @DeleteMapping(path = "{animalId}")
    public void deleteAnimal(@PathVariable("animalId") Long id) throws SQLException {
        animalService.deleteAnimal(id);
    }

    @PutMapping(path = "{animalId}")
    public void updateAnimal (@PathVariable("animalId") Long id,
                           @RequestParam(required = false) String species,
                           @RequestParam(required = false) String breed,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) LocalDate dob,
                           @RequestParam(required = false) String gender,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) String color) throws SQLException  {
        animalService.updateAnimal(id, species, breed, name, dob, gender, description, color);
    }

}
