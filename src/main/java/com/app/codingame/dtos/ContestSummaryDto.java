package com.app.codingame.dtos;

import java.util.List;

import com.app.codingame.entities.Contest;
import com.app.codingame.entities.User;

public class ContestSummaryDto {
    private final Contest contest;
    private final List<User> users;

    public ContestSummaryDto(Contest contest, List<User> userResultList) {
        this.contest = contest;
        this.users = userResultList;
    }

    public Contest getContest() {
        return contest;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "ContestSummaryDto [contest=" + contest + ", users=" + users + "]";
    }
    
}
