package com.app.codingame.services;

import java.util.List;

import com.app.codingame.exceptions.InvalidOperationException;
import com.app.codingame.exceptions.UserNotFoundException;
import com.app.codingame.dtos.UserRegistrationDto;
import com.app.codingame.entities.ScoreOrder;
import com.app.codingame.entities.User;
import com.app.codingame.exceptions.ContestNotFoundException;

public interface IUserService {
    public User create(String name);
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder);
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
}
