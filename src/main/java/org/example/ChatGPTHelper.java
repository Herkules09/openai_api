package org.example;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

public class ChatGPTHelper {

    OpenAiService service;

    public ChatGPTHelper(){
        service= new OpenAiService("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");
    }

    private String askChatGPT(String question){
        ChatCompletionRequest completionRequest= ChatCompletionRequest.builder().messages(List.of(new ChatMessage("user",question)))
                .model("gpt-3.5-turbo").build();

        List<ChatCompletionChoice> choices = service.createChatCompletion(completionRequest).getChoices();

        StringBuilder stringBuilder= new StringBuilder();

        choices.stream().map(ChatCompletionChoice::getMessage).map(ChatMessage::getContent).forEach(stringBuilder::append);

        return stringBuilder.toString();
    }



    public String getBreakfastIdea(List<String> products){
      String allProducts = String.join(",",products);
      String question ="I have "+allProducts +". What can I eat for breakfast? Give me three ideas.";
      return askChatGPT(question);

    }

    public String getLunchIdea(List<String> products){
        String allProducts = String.join(",",products);
        String question ="I have "+allProducts +". What can I eat for lunch? Give me three ideas.";
        return askChatGPT(question);

    }

    public String getExamplesProductsWith(String component){
        String question = "Write out five products that contains a lot of "+component;
        return askChatGPT(question);
    }


    public String getCaloriesOfProduct(String product) {
        String question = "How many calories have "+product +" in 100g";
        return askChatGPT(question);
    }
}
