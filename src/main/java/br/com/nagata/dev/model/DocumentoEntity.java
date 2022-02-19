package br.com.nagata.dev.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.com.nagata.dev.model.dto.DocumentoDTO;
import br.com.nagata.dev.model.pk.DocumentoPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_DOCT_CLIE", schema = "PUBLIC")
public class DocumentoEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private DocumentoPK id;

  @Column(name = "NR_DOCT_CLIE", length = 20, nullable = false)
  private String numeroDocumentoCliente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CD_CLIE", insertable = false, updatable = false)
  private ClienteEntity cliente;

  public DocumentoEntity(DocumentoDTO dto, ClienteEntity cliente) {
    this.id = new DocumentoPK();
    this.id.setTipoDocumento(dto.getTipo());
    this.id.setCodigoCliente(cliente.getCodigoCliente());
    this.numeroDocumentoCliente = dto.getNumero();
    this.cliente = cliente;
  }
}
