package br.com.nagata.dev.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.nagata.dev.model.dto.ClienteDTO;
import br.com.nagata.dev.service.ClienteService;

@RestController
@RequestMapping(value = "/api/v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

  private ClienteService service;

  @Autowired
  public ClienteController(ClienteService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<?> saveCustomer(@Valid @RequestBody ClienteDTO cliente) {
    return ResponseEntity.created(null).body(service.saveCustomer(cliente));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getCustomerById(id));
  }
}
