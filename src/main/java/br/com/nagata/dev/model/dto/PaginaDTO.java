package br.com.nagata.dev.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginaDTO<T> {

  private int pageNumber;
  private int pageSize;
  private int totalPages;
  private int numberOfElements;
  private Long totalElements;
  private List<T> content;
}
