package pl.kamilderen.ztplab7.controller;

import org.springframework.web.bind.annotation.*;
import pl.kamilderen.ztplab7.model.Book;
import pl.kamilderen.ztplab7.service.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}