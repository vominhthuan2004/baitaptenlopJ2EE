package com.example.bai2.Service;

import org.springframework.stereotype.Service;
import com.example.bai2.Model.Book;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {
    
    private List<Book> books = new ArrayList<>();
    
    public BookService() {
        // Khởi tạo dữ liệu mẫu
        books.add(new Book(1, "Spring in Action", "Craig Walls"));
        books.add(new Book(2, "Java Programming", "Hoang Van Minh"));
    }
    
    public List<Book> getAllBooks() {
        return books;
    }
    
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public String updateBook(int id, Book updatedBook) {
        Book existingBook = getBookById(id);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            return "Book updated successfully!";
        }
        return "Book not found!";
    }
    
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
