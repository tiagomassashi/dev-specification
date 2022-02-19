package br.com.nagata.dev.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.com.nagata.dev.enums.TipoClienteEnum;
import br.com.nagata.dev.model.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CLIE", schema = "PUBLIC")
public class ClienteEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "sequenceCliente", sequenceName = "PUBLIC.SQ_CLIE", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceCliente")
  @Column(name = "CD_CLIE", length = 9, nullable = false)
  private Long codigoCliente;

  @Column(name = "NM_CLIE", length = 80, nullable = false)
  private String nomeCliente;

  @Enumerated(EnumType.STRING)
  @Column(name = "TP_CLIE", length = 10, nullable = false)
  private TipoClienteEnum tipoCliente;

  @Column(name = "DH_INCL", nullable = false)
  private LocalDateTime dataHoraInclusao;

  @OneToMany(mappedBy = "id.codigoCliente", fetch = FetchType.EAGER)
  private List<DocumentoEntity> documentosCliente;

  public ClienteEntity(ClienteDTO dto) {
    this.nomeCliente = dto.getNome();
    this.tipoCliente = dto.getTipo();
    this.dataHoraInclusao = LocalDateTime.now();
  }
}
