package dev.izarkaoui.aishell;

import dev.izarkaoui.aishell.commands.BasicCommands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.EnableCommand;

@SpringBootApplication
@EnableCommand(BasicCommands.class)
public class AishellApplication {

    public static void main(String[] args) {
        SpringApplication.run(AishellApplication.class, args);
    }

}
