package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFilterDTO {

  private String name;
  private CustomerType type;
}
