package com.project.faisabot.model;

import java.util.List;

public class Question {


    private String text;
    private List<String> answers;

    public Question() {
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
