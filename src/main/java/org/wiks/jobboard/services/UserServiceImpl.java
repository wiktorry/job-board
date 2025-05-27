package org.wiks.jobboard.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.Service;
import org.wiks.jobboard.entities.User;
import org.wiks.jobboard.entities.UserCreateRequest;
import org.wiks.jobboard.entities.UserGetResponse;
import org.wiks.jobboard.exceptions.BadRequestException;
import org.wiks.jobboard.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserGetResponse createUser(UserCreateRequest userRequest) {
        throwIfUserExists(userRequest);
        User user = new User(
                0,
                userRequest.email(),
                userRequest.username(),
                passwordEncoder.encode(userRequest.password())
        );
        user = userRepository.save(user);
        return new UserGetResponse(user);
    }

    private void throwIfUserExists(UserCreateRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new BadRequestException("User with email " + userRequest.email() + " already exists");
        }
        if (userRepository.existsByUsername(userRequest.username())) {
            throw new BadRequestException("User with username " + userRequest.username() + " already exists");
        }
    }
}
