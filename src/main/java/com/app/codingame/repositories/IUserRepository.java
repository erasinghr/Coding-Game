package com.app.codingame.repositories;

import java.util.Optional;

import com.app.codingame.entities.User;

public interface IUserRepository extends CRUDRepository<User,String> {
    public Optional<User> findByName(String name); 
}
