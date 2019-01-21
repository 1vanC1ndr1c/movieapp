package movieapp.config;


import movieapp.model.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfiguration {

    @Bean
    public Movie movie(){
        return new Movie();
    }
}
