package springbootprojects.librarymanagementsystem.repositories;

import springbootprojects.librarymanagementsystem.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long>
{
    boolean existsByUsername(String username);
}
