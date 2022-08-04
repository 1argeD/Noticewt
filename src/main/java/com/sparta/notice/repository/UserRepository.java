package com.sparta.notice.repository;


import com.sparta.notice.model.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

//    Optional<Users> findByPassword(String password);
}
