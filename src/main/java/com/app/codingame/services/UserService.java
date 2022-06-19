package com.app.codingame.services;

import java.util.Collections;
import java.util.List;

import com.app.codingame.dtos.UserRegistrationDto;
import com.app.codingame.entities.Contest;
import com.app.codingame.entities.ContestStatus;
import com.app.codingame.entities.RegisterationStatus;
import com.app.codingame.entities.ScoreOrder;
import com.app.codingame.entities.User;
import com.app.codingame.exceptions.ContestNotFoundException;
import com.app.codingame.exceptions.InvalidOperationException;
import com.app.codingame.exceptions.UserNotFoundException;
import com.app.codingame.repositories.IContestRepository;
import com.app.codingame.repositories.IUserRepository;

public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IContestRepository contestRepository;

    public UserService(IUserRepository userRepository, IContestRepository contestRepository) {
        this.userRepository = userRepository;
        this.contestRepository = contestRepository;
    }
    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Create and store User into the repository.
    @Override
    public User create(String name) {
        User user = new User(name, 1500);
        User newUser = userRepository.save(user);
        return newUser;
    }

    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Get All Users in Ascending Order w.r.t scores if ScoreOrder ASC.
    // Or
    // Get All Users in Descending Order w.r.t scores if ScoreOrder DESC.

    @Override
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder) {
        List<User> uList = userRepository.findAll();
        Collections.sort(uList, (a,b) -> {return a.getScore().compareTo(b.getScore());});
        if (scoreOrder == ScoreOrder.DESC) {
            Collections.reverse(uList);
        }
        return uList;
    }

    @Override
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
        Contest contest = contestRepository.findById(contestId).orElseThrow(() -> new ContestNotFoundException("Cannot Attend Contest. Contest for given id:"+contestId+" not found!"));
        User user = userRepository.findByName(userName).orElseThrow(() -> new UserNotFoundException("Cannot Attend Contest. User for given name:"+ userName+" not found!"));
        if(contest.getContestStatus().equals(ContestStatus.IN_PROGRESS)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is in progress!");
        }
        if(contest.getContestStatus().equals(ContestStatus.ENDED)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is ended!");
        }
        if(user.checkIfContestExists(contest)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is already registered!");
        }
        user.addContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(),RegisterationStatus.REGISTERED);
    }

    // TO DO: CRIO_TASK_MODULE_SERVICES
    // Withdraw the user from the contest
    // Hint :- Refer Unit Testcases withdrawContest method

    @Override
    public UserRegistrationDto withdrawContest(String contestId, String userName)
            throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
        Contest contest = contestRepository.findById(contestId).orElseThrow(
                () -> new ContestNotFoundException("Cannot Withdraw Contest. Contest for given id:"
                        + contestId + " not found!"));

        User user = userRepository.findByName(userName).orElseThrow(() -> new UserNotFoundException(
                "Cannot Withdraw Contest. User for given name:" + userName + " not found!"));
        ContestStatus contestStatus = contest.getContestStatus();
        if (contestStatus.equals(ContestStatus.IN_PROGRESS)) {
            throw new InvalidOperationException("Cannot Withdraw Contest. Contest for given id:"
                    + contestId + " is in progress!");
        }
        if (contestStatus.equals(ContestStatus.ENDED)){
            throw new InvalidOperationException(
                    "Cannot Withdraw Contest.Contest for given id:" + contestId
                            + " has ended!");
        }
        if (!user.checkIfContestExists(contest)) {
            throw new InvalidOperationException("Cannot Withdraw Contest. User for given contest id: "
                    + contestId + " is not registered!");
        }
        if (userName.equals(contest.getCreator().getName())) {
            throw new InvalidOperationException("Cannot Withdraw Contest. Contest Creator: "
                    + contestId + " not allowed to withdraw contest!");
        }
        user.deleteContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(),
                RegisterationStatus.NOT_REGISTERED);
    }
    
}
