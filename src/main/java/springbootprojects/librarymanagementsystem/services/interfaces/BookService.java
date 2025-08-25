package springbootprojects.librarymanagementsystem.services.interfaces;

import springbootprojects.librarymanagementsystem.dtos.InputBookDto;
import springbootprojects.librarymanagementsystem.dtos.OutputBookDto;

import java.util.List;

public interface BookService
{
    List<OutputBookDto> getAllBooks();
    OutputBookDto getBookById(Long id);
    Long addBook(InputBookDto inputBookDto);
    Long updateBook(Long id, InputBookDto updatedInputBookDto);
    void deleteBook(Long id);
}
