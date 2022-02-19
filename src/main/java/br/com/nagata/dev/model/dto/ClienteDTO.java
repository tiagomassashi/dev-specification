package br.com.nagata.dev.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
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

  private Long codigo;
  @NotNull @NotBlank private String nome;
  @NotNull private TipoClienteEnum tipo;
  private LocalDateTime registro;
  private List<DocumentoDTO> documentos;

  public ClienteDTO(ClienteEntity entity) {
    this.codigo = entity.getCodigoCliente();
    this.nome = entity.getNomeCliente();
    this.tipo = entity.getTipoCliente();
    this.registro = entity.getDataHoraInclusao();
    this.documentos = entity.getDocumentosCliente().stream().map(DocumentoDTO::new)
        .collect(Collectors.toList());
  }
}
