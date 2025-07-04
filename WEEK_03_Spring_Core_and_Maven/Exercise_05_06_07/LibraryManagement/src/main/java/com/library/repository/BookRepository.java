package com.library.repository;

import org.springframework.stereotype.Repository;


@Repository //Exercise_06
public class BookRepository {
    public BookRepository() {
        System.out.println("BookRepository created");
    }

    @Override
    public String toString() {
        return "BookRepository instance";
    }
}
