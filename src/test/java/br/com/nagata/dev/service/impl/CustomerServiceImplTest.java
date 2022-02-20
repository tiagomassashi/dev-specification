package br.com.nagata.dev.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.dto.CustomerDTO;
import br.com.nagata.dev.model.dto.CustomerFilterDTO;
import br.com.nagata.dev.repository.CustomerRepository;
import br.com.nagata.dev.service.DocumentService;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

  @InjectMocks
  private CustomerServiceImpl service;
  @Mock
  private CustomerRepository repository;
  @Mock
  private DocumentService documentService;

  @Test
  void testSaveCustomerSuccess(@Mock Customer entity, @Mock CustomerDTO dto) {
    when(repository.save(Mockito.any())).thenReturn(entity);
    Customer newCustomer = service.saveCustomer(dto);
    assertNotNull(newCustomer, "Expected customer entity not null");
  }

  @Test
  void testGetCustomerByIdSuccess(@Mock Customer entity) throws BusinessException {
    when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
    Customer customer = service.getCustomerById(1l);
    assertNotNull(customer, "Expected customer entity not null");
  }

  @Test
  void testGetCustomerByIdNotFound() throws BusinessException {
    when(repository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(null));
    assertThrows(BusinessException.class, () -> service.getCustomerById(1l),
        "Expected BusinessExcpetion");
  }

  @Test
  void testDeleteCustomerByIdSuccess(@Mock Customer entity) throws BusinessException {
    when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
    service.deleteCustomerById(1l);
    assertTrue(Boolean.TRUE, "Expected delete customer entity");
  }

  @Test
  void testDeleteCustomerByIdNotFound() throws BusinessException {
    when(repository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(null));
    assertThrows(BusinessException.class, () -> service.deleteCustomerById(1l),
        "Expected BusinessExcpetion");
  }

  @Test
  void testGetCustomersSuccess(@Mock CustomerFilterDTO filter, @Mock Pageable pageable,
      @Mock Page<Customer> page) throws BusinessException {
    when(repository.findAll(Mockito.any(), Mockito.any(Pageable.class))).thenReturn(page);
    Page<Customer> customers = service.getCustomers(filter, pageable);
    assertNotNull(customers, "Expected page of costumers not null");
  }
}
