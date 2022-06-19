package com.app.codingame.commands;

import java.util.List;

import com.app.codingame.exceptions.InvalidOperationException;
import com.app.codingame.exceptions.UserNotFoundException;
import com.app.codingame.services.IUserService;
import com.app.codingame.exceptions.ContestNotFoundException;

public class WithdrawContestCommand implements ICommand{

    private final IUserService userService;
    
    public WithdrawContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TO DO: CRIO_TASK_MODULE_CONTROLLER
    // Execute withdrawContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["WITHDRAW_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        String contestId = tokens.get(1);
        String userName = tokens.get(2);
        try{
            System.out.println(userService.withdrawContest(contestId, userName));
        } catch (ContestNotFoundException e) {
            System.out.println(
                    "Cannot Withdraw Contest. Contest for given id:" + contestId + " not found!");
        } catch (UserNotFoundException e) {
            System.out.println(
                    "Cannot Withdraw Contest. User for given name:" + userName + " not found!");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
