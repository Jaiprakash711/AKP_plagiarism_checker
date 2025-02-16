package com.AKP.plagiarism.plagiarism_checker.DTO;

import java.util.List;

public class PlagiarismCheckRequestDTO {
    private String text;
    private List<String> excludedSources;
    private String language;
    private String country;

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getExcludedSources() {
        return excludedSources;
    }

    public void setExcludedSources(List<String> excludedSources) {
        this.excludedSources = excludedSources;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
