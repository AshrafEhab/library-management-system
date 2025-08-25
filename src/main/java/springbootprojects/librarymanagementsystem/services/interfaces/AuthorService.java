package springbootprojects.librarymanagementsystem.services.interfaces;

import springbootprojects.librarymanagementsystem.dtos.InputAuthorDto;
import springbootprojects.librarymanagementsystem.dtos.OutputAuthorDto;

import java.util.List;

public interface AuthorService
{
    public List<OutputAuthorDto> getAllAuthors();
    public Long addAuthor(InputAuthorDto inputAuthorDto);
}
