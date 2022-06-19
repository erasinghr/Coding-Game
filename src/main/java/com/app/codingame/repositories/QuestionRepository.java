package com.app.codingame.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.app.codingame.entities.Level;
import com.app.codingame.entities.Question;

public class QuestionRepository implements IQuestionRepository {

    private final Map<String, Question> questionMap;
    private Integer autoIncrement = 0;

    public QuestionRepository(){
        questionMap = new HashMap<String,Question>();
    }

    public QuestionRepository(Map<String, Question> questionMap) {
        this.questionMap = questionMap;
        this.autoIncrement = questionMap.size();
    }

    @Override
    public Question save(Question entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Question q = new Question(Integer.toString(autoIncrement),entity.getTitle(),entity.getLevel(),entity.getScore());
            questionMap.put(q.getId(),q);
            return q;
        }
        questionMap.put(entity.getId(),entity);
        return entity;
    }

    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Question Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<Question> findAll() {
     return new ArrayList<>(questionMap.values());
    }

    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questionMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TO DO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Question entity) {
        // TO DO Auto-generated method stub
        
    }

    @Override
    public void deleteById(String id) {
        // TO DO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TO DO Auto-generated method stub
        return 0;
    }

    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Question Present in the Repository provided Level
    // Tip:- Use Java Streams

    @Override
    public List<Question> findAllQuestionLevelWise(Level level) {
        List<Question> qlistfilt = new ArrayList<Question>();
        List<Question> qlist = new ArrayList<Question>(questionMap.values());

        qlistfilt = qlist.stream().filter(i -> i.getLevel() == level).collect(Collectors.toList());

        return qlistfilt;
    }
    
}
