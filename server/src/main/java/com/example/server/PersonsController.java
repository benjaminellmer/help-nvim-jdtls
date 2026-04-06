package com.example.server;

import com.example.server.generated.api.PersonsApi;
import com.example.server.generated.model.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonsController implements PersonsApi {
    private static final List<PersonDTO> PERSONS = List.of(
        new PersonDTO(
            UUID.fromString("11111111-1111-1111-1111-111111111111"),
            "Alice",
            "alice@example.com"
        ),
        new PersonDTO(
            UUID.fromString("22222222-2222-2222-2222-222222222222"),
            "Bob",
            "bob@example.com"
        )
    );

    @Override
    public ResponseEntity<List<PersonDTO>>getPersons() {
        return ResponseEntity.ok(PERSONS);
    }
}
