package com.rhiodamuthie.jpaembeddabledemo.repository;

import com.rhiodamuthie.jpaembeddabledemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    User findByEmail(String email);

}
