package com.upao.api_book.controller;

import com.upao.api_book.model.Book;
import com.upao.api_book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity<List<Book>>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestParam String title,
                                        @RequestParam String author,
                                        @RequestParam String description,
                                        @RequestParam MultipartFile image){
        Book book1 = bookService.createBook(title,author,description,image);
        return ResponseEntity.ok(book1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id,
                                                @RequestParam String title,
                                               @RequestParam String author,
                                               @RequestParam String description,
                                               @RequestParam MultipartFile image){
        Book book1 = bookService.updateBook(id,title,author,description,image);
        return ResponseEntity.ok(book1);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
