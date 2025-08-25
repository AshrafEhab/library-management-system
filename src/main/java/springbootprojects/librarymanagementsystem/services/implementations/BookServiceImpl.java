package springbootprojects.librarymanagementsystem.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootprojects.librarymanagementsystem.dtos.InputBookDto;
import springbootprojects.librarymanagementsystem.dtos.OutputBookDto;
import springbootprojects.librarymanagementsystem.exceptions.ResourceAlreadyExistsException;
import springbootprojects.librarymanagementsystem.exceptions.ResourceNotFoundException;
import springbootprojects.librarymanagementsystem.mappers.BookMapper;
import springbootprojects.librarymanagementsystem.models.Author;
import springbootprojects.librarymanagementsystem.models.Book;
import springbootprojects.librarymanagementsystem.models.Client;
import springbootprojects.librarymanagementsystem.repositories.AuthorRepository;
import springbootprojects.librarymanagementsystem.repositories.BookRepository;
import springbootprojects.librarymanagementsystem.repositories.ClientRepository;
import springbootprojects.librarymanagementsystem.services.interfaces.BookService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService
{
    public final BookMapper bookMapper;
    public final BookRepository bookRepository;
    public final ClientRepository clientRepository;
    public final AuthorRepository authorRepository;

    @Override
    public List<OutputBookDto> getAllBooks()
    {
        List<Book> books =  bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }

    @Override
    public OutputBookDto getBookById(Long id)
    {
        Book book =  bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));
        return bookMapper.toDto(book);
    }

    @Override
    public Long addBook(InputBookDto inputBookDto)
    {
        boolean bookAlreadyExists = bookRepository.existsByTitle(inputBookDto.getTitle());
        if (bookAlreadyExists)
        {
            throw new ResourceAlreadyExistsException("Book already exists!");
        }

        Author author = authorRepository.findById(inputBookDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author with ID " + inputBookDto.getAuthorId() + " not found"));
        Book book = bookMapper.toEntity(inputBookDto);

        author.addBook(book);
        bookRepository.save(book);
        authorRepository.save(author);
        return bookMapper.toDto(book).getId();
    }


    @Override
    public Long updateBook(Long id, InputBookDto updatedInputBookDto)
    {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));
        Author author = authorRepository.findById(updatedInputBookDto.getAuthorId()).orElseThrow(() -> new ResourceNotFoundException("Author with ID " + updatedInputBookDto.getAuthorId() + " not found"));
        Client client = clientRepository.findById(updatedInputBookDto.getClientId()).orElse(null);

        bookMapper.updateFromDto(updatedInputBookDto,book);
        System.out.println(book.toString());
        if (client != null)
        {
            client.borrowBook(book);
            clientRepository.save(client);
        }

        author.addBook(book);
        authorRepository.save(author);
        bookRepository.save(book);
        return bookMapper.toDto(book).getId();
    }

    @Override
    public void deleteBook(Long id)
    {
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with ID " + id + " not found"));
        bookRepository.deleteById(id);
    }
}




