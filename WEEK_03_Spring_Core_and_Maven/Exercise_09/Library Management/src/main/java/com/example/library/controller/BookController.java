package com.example.library.controller;

import com.example.library.dto.LibraryApiResponse;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Book Controller", description = "APIs for managing books in the library")
@RestController
@RequestMapping(path = "/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Create a new book")
    @ApiResponse(responseCode = "201", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "500", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @PostMapping
    public ResponseEntity<LibraryApiResponse> createBook(@RequestBody Book book) {
        LibraryApiResponse response = bookService.createBook(book);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "Get all books for admin")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "500", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @GetMapping
    public ResponseEntity<LibraryApiResponse> getAllBooks() {
        LibraryApiResponse response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "Get book by ID")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "500", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @GetMapping("/{id}")
    public ResponseEntity<LibraryApiResponse> getBookById(@PathVariable Long id) {
        LibraryApiResponse response = bookService.getBookById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "Update an existing book")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "500", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @PutMapping("/{id}")
    public ResponseEntity<LibraryApiResponse> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        LibraryApiResponse response = bookService.updateBook(id, bookDetails);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "Delete a book")
    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "500", content = {
            @Content(schema = @Schema(implementation = LibraryApiResponse.class), mediaType = "application/json")})
    @DeleteMapping("/{id}")
    public ResponseEntity<LibraryApiResponse> deleteBook(@PathVariable Long id) {
        LibraryApiResponse response = bookService.deleteBook(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
