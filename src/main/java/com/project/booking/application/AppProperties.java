package com.project.booking.application;

import com.project.booking.util.AbstractSerializable;
import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.net.URI;
import java.nio.file.Path;

@Slf4j
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "app")
public class AppProperties extends AbstractSerializable {
    @NotNull
    private URI url;
    @NotNull
    private String name;
    @NotNull
    private String version;
    @NotNull
    private Path storage;

    @PostConstruct
    private void onPostConstruct() {
        log.info(this.toJson());
    }
}
