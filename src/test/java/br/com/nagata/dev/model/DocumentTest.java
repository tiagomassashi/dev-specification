package br.com.nagata.dev.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.nagata.dev.model.dto.DocumentDTO;
import br.com.nagata.dev.model.pk.DocumentPK;

@ExtendWith(MockitoExtension.class)
class DocumentTest {

  @Test
  void testGettersAndSetters() {
    Document entity = new Document();
    entity.setId(new DocumentPK());
    entity.setDocumentNumber("1");
    entity.setCustomer(new Customer());
    assertNotNull(entity.getId(), "Expected id not null");
    assertNotNull(entity.getDocumentNumber(), "Expected document number not null");
    assertNotNull(entity.getCustomer(), "Expected customer not null");
  }

  @Test
  void testConstructorAllArgs() {
    Document entity = new Document(new DocumentPK(), "1", new Customer());
    assertNotNull(entity.getId(), "Expected id not null");
    assertNotNull(entity.getDocumentNumber(), "Expected document number not null");
    assertNotNull(entity.getCustomer(), "Expected customer not null");
  }

  @Test
  void testConstructorDto() {
    Document entity = new Document(new DocumentDTO(), new Customer());
    assertNotNull(entity, "Expected document not null");
  }
}
