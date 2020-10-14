package pl.pwpw.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.pwpw.playground.application.fileupload.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaygroundApplication.class, args);
    }

}
