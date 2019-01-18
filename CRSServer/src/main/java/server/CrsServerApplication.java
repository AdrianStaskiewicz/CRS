package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "entities")
@EntityScan(basePackages = "entities")
public class CrsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrsServerApplication.class, args);
    }
}

