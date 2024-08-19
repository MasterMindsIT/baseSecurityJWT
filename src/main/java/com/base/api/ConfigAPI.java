package com.base.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API DINAMIC ROLE AND JWT",
                description = "Billing initial system to projects with roles an authorities",
                termsOfService = "https://Tudominio.ext/pagina.html",
                version = "1.0.0",
                contact = @Contact(
                        name = "Ronald Garcia Vazquez",
                        url = "https://www.linkedin.com/in/ronald-garcia-vazquez/",
                        email = "ronaldgarciavazquez@gmail.com"
                ),
                license = @License(
                        name = "Standard Software Use License Comercial for https://github.com/MasterMindsIT",
                        url = "https://tTudominio.ext/pagina.html"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhot:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://localhot:8090"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token JWT"
        )
)

@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class ConfigAPI {
}
