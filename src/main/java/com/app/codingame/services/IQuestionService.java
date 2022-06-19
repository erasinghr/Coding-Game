package com.app.codingame.services;

import java.util.List;

import com.app.codingame.entities.Level;
import com.app.codingame.entities.Question;

public interface IQuestionService {
    public Question create(String title, Level level, Integer difficultyScore);
    public List<Question> getAllQuestionLevelWise(Level level);
}
