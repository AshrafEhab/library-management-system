package springbootprojects.librarymanagementsystem.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springbootprojects.librarymanagementsystem.dtos.InputBookDto;
import springbootprojects.librarymanagementsystem.dtos.OutputBookDto;
import org.springframework.web.bind.annotation.*;
import springbootprojects.librarymanagementsystem.services.interfaces.BookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController
{
    public static final String BOOK_ID = "bookId";
    public static final String BOOKS_URL = "/api/v1/books";
    public static final String BOOKS_ID_URL = BOOKS_URL + "/{" + BOOK_ID + "}";

    public final BookService bookService;

    @GetMapping(BOOKS_URL)
    public ResponseEntity<List<OutputBookDto>> getAllBooks()
    {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping(BOOKS_ID_URL)
    public ResponseEntity<OutputBookDto> getBookById(@Valid @PathVariable(BOOK_ID) Long book_id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(book_id));
    }

    @PostMapping(BOOKS_URL)
    public ResponseEntity<Long> addBook(@Valid @RequestBody InputBookDto inputBookDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(inputBookDto));
    }


    @PutMapping(BOOKS_ID_URL)
    public ResponseEntity<Long> updateBook(@Valid @PathVariable(BOOK_ID) Long book_id, @RequestBody InputBookDto updatedOutputBookDto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(book_id, updatedOutputBookDto));
    }

    @DeleteMapping(BOOKS_ID_URL)
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable(BOOK_ID) Long book_id)
    {
        bookService.deleteBook(book_id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
