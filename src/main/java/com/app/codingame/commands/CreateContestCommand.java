package com.app.codingame.commands;

import java.util.List;

import com.app.codingame.exceptions.UserNotFoundException;
import com.app.codingame.services.IContestService;
import com.app.codingame.entities.Contest;
import com.app.codingame.entities.Level;
import com.app.codingame.exceptions.QuestionNotFoundException;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TO DO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IContestService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        String contestName = tokens.get(1);
        String tempLevel = tokens.get(2);
        Level level;
        if (tempLevel.equals("HIGH")) {
            level = Level.HIGH;
        } else if (tempLevel.equals("LOW")) {
            level = Level.LOW;
        } else {
            level = Level.MEDIUM;
        }
        String contestCreator = tokens.get(3);
        Integer numQuestion;
        // if (tokens.size() == 4) {
        //     Integer numQuestion = Integer.parseInt(tokens.get(4));
        //     System.out.println(
        //             contestService.create(contestName, level, contestCreator, numQuestion));
        // }
        // else {
        //     System.out.println(
        //             contestService.create(contestName, level, contestCreator, null));
        // }
        if (tokens.size() == 4) {
            numQuestion = null;
        } else {
            numQuestion = Integer.parseInt(tokens.get(4));
        }

        try {
            Contest contest =
                    contestService.create(contestName, level, contestCreator, numQuestion);
            System.out.println(contest);
        } catch (UserNotFoundException e) {
            System.out.println("Contest Creator for given name: creator not found!");
        } catch (QuestionNotFoundException e) {
            System.out.println(
                    "Request cannot be processed as enough number of questions can not found. Please try again later!");
        }

    }
    
}
