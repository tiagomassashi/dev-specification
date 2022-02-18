package br.com.nagata.dev.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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

  @Column(name = "TP_CLIE", length = 10, nullable = false)
  private String tipoCliente;

  @Column(name = "DH_INCL")
  private LocalDateTime dataHoraInclusao;

  public ClienteEntity(ClienteDTO dto) {
    this.nomeCliente = dto.getNomeCliente();
    this.tipoCliente = dto.getTipoCliente().toString();
    this.dataHoraInclusao = LocalDateTime.now();
  }
}
