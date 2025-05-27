package org.wiks.jobboard.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wiks.jobboard.entities.UserCreateRequest;
import org.wiks.jobboard.entities.UserGetResponse;
import org.wiks.jobboard.services.UserService;

@RestController
@RequestMapping("/job-board/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public UserGetResponse signUp(@RequestBody UserCreateRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
