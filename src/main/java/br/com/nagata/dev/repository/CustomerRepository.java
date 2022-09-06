package br.com.nagata.dev.repository;

import br.com.nagata.dev.model.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository
    extends CrudRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {}
