package com.app.codingame.commands;

import java.util.List;

import com.app.codingame.services.IContestService;
import com.app.codingame.entities.Contest;
import com.app.codingame.entities.Level;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TO DO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        // try{
        //     String tempLevel = tokens.get(1);
        //     System.out.println(tempLevel);
        //     Level level;
        //     if (tempLevel.equals("HIGH")) {
        //         level = Level.HIGH;
        //     } else if (tempLevel.equals("LOW")) {
        //         level = Level.LOW;
        //     } else {
        //         level = Level.MEDIUM;
        //     }
        //     System.out.println(contestService.getAllContestLevelWise(level));
        // } catch (IndexOutOfBoundsException e) {
        //     Level level = null;
        //     System.out.println(contestService.getAllContestLevelWise(level));
        // }
        List<Contest> contestList;
        if (tokens.size()==1)
            contestList = contestService.getAllContestLevelWise(null);
        else
            contestList = contestService.getAllContestLevelWise(Level.valueOf(tokens.get(1)));

        System.out.println(contestList);
    }
    
}
