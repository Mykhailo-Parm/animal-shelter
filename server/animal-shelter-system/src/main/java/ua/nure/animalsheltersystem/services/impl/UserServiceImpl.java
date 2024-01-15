package ua.nure.animalsheltersystem.services.impl;

import org.springframework.stereotype.Service;
import ua.nure.animalsheltersystem.domain.entities.UserEntity;
import ua.nure.animalsheltersystem.repositories.UserRepository;
import ua.nure.animalsheltersystem.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return StreamSupport
                .stream(
                        userRepository
                                .findAll()
                                .spliterator()
                        , false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserEntity> findOne(Long id) {
        return userRepository.findById(id);
    }
}
