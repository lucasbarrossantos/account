package br.com.prismo.account.config;

import br.com.prismo.account.controller.AccountController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(AccountController.class.getPackageName()))
                .paths(PathSelectors.any())
                .build().apiInfo(getApiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Account API",
                "Rotina de transações",
                "1",
                "TERMS OF SERVICE URL",
                new Contact("Desafio",
                        "https://github.com/lucasbarrossantos/account",
                        "lucas-barros28@hotmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }


}
