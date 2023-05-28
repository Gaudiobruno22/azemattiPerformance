package br.com.azematti.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

		// Access to UI - http://localhost:8080/swagger-ui.html
		
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.azematti"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiInfo());
		}

		private ApiInfo apiInfo() {			
			return new ApiInfo(
					"API Rest do Projeto Azematti Performance - Spring 2.7.12",
					"Documentação Padrão para Visualização dos EndPoins do WebSite Azematti",
					"v1",
					"Aqui vai os Termos de Serviço",
					new Contact("Bruno Gaudio", "https://github.com/Gaudiobruno22", "brunogmattos22@gmail.com"),
					"Licença Gratuita", 
					"Aqui vai a URL da Licença",
					Collections.emptyList());
		}		
}
