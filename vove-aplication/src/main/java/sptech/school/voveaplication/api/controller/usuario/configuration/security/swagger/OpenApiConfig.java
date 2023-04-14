package sptech.school.voveaplication.api.controller.usuario.configuration.security.swagger;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

    @Configuration
    @OpenAPIDefinition(
            info = @Info(
                    title = "Vovê application",
                    description = "Documentação dedicada a end-points da vovê",
                    contact = @Contact(
                            name = "vove-aplication",
                            url = "https://github.com/Grupo8-3-Semestre/Aplicacao",
                            email = "joao.barbosa@sptech.school"
                    ),
                    license = @License(name = "LICENSED"),
                    version = "1.1.4"
            )
    )
    @SecurityScheme(
            name = "Bearer", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT"
    )
    public class OpenApiConfig {

    }

