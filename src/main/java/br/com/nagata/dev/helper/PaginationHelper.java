package br.com.nagata.dev.helper;

import br.com.nagata.dev.model.dto.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaginationHelper {

  private static final int PAGE_OFFSET = 1;
  private static final int MIN_PAGE_NUMBER = 1;
  private static final int MAX_PAGE_SIZE = 20;
  private static final int MIN_PAGE_SIZE = 1;

  public <T> PageDTO<T> convert(Page<T> page) {
    PageDTO<T> dto = new PageDTO<>();
    dto.setPageNumber(page.getPageable().getPageNumber() + 1);
    dto.setPageSize(page.getPageable().getPageSize());
    dto.setTotalPages(page.getTotalPages());
    dto.setNumberOfElements(page.getNumberOfElements());
    dto.setTotalElements(page.getTotalElements());
    dto.setContent(page.getContent());

    return dto;
  }

  public Pageable convert(int page, int size) {
    int pageNumber =
        page < MIN_PAGE_NUMBER ? (MIN_PAGE_NUMBER - PAGE_OFFSET) : (page - PAGE_OFFSET);
    int pageSize = Math.min(size, MAX_PAGE_SIZE);
    pageSize = pageSize < MIN_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;

    return PageRequest.of(pageNumber, pageSize);
  }
}
