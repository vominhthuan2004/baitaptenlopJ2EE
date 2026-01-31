package com.example.bai2.Controller;

import com.example.bai2.Model.Book;
import com.example.bai2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // ------------------- LIST -------------------
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // ------------------- ADD FORM -------------------
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // ------------------- ADD ACTION -------------------
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // ------------------- EDIT FORM -------------------
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {

        Book book = bookService.getBookById(id)
                .orElse(null);

        if (book == null) {
            return "redirect:/books";  // Không tìm thấy ID → quay lại danh sách
        }

        model.addAttribute("book", book);
        return "edit-book";
    }

    // ------------------- UPDATE ACTION -------------------
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // ------------------- DELETE -------------------
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}   
