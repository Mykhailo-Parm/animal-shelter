package ua.nure.animalsheltersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;
import ua.nure.animalsheltersystem.domain.entities.compositeKeys.BookedWalkCK;

import java.util.Optional;

@Repository
public interface BookedWalkRepository extends JpaRepository<BookedWalkEntity, BookedWalkCK> {
    Optional<BookedWalkEntity> findOneByUser_IdAndAnimal_Id(Long userId, Long animalId);

}
