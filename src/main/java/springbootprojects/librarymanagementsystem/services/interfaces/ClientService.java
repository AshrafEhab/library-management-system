package springbootprojects.librarymanagementsystem.services.interfaces;

import springbootprojects.librarymanagementsystem.dtos.InputClientDto;
import springbootprojects.librarymanagementsystem.dtos.OutputClientDto;

import java.util.List;
import java.util.Map;

public interface ClientService
{
    public List<OutputClientDto> getAllClients();
    public Map<Long, String> getBorrowedBooks(Long id);
    public Long addClient(InputClientDto inputClientDto);
}
