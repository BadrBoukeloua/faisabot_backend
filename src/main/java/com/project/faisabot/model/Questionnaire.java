package com.project.faisabot.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Questionnaire {

    @Id
    private ObjectId id ;

    List<Quest_question> questions ;

    public Questionnaire() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Quest_question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Quest_question> questions) {
        this.questions = questions;
    }

    public Quest_question getQuestion(String quest_text){
        Quest_question returnquest = new Quest_question();
        for (Quest_question exist_quest:this.getQuestions()) {
            if (exist_quest.getText().equals(quest_text)) {
                returnquest = exist_quest;
                break;
            }
        }
        return returnquest;
    }
}

