package dev.izarkaoui.aishell.shell;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.result.CommandNotFoundMessageProvider;

@Configuration
public class CommandNotFound {

    @Bean
    CommandNotFoundMessageProvider provider() {
        return ctx -> "Command not found";
    }
}
