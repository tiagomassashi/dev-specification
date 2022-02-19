package br.com.nagata.dev.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.nagata.dev.enums.TipoClienteEnum;
import br.com.nagata.dev.helper.PaginacaoHelper;
import br.com.nagata.dev.model.ClienteEntity;
import br.com.nagata.dev.model.dto.ClienteDTO;
import br.com.nagata.dev.model.dto.PaginacaoDTO;
import br.com.nagata.dev.service.ClienteService;

@RestController
@RequestMapping(value = "/api/v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

  private ClienteService service;
  private PaginacaoHelper paginacaoHelper;

  @Autowired
  public ClienteController(ClienteService service, PaginacaoHelper paginacaoHelper) {
    this.service = service;
    this.paginacaoHelper = paginacaoHelper;
  }

  @PostMapping
  public ResponseEntity<?> saveCustomer(@Valid @RequestBody ClienteDTO cliente) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ClienteDTO(service.saveCustomer(cliente)));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
    return ResponseEntity.ok(new ClienteDTO(service.getCustomerById(id)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
    service.deleteCustomerById(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<?> getCustomers(@RequestParam(value = "nome", required = false) String nome,
      @RequestParam(value = "tipo", required = false) TipoClienteEnum tipo,
      PaginacaoDTO paginacao) {
    Pageable pageable = paginacaoHelper.converter(paginacao.getPage(), paginacao.getSize());
    Page<ClienteEntity> clientes = service.getCustomers(nome, tipo, pageable);
    return ResponseEntity.ok().body(paginacaoHelper.converter(clientes.map(ClienteDTO::new)));
  }
}
