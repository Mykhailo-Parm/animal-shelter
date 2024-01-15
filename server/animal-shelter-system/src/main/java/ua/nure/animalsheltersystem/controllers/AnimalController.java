package ua.nure.animalsheltersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.animalsheltersystem.domain.DTO.AnimalDTO;
import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;
import ua.nure.animalsheltersystem.mappers.Mapper;
import ua.nure.animalsheltersystem.services.AnimalService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/animals")
public class AnimalController {
    private AnimalService animalService;
    private Mapper<AnimalEntity, AnimalDTO> animalMapper;

    public AnimalController(AnimalService animalService, Mapper<AnimalEntity, AnimalDTO> animalMapper) {
        this.animalService = animalService;
        this.animalMapper = animalMapper;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<AnimalDTO> getAnimal(@PathVariable("id") Long id) {
        Optional<AnimalEntity> foundAnimal = animalService.findOne(id);
        return foundAnimal
                .map(animalEntity -> new ResponseEntity<>(
                        animalMapper.mapTo(animalEntity),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<AnimalDTO> getAnimals() {
        List<AnimalEntity> animals = animalService.findAll();
        return animals
                .stream()
                .map(animalMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> createNewAnimal(@RequestBody AnimalDTO animalDTO) {
        AnimalEntity animalEntity = animalMapper.mapFrom(animalDTO);
        AnimalEntity savesAnimalEntity = animalService.createAnimal(animalEntity);

        return new ResponseEntity<>(animalMapper.mapTo(savesAnimalEntity), HttpStatus.CREATED);
    }

//    @DeleteMapping(path = "{animalId}")
//    public void deleteAnimal(@PathVariable("animalId") Long id) throws SQLException {
//        animalService.deleteAnimal(id);
//    }
//
//    @PutMapping(path = "{animalId}")
//    public void updateAnimal (@PathVariable("animalId") Long id,
//                           @RequestParam(required = false) String species,
//                           @RequestParam(required = false) String breed,
//                           @RequestParam(required = false) String name,
//                           @RequestParam(required = false) LocalDate dob,
//                           @RequestParam(required = false) String gender,
//                           @RequestParam(required = false) String description,
//                           @RequestParam(required = false) String color) throws SQLException  {
//        animalService.updateAnimal(id, species, breed, name, dob, gender, description, color);
//    }

}
