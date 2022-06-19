package com.app.codingame.repositories;

import java.util.List;

import com.app.codingame.entities.Level;
import com.app.codingame.entities.Question;

public interface IQuestionRepository extends CRUDRepository<Question,String> {
    public List<Question> findAllQuestionLevelWise(Level level);
}
