package springbootprojects.librarymanagementsystem.repositories;

import springbootprojects.librarymanagementsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long>
{
    boolean existsByTitle(String title);
}
