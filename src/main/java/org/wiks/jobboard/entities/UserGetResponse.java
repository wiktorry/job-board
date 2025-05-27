package org.wiks.jobboard.entities;

public record UserGetResponse(int id, String email, String username) {
    public UserGetResponse(User user) {
        this(user.getId(), user.getEmail(), user.getUsername());
    }
}
