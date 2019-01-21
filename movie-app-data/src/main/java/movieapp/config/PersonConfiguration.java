package movieapp.config;

import movieapp.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Bean
    public Person person() {
        return new Person();
    }
}
