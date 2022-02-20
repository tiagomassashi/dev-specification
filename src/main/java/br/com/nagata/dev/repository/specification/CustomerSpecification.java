package br.com.nagata.dev.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import br.com.nagata.dev.enums.CustomerType;
import br.com.nagata.dev.model.Customer;

public class CustomerSpecification {

  private CustomerSpecification() {
    throw new IllegalStateException("Utility class");
  }

  public static Specification<Customer> likeName(String name) {
    return (root, query, builder) -> StringUtils.hasLength(name)
        ? builder.like(builder.upper(root.get("customerName")), "%" + name.toUpperCase() + "%")
        : null;
  }

  public static Specification<Customer> equalType(CustomerType type) {
    return (root, query, builder) -> type != null ? builder.equal(root.get("customerType"), type)
        : null;
  }
}
