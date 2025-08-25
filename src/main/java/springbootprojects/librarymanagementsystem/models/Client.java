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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Client name can't be empty")
    private String name;

    @Column(name = "username",unique = true, nullable = false, length = 50)
    @NotBlank(message = "Client username can't be empty")
    private String username;



    @OneToMany(mappedBy = "client")
    private List<Book> borrowedBooks = new ArrayList<>();

    public void borrowBook(Book book)
    {
        borrowedBooks.add(book);
        book.setClient(this);
    }
}
