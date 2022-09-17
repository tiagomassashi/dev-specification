package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.model.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PageDTOTest {

  @Test
  void testGettersAndSetters() {
    PageDTO<Document> dto = new PageDTO<>();
    dto.setPageNumber(1);
    dto.setPageSize(1);
    dto.setTotalPages(1);
    dto.setNumberOfElements(1);
    dto.setTotalElements(1L);
    dto.setContent(new ArrayList<>());
    assertEquals(1, dto.getPageNumber(), "Expected page number equal 1");
    assertEquals(1, dto.getPageSize(), "Expected page size equal 1");
    assertEquals(1, dto.getTotalPages(), "Expected total pages equal 1");
    assertEquals(1, dto.getNumberOfElements(), "Expected elements equal 1");
    assertNotNull(dto.getTotalElements(), "Expected elements not null");
    assertNotNull(dto.getContent(), "Expected content not null");
  }

  @Test
  void testConstructorAllArgs() {
    PageDTO<Document> dto = new PageDTO<>(1, 1, 1, 1, 1L, new ArrayList<>());
    assertNotNull(dto, "Expected page not null");
  }
}
