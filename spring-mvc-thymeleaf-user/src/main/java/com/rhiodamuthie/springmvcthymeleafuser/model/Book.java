package com.rhiodamuthie.springmvcthymeleafuser.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String author;

    private int pages;

    // standard constructor, setters and getters


    public Book(@NotBlank(message = "Name is mandatory") String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public Book(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public Book(int id, @NotBlank(message = "Name is mandatory") String name) {
        this.id = id;
        this.name = name;
    }
}
