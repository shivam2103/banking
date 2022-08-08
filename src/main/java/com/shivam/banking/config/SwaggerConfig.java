package com.shivam.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("banking-api")
                .apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot Crud API")
                .description("Spring Booth Crud Api's For Java Developers")
                .termsOfServiceUrl("www.linkedin.com/in/shivamjava")
                .contact(new Contact("Shivam Shivhare",
                        "", "shivam.shivhare03@gmail.com")).license("SpringBoot API's")
                .licenseUrl("shivam.shivhare03@gmail.com").version("1.0").build();
    }
}
