package com.kylemanagement.config;


import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.webmvc.core.configuration.SpringDocWebMvcConfiguration;
import org.springdoc.webmvc.ui.SwaggerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@Import({
        SpringDocConfiguration.class,
        SpringDocConfigProperties.class,
        SpringDocWebMvcConfiguration.class,
        SwaggerConfig.class,
        SwaggerUiConfigProperties.class,
        SwaggerUiOAuthProperties.class,
})
public class ApiDoc {

    private static final Logger logger = getLogger(ApiDoc.class);

    @Value("classpath*:*.openapi.yml")
    Resource[] openApiContracts;

    @Bean
    public OpenAPI innsoOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Kyle management API")
                        .description("You can find the original contracts here:\n - Delivery tool: /v3/api-docs/kylemanagement.openapi.yaml")
                        .version("1.0.0"));
    }


    static private class OpenApiPartialContract {
        public List<Tag> tags;
    }

    @Bean
    public OpenApiCustomiser innsoOpenAPICustomizer() {
        List<Tag> tags = new LinkedList<>();
        for (Resource resource : openApiContracts) {
            try {
                OpenApiPartialContract api = Yaml.mapper().readValue(resource.getInputStream(), OpenApiPartialContract.class);
                if (api.tags != null) {
                    tags.addAll(api.tags);
                }
                logger.info("Added Open Api contract: {}", resource);
            } catch (IOException e) {
                logger.error("Unable to read Open Api contract: {}", resource, e);
            }
        }
        return openApi -> {
            openApi.getTags().removeIf(t -> t.getName().chars().anyMatch(Character::isUpperCase));
            openApi.getTags().removeIf(t -> tags.stream().map(Tag::getName).anyMatch(n -> t.getName().equals(n)));
            tags.forEach(openApi::addTagsItem);
        };
    }

    @Bean
    public OperationCustomizer innsoOpenAPIOperationCustomizer() {
        return (operation, handlerMethod) -> {
            operation.getTags().removeIf(t -> t.chars().anyMatch(Character::isUpperCase));
            return operation;
        };
    }
}
