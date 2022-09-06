package br.com.nagata.dev.service;

import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.dto.CustomerDTO;
import br.com.nagata.dev.model.dto.CustomerFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

  Customer saveCustomer(CustomerDTO customer);

  Customer getCustomerById(Long id) throws BusinessException;

  void deleteCustomerById(Long id) throws BusinessException;

  Page<Customer> getCustomers(CustomerFilterDTO filter, Pageable pageable);
}
