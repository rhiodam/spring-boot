package com.rhiodamuthie.poolsbackend.repository;

import com.rhiodamuthie.poolsbackend.model.Role;
import com.rhiodamuthie.poolsbackend.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}