package springbootprojects.librarymanagementsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true,nullable = false,length = 50)
    @NotBlank(message = "Author name can't be empty")
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book)
    {
        books.add(book);
        book.setAuthor(this);
    }
}
