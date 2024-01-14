package ua.nure.animalsheltersystem.services;

import ua.nure.animalsheltersystem.domain.entities.UserEntity;

import java.util.List;

public interface UserService {
    public UserEntity createUser(UserEntity userEntity);

    List<UserEntity> findAll();
}
