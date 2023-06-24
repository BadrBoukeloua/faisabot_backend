package com.project.faisabot.model;



import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Forum {

    @Id
    private ObjectId forum_id;


    private User forum_user;
    private List<Question> questoins;

    public Forum() {
    }

    public ObjectId getForum_id() {
        return forum_id;
    }

    public void setForum_id(ObjectId forum_id) {
        this.forum_id = forum_id;
    }


    public User getForum_user() {
        return forum_user;
    }

    public void setForum_user(User forum_user) {
        this.forum_user = forum_user;
    }

    public List<Question> getQuestoins() {
        return questoins;
    }

    public void setQuestoins(List<Question> questoins) {
        this.questoins = questoins;
    }
}
