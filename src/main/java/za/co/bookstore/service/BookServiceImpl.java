package za.co.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bookstore.dto.BookOrderRequest;
import za.co.bookstore.model.Book;
import za.co.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String saveBookOrder(BookOrderRequest bookOrderRequest) {
        UUID uuid = UUID.randomUUID();
        Book book = new Book();
        book.setId(uuid.toString());
        book.setIsbn(bookOrderRequest.getIsbn());
        book.setQuantity(bookOrderRequest.getQuantity());
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public List<Book> findAllBookOrders() {
        return bookRepository.findAll();
    }
}
