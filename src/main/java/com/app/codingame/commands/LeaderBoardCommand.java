package com.app.codingame.commands;

import java.util.List;

import com.app.codingame.services.IUserService;
import com.app.codingame.entities.ScoreOrder;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TO DO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        System.out.println(userService.getAllUserScoreOrderWise(ScoreOrder.valueOf(tokens.get(1))));
    }
    
}
