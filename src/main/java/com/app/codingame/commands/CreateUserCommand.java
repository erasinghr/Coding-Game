package com.app.codingame.commands;

import java.util.List;

import com.app.codingame.services.IUserService;
import com.app.codingame.entities.User;

public class CreateUserCommand implements ICommand{

    private final IUserService userService;
    User user;
    
    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    // TO DO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_QUESTION","Ross"]

    @Override
    public void execute(List<String> tokens) {
        String tempName = tokens.get(1);
        System.out.println(userService.create(tempName));
        
    }
    
}
