package br.com.nagata.dev.model.pk;

import br.com.nagata.dev.enums.DocumentTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DocumentPKTest {

  @Test
  void testGettersAndSetters() {
    DocumentPK id = new DocumentPK();
    id.setCustomerCode(1L);
    id.setDocumentType(DocumentTypeEnum.CPF);
    assertEquals(1L, id.getCustomerCode(), "Expected customer code equal 1");
    assertEquals(DocumentTypeEnum.CPF, id.getDocumentType(), "Expected document type equal CPF");
  }
}
