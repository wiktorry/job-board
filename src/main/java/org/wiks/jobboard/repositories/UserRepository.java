package org.wiks.jobboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wiks.jobboard.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
