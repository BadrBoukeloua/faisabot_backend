package com.project.faisabot.Controller;

import com.project.faisabot.Repository.ForumRepo;
import com.project.faisabot.Repository.QuestionnaireRepo;
import com.project.faisabot.Repository.UserRepo;
import com.project.faisabot.model.Answer;
import com.project.faisabot.model.Quest_question;
import com.project.faisabot.model.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GuestController {

    @Autowired
    private UserRepo userrepo ;
    @Autowired
    private ForumRepo forumRepo ;
    @Autowired
    private QuestionnaireRepo quesRepo ;


    @PutMapping("/NewQuestionnaire")
    private void AddQuestionnaire(@RequestBody Questionnaire sub_questionnaire) {

        // Retrieve the questionnaire from the database
        Optional<Questionnaire> questionnaireOptional = quesRepo.findById(sub_questionnaire.getId());
        if (questionnaireOptional.isPresent()) {
            Questionnaire questionnaire = questionnaireOptional.get();

            // Iterate over the questions in the submitted questionnaire
            for (Quest_question submittedQuestion : sub_questionnaire.getQuestions()) {
                // Find the corresponding question in the existing questionnaire
                Quest_question existingQuestion = questionnaire.getQuestion(submittedQuestion.getText());
                if (existingQuestion != null) {
                    // Iterate over the answers of each question
                    for (Answer submittedAnswer : submittedQuestion.getAnswers()) {
                        // Find the corresponding answer in the existing question
                        Answer existingAnswer = existingQuestion.getAnswer(submittedAnswer.getAnswer_text());
                        if (existingAnswer != null) {
                            // Increment the answer count
                            existingAnswer.setAnswer_count(existingAnswer.getAnswer_count() + 1);
                        } else {
                            // If the answer doesn't exist, add it to the existing question
                            existingQuestion.getAnswers().add(submittedAnswer);
                        }
                    }
                } else {
                    // If the question doesn't exist, add it to the existing questionnaire
                    questionnaire.getQuestions().add(submittedQuestion);
                }
            }

            // Save the updated questionnaire back to the database
            quesRepo.save(questionnaire);
        } else {
            // Handle case when the questionnaire doesn't exist
        }
    }
}
