package pl.kamilderen.ztplab7.service;

import org.springframework.stereotype.Service;
import pl.kamilderen.ztplab7.model.Book;
import pl.kamilderen.ztplab7.repository.BookRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Mono<Book> addBook(Book book) {
        return bookRepository.save(book);
    }
}