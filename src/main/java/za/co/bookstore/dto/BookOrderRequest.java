package za.co.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class BookOrderRequest implements Serializable {
    private static final long serialVersionUID = 282326870302932719L;

    @NotEmpty(message = "isbn cannot be emptyyy")
    private String isbn;

    private int quantity;
}
