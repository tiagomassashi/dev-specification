package br.com.nagata.dev.model.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.enums.DocumentTypeEnum;

@ExtendWith(MockitoExtension.class)
class CustomerFilterDTOTest {

  @Test
  void testGettersAndSetters() {
    CustomerFilterDTO dto = new CustomerFilterDTO();
    dto.setCustomerName("name");
    dto.setCustomerType(CustomerTypeEnum.ESPECIAL);
    dto.setDocumentType(DocumentTypeEnum.CNPJ);
    dto.setDocumentNumber("1");
    assertNotNull(dto.getCustomerName(), "Expected customer name not null");
    assertNotNull(dto.getCustomerType(), "Expected customer type not null");
    assertNotNull(dto.getDocumentType(), "Expected document type not null");
    assertNotNull(dto.getDocumentNumber(), "Expected document number not null");
  }

  @Test
  void testConstructorAllArgs() {
    CustomerFilterDTO dto =
        new CustomerFilterDTO("name", CustomerTypeEnum.ESPECIAL, DocumentTypeEnum.CNPJ, "1");
    assertNotNull(dto, "Expected filter not null");
  }
}
