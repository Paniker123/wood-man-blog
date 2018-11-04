package com.woodman.woodmanblog.dao.repository;

import com.woodman.woodmanblog.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByName(String userName);
    boolean isUserExist(String userName);
}
