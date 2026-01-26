package com.example.bai2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bai2.Model.Book;
import com.example.bai2.Service.BookService;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully!";
    }
    
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    @PutMapping
    public String updateBook(@RequestBody Book updatedBook) {
        // cho phép PUT tới /api/books với id nằm trong body
        return bookService.updateBook(updatedBook.getId(), updatedBook);
    }
    
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }

    @DeleteMapping
    public String deleteBook(@RequestBody Book book) {
        // Hỗ trợ DELETE /api/books với body chứa { "id": ... }
        bookService.deleteBook(book.getId());
        return "Book deleted successfully!";
    }
}
    