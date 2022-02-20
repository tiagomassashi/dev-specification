package br.com.nagata.dev.model.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int page;
  private int size;
}
