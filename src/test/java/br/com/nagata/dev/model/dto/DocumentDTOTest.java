package br.com.nagata.dev.model.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.nagata.dev.enums.DocumentTypeEnum;
import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.Document;
import br.com.nagata.dev.model.pk.DocumentPK;

@ExtendWith(MockitoExtension.class)
class DocumentDTOTest {

  @Test
  void testGettersAndSetters() {
    DocumentDTO dto = new DocumentDTO();
    dto.setType(DocumentTypeEnum.CNPJ);
    dto.setNumber("1");
    assertNotNull(dto.getType(), "Expected type not null");
    assertNotNull(dto.getNumber(), "Expected number not null");
  }

  @Test
  void testConstructorAllArgs() {
    DocumentDTO dto = new DocumentDTO(DocumentTypeEnum.CNPJ, "1");
    assertNotNull(dto, "Expected document not null");
  }

  @Test
  void testConstructorEntity() {
    DocumentDTO dto = new DocumentDTO(new Document(new DocumentPK(), "1", new Customer()));
    assertNotNull(dto, "Expected document not null");
  }
}
