package br.com.nagata.dev.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.backing-services.database")
public class DatabaseConfig {

  private String url;
  private String driverClassName;
  private String username;
  private String password;
  private int poolSize;

  @Bean
  public DataSource dataSource() {
    HikariConfig config = new HikariConfig();
    config.setPoolName("dev-specification-pool");
    config.setMaximumPoolSize(poolSize);
    config.setDriverClassName(driverClassName);
    config.setJdbcUrl(url);
    config.setUsername(username);
    config.setPassword(password);

    return new HikariDataSource(config);
  }
}
