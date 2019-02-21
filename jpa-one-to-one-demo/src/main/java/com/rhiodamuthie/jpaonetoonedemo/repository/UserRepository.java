package com.rhiodamuthie.jpaonetoonedemo.repository;

import com.rhiodamuthie.jpaonetoonedemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
