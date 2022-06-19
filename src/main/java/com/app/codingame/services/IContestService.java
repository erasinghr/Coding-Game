package com.app.codingame.services;

import java.util.List;

import com.app.codingame.exceptions.UserNotFoundException;
import com.app.codingame.dtos.ContestSummaryDto;
import com.app.codingame.entities.Contest;
import com.app.codingame.entities.Level;
import com.app.codingame.exceptions.ContestNotFoundException;
import com.app.codingame.exceptions.InvalidContestException;
import com.app.codingame.exceptions.QuestionNotFoundException;

public interface IContestService {
    public Contest create(String contestName, Level level, String contestCreator, Integer numQuestion) throws UserNotFoundException, QuestionNotFoundException;
    public List<Contest> getAllContestLevelWise(Level level);
    public ContestSummaryDto runContest(String contestId, String contestCreator) throws ContestNotFoundException, InvalidContestException;
}
