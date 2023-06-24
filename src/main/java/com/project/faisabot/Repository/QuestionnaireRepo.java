package com.project.faisabot.Repository;

import com.project.faisabot.model.Questionnaire;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionnaireRepo extends MongoRepository<Questionnaire, ObjectId> {
}
