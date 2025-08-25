package springbootprojects.librarymanagementsystem.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputAuthorDto
{
    @NotBlank(message = "Author name can't be empty!")
    private String name;

}
