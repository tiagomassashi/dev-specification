package br.com.nagata.dev.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.com.nagata.dev.exception.BusinessException;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.Document;
import br.com.nagata.dev.model.dto.CustomerDTO;
import br.com.nagata.dev.model.dto.CustomerFilterDTO;
import br.com.nagata.dev.repository.CustomerRepository;
import br.com.nagata.dev.repository.specification.CustomerSpecification;
import br.com.nagata.dev.service.CustomerService;
import br.com.nagata.dev.service.DocumentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository repository;
  private DocumentService documentService;

  @Autowired
  public CustomerServiceImpl(CustomerRepository repository, DocumentService documentService) {
    this.repository = repository;
    this.documentService = documentService;
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public Customer saveCustomer(CustomerDTO customer) {
    log.info("processing save customer...");

    Customer newCustomer = repository.save(new Customer(customer));

    List<Document> documents = new ArrayList<>();

    customer.getDocuments().stream().forEach(
        dto -> documents.add(documentService.saveDocument(new Document(dto, newCustomer))));

    newCustomer.setCustomerDocuments(documents);

    log.info("save customer successfully processed!");
    return newCustomer;
  }

  @Override
  public Customer getCustomerById(Long id) throws BusinessException {
    log.info("processing get customer by id...");

    Customer customer = repository.findById(id)
        .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "customer not found"));

    log.info("get customer by id successfully processed!");
    return customer;
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void deleteCustomerById(Long id) throws BusinessException {
    log.info("processing delete customer by id...");

    Customer customer = repository.findById(id)
        .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "customer not found"));

    repository.delete(customer);

    log.info("delete customer by id successfully processed!");
  }

  @Override
  public Page<Customer> getCustomers(CustomerFilterDTO filter, Pageable pageable) {
    log.info("processing get customers...");

    Page<Customer> customers =
        repository.findAll(Specification.where(CustomerSpecification.likeName(filter.getName())
            .and(CustomerSpecification.equalType(filter.getType()))), pageable);

    log.info("get customers successfully processed!");
    return customers;
  }
}
