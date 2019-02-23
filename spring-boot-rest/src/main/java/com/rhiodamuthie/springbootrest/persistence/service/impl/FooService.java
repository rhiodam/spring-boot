package com.rhiodamuthie.springbootrest.persistence.service.impl;

import java.util.List;

import com.rhiodamuthie.springbootrest.persistence.repository.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rhiodamuthie.springbootrest.persistence.dao.IFooDao;
import com.rhiodamuthie.springbootrest.persistence.model.Foo;
import com.rhiodamuthie.springbootrest.persistence.service.IFooService;
import com.rhiodamuthie.springbootrest.persistence.service.common.AbstractService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class FooService extends AbstractService<Foo> implements IFooService {

    @Autowired
    private IFooDao dao;

//    @Autowired
//    private FooRepository fooRepository;

    public FooService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Foo, Long> getDao() {
        return dao;
//        return fooRepository;
    }

    // custom methods

    @Override
    public Page<Foo> findPaginated(Pageable pageable) {
        return dao.findAll(pageable);
//        return fooRepository.findAll(pageable);
    }

    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Foo> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
