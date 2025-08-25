package springbootprojects.librarymanagementsystem.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputBookDto
{
    @NotNull(message = "Book title can't be empty!")
    private String title;

    @NotNull(message = "authorId can't be empty!")
    private Long authorId;

    private Long clientId;
}
