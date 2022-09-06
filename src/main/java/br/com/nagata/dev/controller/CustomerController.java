package br.com.nagata.dev.controller;

import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.helper.PaginationHelper;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.dto.CustomerDTO;
import br.com.nagata.dev.model.dto.CustomerFilterDTO;
import br.com.nagata.dev.model.dto.PaginationDTO;
import br.com.nagata.dev.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

  private final CustomerService service;
  private final PaginationHelper paginationHelper;

  @Autowired
  public CustomerController(CustomerService service, PaginationHelper paginationHelper) {
    this.service = service;
    this.paginationHelper = paginationHelper;
  }

  @PostMapping
  @Operation(summary = "Register new customer")
  public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDTO customer) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new CustomerDTO(service.saveCustomer(customer)));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get customer by Id")
  public ResponseEntity<?> getCustomerById(@PathVariable Long id) throws BusinessException {
    return ResponseEntity.ok(new CustomerDTO(service.getCustomerById(id)));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete customer by Id")
  public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) throws BusinessException {
    service.deleteCustomerById(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  @Operation(summary = "Get all customers using filters")
  public ResponseEntity<?> getCustomers(CustomerFilterDTO filter, PaginationDTO pagination) {
    Pageable pageable = paginationHelper.convert(pagination.getPage(), pagination.getSize());
    Page<Customer> customers = service.getCustomers(filter, pageable);
    return ResponseEntity.ok().body(paginationHelper.convert(customers.map(CustomerDTO::new)));
  }
}
