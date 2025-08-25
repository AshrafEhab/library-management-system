package springbootprojects.librarymanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Setter
@Getter
public class OutputClientDto
{
    private Long id;
    private String name;
    private String username;
    private Map<Long,String> borrowedOutputBooksDto = new HashMap<>();
}
