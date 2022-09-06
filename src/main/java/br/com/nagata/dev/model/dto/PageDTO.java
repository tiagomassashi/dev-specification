package br.com.nagata.dev.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {

  private int pageNumber;
  private int pageSize;
  private int totalPages;
  private int numberOfElements;
  private Long totalElements;
  private List<T> content;
}
