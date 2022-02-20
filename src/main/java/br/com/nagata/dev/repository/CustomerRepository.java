package br.com.nagata.dev.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import br.com.nagata.dev.model.Customer;

public interface CustomerRepository
    extends CrudRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
}
