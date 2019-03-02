package ru.ttv.newsportal.web;

import org.springframework.stereotype.Component;

/**
 * @author Timofey Teplykh
 */
@Component
public class UserSettings {

    private String language;

    public UserSettings() {
        this.language = "en";
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
