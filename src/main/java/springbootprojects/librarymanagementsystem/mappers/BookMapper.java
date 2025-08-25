package springbootprojects.librarymanagementsystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import springbootprojects.librarymanagementsystem.dtos.InputBookDto;
import springbootprojects.librarymanagementsystem.dtos.OutputBookDto;
import springbootprojects.librarymanagementsystem.models.Book;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {


    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "client.id", target = "clientId")
    OutputBookDto toDto (Book book);
    List<OutputBookDto> toDtoList (List<Book> book);

    Book toEntity (InputBookDto inputBookDto);
    void updateFromDto(InputBookDto inputBookDto, @MappingTarget Book book);
}
