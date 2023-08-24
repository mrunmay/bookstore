package za.co.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
