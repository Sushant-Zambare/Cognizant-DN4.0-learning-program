package com.example.library.service.impl;

import com.example.library.dto.LibraryApiResponse;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public LibraryApiResponse createBook(Book book) {
        try {
            Book savedBook = bookRepository.save(book);
            return LibraryApiResponse.created(savedBook);
        } catch (Exception e) {
            return LibraryApiResponse.error(500, "Failed to create book: " + e.getMessage());
        }
    }

    @Override
    public LibraryApiResponse getAllBooks() {
        try {
            List<Book> books = bookRepository.findAll();
            return LibraryApiResponse.success("Books retrieved successfully", books);
        } catch (Exception e) {
            return LibraryApiResponse.error(500, "Failed to retrieve books: " + e.getMessage());
        }
    }

    @Override
    public LibraryApiResponse getBookById(Long id) {
        try {
            Optional<Book> book = bookRepository.findById(id);
            return book.map(value -> LibraryApiResponse.success("Book retrieved successfully", value))
                    .orElseGet(() -> LibraryApiResponse.notFound("Book not found with id: " + id));
        } catch (Exception e) {
            return LibraryApiResponse.error(500, "Failed to retrieve book: " + e.getMessage());
        }
    }

    @Override
    public LibraryApiResponse updateBook(Long id, Book bookDetails) {
        try {
            Optional<Book> existingBook = bookRepository.findById(id);
            if (existingBook.isPresent()) {
                Book book = existingBook.get();
                book.setTitle(bookDetails.getTitle());
                book.setAuthor(bookDetails.getAuthor());
                book.setIsbn(bookDetails.getIsbn());
                Book updatedBook = bookRepository.save(book);
                return LibraryApiResponse.success("Book updated successfully", updatedBook);
            } else {
                return LibraryApiResponse.notFound("Book not found with id: " + id);
            }
        } catch (Exception e) {
            return LibraryApiResponse.error(500, "Failed to update book: " + e.getMessage());
        }
    }

    @Override
    public LibraryApiResponse deleteBook(Long id) {
        try {
            if (bookRepository.existsById(id)) {
                bookRepository.deleteById(id);
                return LibraryApiResponse.success("Book deleted successfully", null);
            } else {
                return LibraryApiResponse.notFound("Book not found with id: " + id);
            }
        } catch (Exception e) {
            return LibraryApiResponse.error(500, "Failed to delete book: " + e.getMessage());
        }
    }
}
