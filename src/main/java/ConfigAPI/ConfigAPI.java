package ConfigAPI;

import Services.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


@Configuration
public class ConfigAPI {

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    Service service() {
        return new Service();
    }

}
