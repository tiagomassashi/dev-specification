package br.com.nagata.dev.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  private Long code;
  @NotNull @NotBlank private String name;
  @NotNull private CustomerTypeEnum type;
  private LocalDateTime registered;
  private List<DocumentDTO> documents;

  public CustomerDTO(Customer entity) {
    this.code = entity.getCustomerCode();
    this.name = entity.getCustomerName();
    this.type = entity.getCustomerType();
    this.registered = entity.getRegistrationDateTime();
    this.documents =
        entity.getCustomerDocuments().stream().map(DocumentDTO::new).collect(Collectors.toList());
  }
}
