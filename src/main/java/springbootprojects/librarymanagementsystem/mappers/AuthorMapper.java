package springbootprojects.librarymanagementsystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import springbootprojects.librarymanagementsystem.dtos.InputAuthorDto;
import springbootprojects.librarymanagementsystem.dtos.OutputAuthorDto;
import springbootprojects.librarymanagementsystem.models.Author;
import springbootprojects.librarymanagementsystem.models.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper
{

    @Mapping(target = "outputBooksDto", source = "books", qualifiedByName = "booksToBookMap")
    OutputAuthorDto toDto(Author author);
    List<OutputAuthorDto> toDtoList(List<Author> authors);

    @Named("booksToBookMap")
    default Map<Long, String> booksToBookMap(List<Book> books)
    {
        if (books == null)
        {
            return Map.of();
        }
        return books.stream()
                .collect(Collectors.toMap(Book::getId, Book::getTitle));
    }

    Author toEntity (InputAuthorDto inputAuthorDto);
}
