package com.rhiodamuthie.springbootrest.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rhiodamuthie.springbootrest.persistence.model.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {

}
