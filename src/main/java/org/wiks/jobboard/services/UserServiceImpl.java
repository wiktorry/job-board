package org.wiks.jobboard.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.Service;
import org.wiks.jobboard.entities.User;
import org.wiks.jobboard.entities.UserCreateRequest;
import org.wiks.jobboard.entities.UserGetResponse;
import org.wiks.jobboard.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserGetResponse createUser(UserCreateRequest userRequest) {
        User user = new User(
                0,
                userRequest.email(),
                userRequest.username(),
                passwordEncoder.encode(userRequest.password())
        );
        user = userRepository.save(user);
        return new UserGetResponse(user);
    }
}
