package springbootprojects.librarymanagementsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springbootprojects.librarymanagementsystem.dtos.InputClientDto;
import springbootprojects.librarymanagementsystem.dtos.OutputClientDto;
import org.springframework.web.bind.annotation.*;
import springbootprojects.librarymanagementsystem.services.interfaces.ClientService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController

public class ClientController
{
    public static final String CLIENTS_ID = "clientId";
    public static final String CLIENTS_URL = "/api/v1/clients";
    public static final String CLIENTS_URL_ID = CLIENTS_URL + "/{" + CLIENTS_ID + "}";
    public static final String CLIENTS_BOOKS_URL = CLIENTS_URL_ID + "/books";

    private final ClientService clientService;

    @GetMapping(CLIENTS_URL)
    public ResponseEntity<List<OutputClientDto>> getAllClients()
    {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }

    @PostMapping(CLIENTS_URL)
    public ResponseEntity<Long> addClient(@RequestBody InputClientDto inputClientDto)
    {
         return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(inputClientDto));
    }

    @GetMapping(CLIENTS_BOOKS_URL)
    public ResponseEntity<Map<Long, String>> getBorrowedBooks(@PathVariable(CLIENTS_ID) Long client_id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getBorrowedBooks(client_id));
    }

}
