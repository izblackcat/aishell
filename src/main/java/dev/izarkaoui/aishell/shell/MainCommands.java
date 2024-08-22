package dev.izarkaoui.aishell.shell;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class MainCommands {

    private final ChatClient chatClient;

    public MainCommands(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @ShellMethod(key = "welcome", value = "Welcome command")
    public String welcome() {
        return """
                Welcome to aishell.\s
                Ask your questions and get instant answer just on your terminal!
               \s""";
    }


    @ShellMethod(key = "answer", value = "answer a prompt from the LLM")
    public String answer(@ShellOption String question) {
        return chatClient.prompt().user(question).call().content();
    }

}
