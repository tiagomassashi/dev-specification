package br.com.nagata.dev.converter;

import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import br.com.nagata.dev.enums.TipoDocumentoEnum;

@Converter(autoApply = true)
public class TipoDocumentoConverter implements AttributeConverter<TipoDocumentoEnum, String> {

  @Override
  public String convertToDatabaseColumn(TipoDocumentoEnum tipoDocumento) {
    if (tipoDocumento == null) {
      return null;
    }
    return tipoDocumento.getCodigo();
  }

  @Override
  public TipoDocumentoEnum convertToEntityAttribute(String codigo) {
    if (codigo == null) {
      return null;
    }

    return Stream.of(TipoDocumentoEnum.values()).filter(c -> c.getCodigo().equals(codigo))
        .findFirst().orElseThrow(IllegalArgumentException::new);
  }
}
