package br.com.nagata.dev.model.pk;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import br.com.nagata.dev.enums.TipoDocumentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DocumentoPK implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "CD_CLIE", length = 9, nullable = false)
  private Long codigoCliente;

  @Column(name = "TP_DOCT", length = 2, nullable = false)
  private TipoDocumentoEnum tipoDocumento;
}
