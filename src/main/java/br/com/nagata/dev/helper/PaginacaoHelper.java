package br.com.nagata.dev.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import br.com.nagata.dev.model.dto.PaginaDTO;

@Component
public class PaginacaoHelper {

  private static final int PAGE_OFFSET = 1;
  private static final int MIN_PAGE_NUMBER = 1;
  private static final int MAX_PAGE_SIZE = 20;
  private static final int MIN_PAGE_SIZE = 1;

  public <T> PaginaDTO<T> converter(Page<T> page) {
    PaginaDTO<T> dto = new PaginaDTO<>();
    dto.setPageNumber(page.getPageable().getPageNumber() + 1);
    dto.setPageSize(page.getPageable().getPageSize());
    dto.setTotalPages(page.getTotalPages());
    dto.setNumberOfElements(page.getNumberOfElements());
    dto.setTotalElements(page.getTotalElements());
    dto.setContent(page.getContent());

    return dto;
  }

  public Pageable converter(int page, int size) {
    int pageNumber = page < MIN_PAGE_NUMBER ? (MIN_PAGE_NUMBER - PAGE_OFFSET) : (page - PAGE_OFFSET);
    int pageSize = size > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : size;
    pageSize = pageSize < MIN_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;

    return PageRequest.of(pageNumber, pageSize);
  }
}
