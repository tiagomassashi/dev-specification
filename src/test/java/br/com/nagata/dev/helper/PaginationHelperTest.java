package br.com.nagata.dev.helper;

import br.com.nagata.dev.model.Customer;
import br.com.nagata.dev.model.dto.PageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PaginationHelperTest {

  private PaginationHelper helper;

  @BeforeEach
  void init() {
    this.helper = new PaginationHelper();
  }

  @Test
  void testConvertToPage() {
    Pageable pageable = helper.convert(1, 10);
    Page<Customer> page = new PageImpl<>(new ArrayList<>(), pageable, 1L);
    PageDTO<Customer> pageDto = helper.convert(page);
    assertNotNull(pageDto, "Expected page dto not null");
  }

  @Test
  void testConvertToPageableGreaterMinPageAndLessMaxPageSize() {
    Pageable pageable = helper.convert(1, 10);
    assertNotNull(pageable, "Expected pageable not null");
  }

  @Test
  void testConvertToPageableLessMinPageAndGreaterMaxPageSize() {
    Pageable pageable = helper.convert(0, 21);
    assertNotNull(pageable, "Expected pageable not null");
  }

  @Test
  void testConvertToPageableLessMinPageSize() {
    Pageable pageable = helper.convert(1, 0);
    assertNotNull(pageable, "Expected pageable not null");
  }
}
