package slack.springbootslackapptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootSlackAppTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSlackAppTestApplication.class, args);
    }

}
