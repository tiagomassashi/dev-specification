package br.com.nagata.dev.model.dto;

import java.io.Serializable;
import br.com.nagata.dev.enums.TipoDocumentoEnum;
import br.com.nagata.dev.model.DocumentoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private TipoDocumentoEnum tipo;
  private String numero;

  public DocumentoDTO(DocumentoEntity entity) {
    this.tipo = entity.getId().getTipoDocumento();
    this.numero = entity.getNumeroDocumentoCliente();
  }
}
