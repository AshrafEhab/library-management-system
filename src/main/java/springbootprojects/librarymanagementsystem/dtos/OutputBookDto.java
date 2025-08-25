package springbootprojects.librarymanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OutputBookDto
{
    private Long id;
    private String title;
    private Long authorId;
    private Long clientId;
}
