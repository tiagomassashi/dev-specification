package br.com.nagata.dev.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseConfigTest {

  @Test
  void testConnectToH2() {
    DatabaseConfig config = new DatabaseConfig();
    config.setUrl("jdbc:h2:mem:dev");
    config.setDriverClassName("org.h2.Driver");
    config.setUsername("sa");
    config.setPassword("");
    config.setPoolSize(1);

    DataSource datasource = config.dataSource();

    Assertions.assertNotNull(datasource, "Expected connect h2");
  }

  @Test
  void testGetters() {
    DatabaseConfig config = new DatabaseConfig();
    config.setUrl("jdbc:h2:mem:dev");
    config.setDriverClassName("org.h2.Driver");
    config.setUsername("sa");
    config.setPassword("");
    config.setPoolSize(1);

    assertNotNull(config.getUrl(), "Expected url not null");
    assertNotNull(config.getDriverClassName(), "Expected driver not null");
    assertNotNull(config.getUsername(), "Expected username not null");
    assertNotNull(config.getPassword(), "Expected password not null");
    assertEquals(1, config.getPoolSize(), "Expected pool equal 1");
  }
}
