package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.enums.CustomerTypeEnum;
import br.com.nagata.dev.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFilterDTO {

  private String customerName;
  private CustomerTypeEnum customerType;
  private DocumentTypeEnum documentType;
  private String documentNumber;
}
