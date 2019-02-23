package com.rhiodamuthie.springbootrest.persistence.repository;

import com.rhiodamuthie.springbootrest.persistence.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository <Foo, Long> {
}
