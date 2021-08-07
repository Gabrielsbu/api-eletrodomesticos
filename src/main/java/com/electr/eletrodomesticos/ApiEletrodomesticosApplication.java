package com.electr.eletrodomesticos;

import com.electr.eletrodomesticos.core.FileStorageConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageConfiguration.class
})
public class ApiEletrodomesticosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEletrodomesticosApplication.class, args);
    }

}
