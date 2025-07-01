package com.library;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.repository.BookRepository;
import com.library.service.BookService;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

        System.out.println("Spring context loaded successfully!");
        System.out.println("BookService bean: " + bookService);
        System.out.println("BookRepository bean: " + bookRepository);

        System.out.println("Testing dependency injection:");
        BookRepository injectedRepository = bookService.getBookRepository();
        System.out.println("Injected BookRepository: " + injectedRepository);
        System.out.println("Is same instance? " + (bookRepository == injectedRepository));
    }
}
