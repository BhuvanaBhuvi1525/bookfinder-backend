package com.bhuvi.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

@Service
public class LLMService {

    private static final String GROQ_API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private static final String GROQ_API_KEY = System.getenv("GROQ_API_KEY");
    private final RestTemplate restTemplate = new RestTemplate();

    public String callLLM(String prompt) {
        // Construct message array
        JSONArray messages = new JSONArray();
        JSONObject userMessage = new JSONObject();
        userMessage.put("role", "user");
        userMessage.put("content", prompt);
        messages.put(userMessage);

        // Construct request body
        JSONObject body = new JSONObject();
        body.put("model",  "llama-3.3-70b-versatile"); 
        body.put("messages", messages);
        body.put("max_tokens", 150);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(GROQ_API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(GROQ_API_URL, HttpMethod.POST, entity, String.class);

        // Parse response
        JSONObject json = new JSONObject(response.getBody());
        JSONArray choices = json.getJSONArray("choices");
        JSONObject message = choices.getJSONObject(0).getJSONObject("message");
        return message.getString("content");
    }

    public List<String> suggestBooks(String title) {
        String prompt = "only and just Suggest 3 books similar to: " + title+"and no description   Return each theme as a separate line.";
        String response = callLLM(prompt);
        return Arrays.stream(response.split("\n")).map(String::trim).toList();
    }

    public List<String> extendSearch(String query) {
        String prompt = "Suggest 5 book search themes related to: " + query + ". Return each theme as a separate line.";
        String response = callLLM(prompt);
        return Arrays.stream(response.split("\n")).map(String::trim).toList();
    }

    public String summarizeTitle(String title) {
        String prompt = "Summarize the book titled: " + title;
        String response=callLLM(prompt);
        return response
                .replaceAll("\\*\\*", "") // remove bold markers
                .replaceAll("\n", " ")    // flatten newlines
                .trim();

    }
}