package com.app.codingame.repositories;

import java.util.List;

import com.app.codingame.entities.Contest;
import com.app.codingame.entities.Level;

public interface IContestRepository extends CRUDRepository<Contest,String> {
    public List<Contest> findAllContestLevelWise(Level level);
}
