package br.com.nagata.dev.model;

import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.model.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

  @Test
  void testGettersAndSetters() {
    Customer entity = new Customer();
    entity.setCustomerCode(1L);
    entity.setCustomerName("name");
    entity.setCustomerType(CustomerTypeEnum.ESPECIAL);
    entity.setRegistrationDateTime(LocalDateTime.now());
    entity.setCustomerDocuments(new ArrayList<>());
    assertNotNull(entity.getCustomerCode(), "Expected customer code not null");
    assertNotNull(entity.getCustomerName(), "Expected customer name not null");
    assertNotNull(entity.getCustomerType(), "Expected customer type not null");
    assertNotNull(entity.getRegistrationDateTime(), "Expected registration not null");
    assertNotNull(entity.getCustomerDocuments(), "Expected documents not null");
  }

  @Test
  void testConstructorAllArgs() {
    Customer entity =
        new Customer(1L, "name", CustomerTypeEnum.ESPECIAL, LocalDateTime.now(), new ArrayList<>());
    assertNotNull(entity.getCustomerCode(), "Expected customer code not null");
    assertNotNull(entity.getCustomerName(), "Expected customer name not null");
    assertNotNull(entity.getCustomerType(), "Expected customer type not null");
    assertNotNull(entity.getRegistrationDateTime(), "Expected registration not null");
    assertNotNull(entity.getCustomerDocuments(), "Expected documents not null");
  }

  @Test
  void testConstructorDto() {
    Customer entity = new Customer(new CustomerDTO());
    assertNotNull(entity, "Expected customer not null");
  }
}
