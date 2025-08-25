package springbootprojects.librarymanagementsystem.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InputClientDto
{
    @NotBlank(message = "Client name can't be empty!")
    private String name;

    @NotBlank(message = "Client username can't be empty!")
    private String username;
}
