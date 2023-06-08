package com.tst.userregistrationlogin.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.tst.userregistrationlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByFirstName(String firstName);
}
