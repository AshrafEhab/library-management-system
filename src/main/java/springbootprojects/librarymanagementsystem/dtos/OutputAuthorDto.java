package springbootprojects.librarymanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Setter
@Getter
public class OutputAuthorDto
{
    private Long id;
    private String name;
    private Map<Long,String> outputBooksDto = new HashMap<>();
}
