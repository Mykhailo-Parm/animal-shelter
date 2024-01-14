package ua.nure.animalsheltersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;
import ua.nure.animalsheltersystem.domain.entities.compositeKeys.BookedWalkCK;

@Repository
public interface BookedWalksRepository extends JpaRepository<BookedWalkEntity, BookedWalkCK> {
}
