package br.com.nagata.dev.converter;

import br.com.nagata.dev.enums.DocumentTypeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class DocumentTypeConverterTest {

  private DocumentTypeConverter converter;

  @BeforeEach
  void init() {
    this.converter = new DocumentTypeConverter();
  }

  @Test
  void testConvertToDatabaseColumn() {
    String typeString = converter.convertToDatabaseColumn(DocumentTypeEnum.CNPJ);
    assertNotNull(typeString, "Expected type not null");
  }

  @Test
  void testConvertToDatabaseColumnNull() {
    String typeString = converter.convertToDatabaseColumn(null);
    assertNull(typeString, "Expected type null");
  }

  @Test
  void testConvertToEntityAttribute() {
    DocumentTypeEnum typeEnum = converter.convertToEntityAttribute("04");
    assertNotNull(typeEnum, "Expected type not null");
  }

  @Test
  void testConvertToEntityAttributeException() {
    DocumentTypeEnum typeEnum = converter.convertToEntityAttribute(null);
    assertNull(typeEnum, "Expected type null");
  }
}
