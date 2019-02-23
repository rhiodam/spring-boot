package com.rhiodamuthie.springmvcthymeleafuser.repository;

import com.rhiodamuthie.springmvcthymeleafuser.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book , Integer> {
}