package springbootprojects.librarymanagementsystem.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootprojects.librarymanagementsystem.dtos.InputAuthorDto;
import springbootprojects.librarymanagementsystem.dtos.OutputAuthorDto;
import springbootprojects.librarymanagementsystem.exceptions.ResourceAlreadyExistsException;
import springbootprojects.librarymanagementsystem.mappers.AuthorMapper;
import springbootprojects.librarymanagementsystem.models.Author;
import springbootprojects.librarymanagementsystem.repositories.AuthorRepository;
import springbootprojects.librarymanagementsystem.services.interfaces.AuthorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService
{
    public final AuthorMapper authorMapper;
    public final AuthorRepository authorRepository;

    @Override
    public List<OutputAuthorDto> getAllAuthors()
    {
        List<Author> authors =  authorRepository.findAll();
        return authorMapper.toDtoList(authors);
    }

    @Override
    public Long addAuthor(InputAuthorDto inputAuthorDto)
    {
        boolean authorAlreadyExists = authorRepository.existsByName(inputAuthorDto.getName());
        if (authorAlreadyExists)
        {
            throw new ResourceAlreadyExistsException("Author already exists!");
        }

        Author author = authorMapper.toEntity(inputAuthorDto);
        authorRepository.save(author);
        return authorMapper.toDto(author).getId();
    }
}
