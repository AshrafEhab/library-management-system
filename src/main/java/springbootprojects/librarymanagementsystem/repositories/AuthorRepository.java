package springbootprojects.librarymanagementsystem.repositories;

import springbootprojects.librarymanagementsystem.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
    boolean existsByName(String name);
}
