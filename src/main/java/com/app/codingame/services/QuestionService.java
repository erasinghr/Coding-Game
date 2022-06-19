package com.app.codingame.services;

import java.util.List;

import com.app.codingame.entities.Level;
import com.app.codingame.entities.Question;
import com.app.codingame.repositories.IQuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
     final Question question = new Question(title,level, difficultyScore);
        return questionRepository.save(question);
    }

    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        if (level != null) {
            return questionRepository.findAllQuestionLevelWise(level);
        }
        
        return questionRepository.findAll();
    }
}
