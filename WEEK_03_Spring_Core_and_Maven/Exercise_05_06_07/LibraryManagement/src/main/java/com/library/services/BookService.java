package com.library.services;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service  //Exercise_06
public class BookService {
    private BookRepository bookRepository;

    //Exercise_07
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService created with constructor injection");
    }

    //Exercise_05 && Exercise_07
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService configured with setter injection");
    }

    public void displayBooks() {
        System.out.println("BookService is working with: " + bookRepository);
    }
}
