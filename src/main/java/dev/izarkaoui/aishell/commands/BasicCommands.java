package dev.izarkaoui.aishell.commands;

import org.springframework.shell.command.annotation.Command;

@Command(group = "Basic commands")
public class BasicCommands {

    @Command(command = "welcome", description = "Welcome command")
    public String welcome() {
        return """
               Welcome to aishell.\s
               Ask your questions and get instant answer just on your terminal!
               \s""";
    }
}
