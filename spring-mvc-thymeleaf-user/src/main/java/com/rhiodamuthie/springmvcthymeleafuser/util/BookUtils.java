package com.rhiodamuthie.springmvcthymeleafuser.util;

import com.rhiodamuthie.springmvcthymeleafuser.model.Book;
import com.rhiodamuthie.springmvcthymeleafuser.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class BookUtils {

    @Autowired
    private BookRepository bookRepository;

    private static List<Book> books = new ArrayList<Book>();

    private static final int NUM_BOOKS = 30;

    private static final int MIN_BOOK_NUM = 1000;

    public static List<Book> buildBooks() {
        if (books.isEmpty()) {
            IntStream.range(0, NUM_BOOKS).forEach(n -> {
                books.add(new Book(MIN_BOOK_NUM + n + 1, "Spring in Action"));
//                books.add(new Book("Spring in Action"));
            });
//            System.out.println();



        }

        return books;
    }

}