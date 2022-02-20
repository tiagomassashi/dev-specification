package br.com.nagata.dev.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaginationDTOTest {

  @Test
  void testGettersAndSetters() {
    PaginationDTO dto = new PaginationDTO();
    dto.setPage(1);
    dto.setSize(1);
    assertEquals(1, dto.getPage(), "Expected page equal 1");
    assertEquals(1, dto.getSize(), "Expected size equal 1");
  }

  @Test
  void testConstructorAllArgs() {
    PaginationDTO dto = new PaginationDTO(1, 1);
    assertNotNull(dto, "Expected pagination not null");
  }
}
