package cl.mayne.productos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
  
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Prueba practica")
	              .description("Desarrollador Java/AWS")
	              .version("v0.0.1")
	              //.license(new License().name("Apache 2.0").url("http://springdoc.org"))
	              )
	              .externalDocs(new ExternalDocumentation()
	              .description("Código del Proyecto")
	              .url("https://github.com/jmaynec/challenge-principal"));
	  }

}