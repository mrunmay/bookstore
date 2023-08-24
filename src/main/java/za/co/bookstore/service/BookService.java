package za.co.bookstore.service;

import za.co.bookstore.dto.BookOrderRequest;
import za.co.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Long saveBookOrder(BookOrderRequest bookOrderRequest);

    List<Book> findAllBookOrders();
}
