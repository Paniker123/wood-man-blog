package com.woodman.woodmanblog.dao.repository;

import com.woodman.woodmanblog.dao.entity.Role;
import com.woodman.woodmanblog.dao.enumObjects.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRoleName(RoleName name);
}
