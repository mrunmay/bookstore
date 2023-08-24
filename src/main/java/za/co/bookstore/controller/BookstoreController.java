package za.co.bookstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.bookstore.dto.BookOrderRequest;
import za.co.bookstore.model.Book;
import za.co.bookstore.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookstore")
@Api(value = "Book store order controller")
@Validated
@CrossOrigin("*")
public class BookstoreController {

    private BookService bookService;

    public BookstoreController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/order",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createOrder(@Valid @RequestBody BookOrderRequest bookOrderRequest) {
        Long bookOrderId = bookService.saveBookOrder(bookOrderRequest);
        return new ResponseEntity<>("Book ordered with ID = " + bookOrderId, HttpStatus.CREATED);
    }

    @ApiOperation("Get all orders")
    @GetMapping(path = "/allorders",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Book>> getAllOrders() {
        List<Book> allBookOrders = bookService.findAllBookOrders();
        return new ResponseEntity<>(allBookOrders, HttpStatus.OK);
    }
}
