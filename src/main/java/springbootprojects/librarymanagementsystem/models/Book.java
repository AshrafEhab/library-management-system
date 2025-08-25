package springbootprojects.librarymanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",unique = true,nullable = false, length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", client=" + client +
                '}';
    }
}
