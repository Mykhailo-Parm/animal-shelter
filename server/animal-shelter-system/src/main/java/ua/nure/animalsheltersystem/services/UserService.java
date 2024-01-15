package ua.nure.animalsheltersystem.services;

import ua.nure.animalsheltersystem.domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserEntity createUser(UserEntity userEntity);

    List<UserEntity> findAll();


    Optional<UserEntity> findOne(Long id);
}
