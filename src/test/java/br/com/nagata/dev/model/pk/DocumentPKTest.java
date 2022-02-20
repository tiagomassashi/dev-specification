package br.com.nagata.dev.model.pk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.nagata.dev.enums.DocumentTypeEnum;

@ExtendWith(MockitoExtension.class)
class DocumentPKTest {

  @Test
  void testGettersAndSetters() {
    DocumentPK id = new DocumentPK();
    id.setCustomerCode(1l);
    id.setDocumentType(DocumentTypeEnum.CPF);
    assertEquals(1l, id.getCustomerCode(), "Expected customer code equal 1");
    assertEquals(DocumentTypeEnum.CPF, id.getDocumentType(), "Expected document type equal CPF");
  }
}
