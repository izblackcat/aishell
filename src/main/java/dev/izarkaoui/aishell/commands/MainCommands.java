package dev.izarkaoui.aishell.commands;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.anthropic.api.AnthropicApi;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.mistralai.api.MistralAiApi;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class MainCommands {

    private ChatClient chatClient;
    private ChatModel chatModel;

    @Value("${MISTRAL_AI_API_KEY}")
    private String mistralKey;

    @Value("${ANTHROPIC_API_KEY}")
    private String anthropicKey;

    @Value("${OPENAI_API_KEY}")
    private String openaiKey;

    @ShellMethod(key = "answer", value = "answer your question from the LLM")
    public String answer(
            @ShellOption(value = {"--question", "-q"}) String question,
            @ShellOption(value = {"--model", "-m"}, defaultValue = "mistral", help = "the model to use to answer the question (e.g: mistral, claude or openai)") String model
    ) {

        switch (model) {
            case "claude":
                chatModel = new AnthropicChatModel(new AnthropicApi(anthropicKey));
                break;
            case "openai":
                chatModel = new OpenAiChatModel(new OpenAiApi(openaiKey));
                break;
            default:
                chatModel = new MistralAiChatModel(new MistralAiApi(mistralKey));
        }

        this.chatClient = ChatClient.create(chatModel);

        return chatClient.prompt().user(question).call().content();
    }

    @ShellMethod(key = "list", value = "list available models")
    public String listAvailableModels() {
        return """
                Available models are:
                    - Mistral AI (mistral) (default)
                    - Claude (Anthropic)
                    - Open AI (Open AI)
                """;
    }
}
