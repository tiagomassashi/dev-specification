package br.com.nagata.dev.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.helper.PaginationHelper;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.dto.CustomerDTO;
import br.com.nagata.dev.model.dto.CustomerFilterDTO;
import br.com.nagata.dev.model.dto.PaginationDTO;
import br.com.nagata.dev.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

  @InjectMocks private CustomerController controller;
  @Mock private CustomerService service;
  @Mock private PaginationHelper paginationHelper;

  @Test
  void testSaveCustomerSuccess(@Mock CustomerDTO dto, @Mock Customer entity) {
    when(service.saveCustomer(Mockito.any())).thenReturn(entity);
    ResponseEntity<?> response = controller.saveCustomer(dto);
    assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Expected return code 201");
  }

  @Test
  void testGetCustomerByIdSuccess(@Mock Customer entity) throws BusinessException {
    when(service.getCustomerById(Mockito.anyLong())).thenReturn(entity);
    ResponseEntity<?> response = controller.getCustomerById(1l);
    assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected return code 200");
  }

  @Test
  void testDeleteCustomerByIdSuccess(@Mock Customer entity) throws BusinessException {
    ResponseEntity<?> response = controller.deleteCustomerById(1l);
    assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected return code 200");
  }

  @Test
  void testGetCustomersSuccess(@Mock CustomerFilterDTO filter) {
    PaginationDTO pagination = new PaginationDTO(1, 10);
    when(service.getCustomers(Mockito.any(), Mockito.any())).thenReturn(new PageImpl<Customer>(new ArrayList<Customer>()));
    ResponseEntity<?> response = controller.getCustomers(filter, pagination);
    assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected return code 200");
  }
}
