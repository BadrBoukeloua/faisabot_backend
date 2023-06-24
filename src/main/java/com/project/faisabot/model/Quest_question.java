package com.project.faisabot.model;

import java.util.List;

public class Quest_question {

    private String text ;
    private List<Answer> answers ;

    public Quest_question() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public Answer getAnswer(String answerText) {
        for (Answer answer : this.answers) {
            if (answer.getAnswer_text().equals(answerText)) {
                return answer;
            }
        }
        return null; // Return null if the answer doesn't exist
    }
}
