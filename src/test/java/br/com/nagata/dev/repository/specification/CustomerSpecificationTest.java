package br.com.nagata.dev.repository.specification;

import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerSpecificationTest {

  private static final String CUSTOMER_NAME = "customerName";
  private static final String CUSTOMER_TYPE = "customerType";

  @Mock private CriteriaBuilder builder;
  @Mock private CriteriaQuery<Customer> query;
  @Mock private Root<Customer> root;
  @Mock private Path<Object> name;
  @Mock private Predicate predicate;

  @Test
  void testLikeNameWhenNameHasLength() {
    when(root.get(CUSTOMER_NAME)).thenReturn(name);
    when(builder.like(builder.upper(root.get(CUSTOMER_NAME)), "%NAGATA%")).thenReturn(predicate);
    Specification<Customer> specification = CustomerSpecification.likeName("Nagata");
    Predicate newPredicate = specification.toPredicate(root, query, builder);
    assertEquals(predicate, newPredicate);
  }

  @Test
  void testLikeNameWhenNameHasNoLength() {
    Specification<Customer> specification = CustomerSpecification.likeName("");
    Predicate newPredicate = specification.toPredicate(root, query, builder);
    assertNull(newPredicate);
  }

  @Test
  void testEqualCustomerType() {
    when(root.get(CUSTOMER_TYPE)).thenReturn(name);
    when(builder.equal(root.get(CUSTOMER_TYPE), CustomerTypeEnum.NORMAL)).thenReturn(predicate);
    Specification<Customer> specification =
        CustomerSpecification.equalCustomerType(CustomerTypeEnum.NORMAL);
    Predicate newPredicate = specification.toPredicate(root, query, builder);
    assertEquals(predicate, newPredicate);
  }

  @Test
  void testEqualCustomerTypeWhenTypeIsNull() {
    Specification<Customer> specification = CustomerSpecification.equalCustomerType(null);
    Predicate newPredicate = specification.toPredicate(root, query, builder);
    assertNull(newPredicate);
  }
}
