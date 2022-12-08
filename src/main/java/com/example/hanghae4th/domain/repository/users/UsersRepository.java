package com.example.hanghae4th.domain.repository.users;

import com.example.hanghae4th.domain.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
