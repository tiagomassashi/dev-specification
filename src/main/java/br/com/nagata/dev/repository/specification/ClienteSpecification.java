package br.com.nagata.dev.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import br.com.nagata.dev.enums.TipoClienteEnum;
import br.com.nagata.dev.model.ClienteEntity;

public class ClienteSpecification {

  private ClienteSpecification() {
    throw new IllegalStateException("Utility class");
  }

  public static Specification<ClienteEntity> likeNome(String nome) {
    return (root, query, builder) -> StringUtils.hasLength(nome)
        ? builder.like(builder.upper(root.get("nomeCliente")), "%" + nome.toUpperCase() + "%")
        : null;
  }

  public static Specification<ClienteEntity> equalTipo(TipoClienteEnum tipo) {
    return (root, query, builder) -> tipo != null ? builder.equal(root.get("tipoCliente"), tipo)
        : null;
  }
}
