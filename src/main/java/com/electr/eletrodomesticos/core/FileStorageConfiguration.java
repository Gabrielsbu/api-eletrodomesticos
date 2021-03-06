package com.electr.eletrodomesticos.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Data
public class FileStorageConfiguration {

    private String uploadDir;
}
