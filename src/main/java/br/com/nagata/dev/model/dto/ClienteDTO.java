package br.com.nagata.dev.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.nagata.dev.enums.TipoClienteEnum;
import br.com.nagata.dev.model.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long codigoCliente;
  @NotNull @NotBlank private String nomeCliente;
  @NotNull private TipoClienteEnum tipoCliente;
  private LocalDateTime dataHoraInclusao;

  public ClienteDTO(ClienteEntity entity) {
    this.codigoCliente = entity.getCodigoCliente();
    this.nomeCliente = entity.getNomeCliente();
    this.tipoCliente = TipoClienteEnum.valueOf(entity.getTipoCliente());
    this.dataHoraInclusao = entity.getDataHoraInclusao();
  }
}
