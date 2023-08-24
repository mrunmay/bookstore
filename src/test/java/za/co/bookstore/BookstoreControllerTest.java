package za.co.bookstore;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.bookstore.controller.BookstoreController;
import za.co.bookstore.dto.BookOrderRequest;
import za.co.bookstore.model.Book;
import za.co.bookstore.service.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookstoreControllerTest {

    @InjectMocks
    private BookstoreController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void testCreateOrder() {
        BookOrderRequest orderRequest = new BookOrderRequest(); // Create a valid order request object

        when(bookService.saveBookOrder(orderRequest)).thenReturn(1L); // Mock the service method

        ResponseEntity<String> response = bookController.createOrder(orderRequest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Book ordered with ID = 1", response.getBody());

        verify(bookService, times(1)).saveBookOrder(orderRequest); // Verify the service method was called
    }

    @Test
    public void testGetAllOrders() {
        List<Book> mockBookList = new ArrayList<>(); // Create a mock list of books

        when(bookService.findAllBookOrders()).thenReturn(mockBookList); // Mock the service method

        ResponseEntity<List<Book>> response = bookController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockBookList, response.getBody());

        verify(bookService, times(1)).findAllBookOrders(); // Verify the service method was called
    }
}
