package com.rhiodamuthie.jpaembeddabledemo.repository;

import com.rhiodamuthie.jpaembeddabledemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    User findByEmail(String email);

    // Find users by firstName
    List<User> findByNameFirstName(String firstName);

    // Find users by lastName
    List<User> findByNameLastName(String lastName);

    // Find users by country
    List<User> findByAddressCountry(String country);

}
