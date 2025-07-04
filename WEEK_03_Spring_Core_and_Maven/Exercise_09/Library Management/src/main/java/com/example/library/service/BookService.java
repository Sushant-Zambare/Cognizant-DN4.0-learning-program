package com.example.library.service;

import com.example.library.dto.LibraryApiResponse;
import com.example.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    LibraryApiResponse createBook(Book book);
    LibraryApiResponse getAllBooks();
    LibraryApiResponse getBookById(Long id);
    LibraryApiResponse updateBook(Long id, Book bookDetails);
    LibraryApiResponse deleteBook(Long id);
}
