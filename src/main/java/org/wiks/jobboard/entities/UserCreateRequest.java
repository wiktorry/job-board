package org.wiks.jobboard.entities;

public record UserCreateRequest(String email, String username, String password) {
}
