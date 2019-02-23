package com.rhiodamuthie.springbootrest.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rhiodamuthie.springbootrest.persistence.IOperations;
import com.rhiodamuthie.springbootrest.persistence.model.Foo;

public interface IFooService extends IOperations<Foo> {

    Page<Foo> findPaginated(Pageable pageable);

}
