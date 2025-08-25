package springbootprojects.librarymanagementsystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import springbootprojects.librarymanagementsystem.dtos.InputClientDto;
import springbootprojects.librarymanagementsystem.dtos.OutputClientDto;
import springbootprojects.librarymanagementsystem.models.Book;
import springbootprojects.librarymanagementsystem.models.Client;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClientMapper
{
    @Mapping(target = "borrowedOutputBooksDto", source = "borrowedBooks", qualifiedByName = "borrowedBooksToBookMap")
    OutputClientDto toDto (Client client);
    List<OutputClientDto> toDtoList (List<Client> client);

    @Named("borrowedBooksToBookMap")
    default Map<Long, String> borrowedBooksToBookMap(List<Book> books)
    {
        if (books == null)
        {
            return Map.of();
        }
        return books.stream()
                .collect(Collectors.toMap(Book::getId, Book::getTitle));
    }

    Client toEntity (InputClientDto inputClientDto);
}
