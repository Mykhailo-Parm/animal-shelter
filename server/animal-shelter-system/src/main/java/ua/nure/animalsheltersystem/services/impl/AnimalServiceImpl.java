package ua.nure.animalsheltersystem.services.impl;

import org.springframework.stereotype.Service;
import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;
import ua.nure.animalsheltersystem.repositories.AnimalRepository;
import ua.nure.animalsheltersystem.services.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public AnimalEntity createAnimal(AnimalEntity animalEntity) {
        return animalRepository.save(animalEntity);
    }

    @Override
    public List<AnimalEntity> findAll() {
        return StreamSupport
                .stream(
                        animalRepository
                                .findAll()
                                .spliterator()
                        , false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnimalEntity> findOne(Long id) {
        return animalRepository.findById(id);
    }
}
