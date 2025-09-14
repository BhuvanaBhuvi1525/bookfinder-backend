package com.bhuvi.demo;
import java.util.List;

public class SuggestionDTO {
    private List<String> suggestions;

    public SuggestionDTO() {}

    public SuggestionDTO(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }
}
