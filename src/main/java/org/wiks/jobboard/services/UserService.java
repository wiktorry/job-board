package org.wiks.jobboard.services;

import org.wiks.jobboard.entities.UserCreateRequest;
import org.wiks.jobboard.entities.UserGetResponse;

public interface UserService {
    UserGetResponse createUser(UserCreateRequest userRequest);
}
