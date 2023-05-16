package eu.deltasource.kat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration for swagger bean
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     After defining the Docket bean, its select() method returns an instance of ApiSelectorBuilder,
     which provides a way to control the endpoints exposed by Swagger.
     We can configure predicates for selecting RequestHandlers with the help of
     RequestHandlerSelectors and PathSelectors. Using any() for both will make documentation
     for our entire API available through Swagger.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("eu.deltasource.kat"))
                .paths(PathSelectors.any())
                .build();
    }
}
