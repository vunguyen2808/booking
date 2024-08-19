package com.project.booking.application;

import com.project.booking.util.CurrentSpringUser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class OpenAPIConfiguration {
    private final AppProperties appProperties;

    public OpenAPIConfiguration(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        SpringDocUtils.getConfig()
                .addAnnotationsToIgnore(CurrentSpringUser.class);

        Info info = new Info()
                .title(appProperties.getName())
                .version(appProperties.getVersion());

        return new OpenAPI(SpecVersion.V31)
                .info(info);
    }

    @Bean
    public GroupedOpenApi apiDocuments() {
        return GroupedOpenApi.builder()
                .group("API-Documents")
                .displayName("API-Documents")
                .pathsToMatch("/api/**")
                .build();
    }

    @PostConstruct
    protected void onPostConstruct() {
        log.info("Initialized OpenAPIConfiguration");
    }
}
