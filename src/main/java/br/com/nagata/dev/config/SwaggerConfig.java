package br.com.nagata.dev.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder().group("dev-specification").pathsToMatch("/public/**").build();
  }

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Customer API REST")
                .description("Spring Data JPA - Specifications sample application")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(
            new ExternalDocumentation()
                .description("GitHub")
                .url("https://github.com/tiagomassashi/dev-specification"));
  }
}
