package com.app.codingame.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.codingame.entities.User;

public class UserRepository implements IUserRepository{

    private final Map<String, User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement),entity.getName(),entity.getScore());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of User Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TO DO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(User entity) {
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
    // Find the User Present in the Repository provided name
    // Tip:- Use Java Streams

    @Override
    public Optional<User> findByName(String name) {
        List<User> uList = new ArrayList<User>(userMap.values());
        Optional<User> user = uList.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findAny();
        return user;
    }
    
}
