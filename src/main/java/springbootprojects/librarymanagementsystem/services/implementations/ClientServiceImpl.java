package springbootprojects.librarymanagementsystem.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootprojects.librarymanagementsystem.dtos.InputClientDto;
import springbootprojects.librarymanagementsystem.dtos.OutputClientDto;
import springbootprojects.librarymanagementsystem.exceptions.ResourceAlreadyExistsException;
import springbootprojects.librarymanagementsystem.exceptions.ResourceNotFoundException;
import springbootprojects.librarymanagementsystem.mappers.ClientMapper;
import springbootprojects.librarymanagementsystem.models.Client;
import springbootprojects.librarymanagementsystem.repositories.ClientRepository;
import springbootprojects.librarymanagementsystem.services.interfaces.ClientService;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService
{
    public final ClientMapper clientMapper;
    public final ClientRepository clientRepository;

    @Override
    public List<OutputClientDto> getAllClients()
    {
        List<Client> clients =  clientRepository.findAll();
        return clientMapper.toDtoList(clients);
    }

    @Override
    public Map<Long, String> getBorrowedBooks(Long id)
    {
        Client client =  clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with ID " + id + " not found"));
        OutputClientDto outputClientDto = clientMapper.toDto(client);
        return outputClientDto.getBorrowedOutputBooksDto();
    }

    @Override
    public Long addClient(InputClientDto inputClientDto)
    {
        boolean usernameAlreadyExists = clientRepository.existsByUsername(inputClientDto.getUsername());
        if (usernameAlreadyExists)
        {
            throw new ResourceAlreadyExistsException("Username already exists");
        }

        Client client = clientMapper.toEntity(inputClientDto);
        clientRepository.save(client);
        return clientMapper.toDto(client).getId();
    }

}
