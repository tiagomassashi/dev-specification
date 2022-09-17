package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.enums.CustomerTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CustomerDTOTest {

  @Test
  void testGettersAndSetters() {
    CustomerDTO dto = new CustomerDTO();
    dto.setCode(1L);
    dto.setName("name");
    dto.setType(CustomerTypeEnum.ESPECIAL);
    dto.setRegistered(LocalDateTime.now());
    dto.setDocuments(new ArrayList<>());
    assertNotNull(dto.getCode(), "Expected code not null");
    assertNotNull(dto.getName(), "Expected name not null");
    assertNotNull(dto.getType(), "Expected type not null");
    assertNotNull(dto.getRegistered(), "Expected type not null");
    assertNotNull(dto.getDocuments(), "Expected documents not null");
  }

  @Test
  void testConstructorAllArgs() {
    CustomerDTO dto =
        new CustomerDTO(
            1L, "name", CustomerTypeEnum.ESPECIAL, LocalDateTime.now(), new ArrayList<>());
    assertNotNull(dto, "Expected customer not null");
  }
}
