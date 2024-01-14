package ua.nure.animalsheltersystem.services;

import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;

import java.util.List;

public interface AnimalService {
    public AnimalEntity createAnimal(AnimalEntity animalEntity);

    List<AnimalEntity> findAll();
}
