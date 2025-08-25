package springbootprojects.librarymanagementsystem.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootprojects.librarymanagementsystem.dtos.InputAuthorDto;
import springbootprojects.librarymanagementsystem.dtos.OutputAuthorDto;
import springbootprojects.librarymanagementsystem.services.interfaces.AuthorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController
{
//    public static final String AUTHORS_URL = "/api/v1/authors";
    public final AuthorService authorService;


    @GetMapping
    public ResponseEntity<List<OutputAuthorDto>> getAllAuthors()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<Long> addAuthor(@Valid @RequestBody InputAuthorDto inputAuthorDto)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorService.addAuthor(inputAuthorDto));
    }
}
