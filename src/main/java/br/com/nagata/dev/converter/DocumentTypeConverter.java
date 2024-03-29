package br.com.nagata.dev.converter;

import br.com.nagata.dev.enums.DocumentTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentTypeEnum, String> {

  @Override
  public String convertToDatabaseColumn(DocumentTypeEnum documentType) {
    if (documentType == null) {
      return null;
    }
    return documentType.getCode();
  }

  @Override
  public DocumentTypeEnum convertToEntityAttribute(String code) {
    if (code == null) {
      return null;
    }
    return Stream.of(DocumentTypeEnum.values())
        .filter(c -> c.getCode().equals(code))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
