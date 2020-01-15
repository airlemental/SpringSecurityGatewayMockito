package ninja.airelemental.config;

import ninja.airelemental.services.Message;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class MessageServiceTestConfig{
    @Bean
    @Primary
    public Message message() {
        return Mockito.mock(Message.class);
    }
}
