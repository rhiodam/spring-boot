package com.rhiodamuthie.springbootrest.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rhiodamuthie.springbootrest.persistence.model.Foo;
import org.springframework.stereotype.Repository;

//@Repository
public interface IFooDao extends JpaRepository<Foo, Long> {

}
