package com.app.codingame;

import java.util.ArrayList;
import java.util.List;

import com.app.codingame.entities.Contest;
import com.app.codingame.entities.ContestStatus;
import com.app.codingame.entities.Level;
import com.app.codingame.entities.Question;
import com.app.codingame.entities.User;
import com.app.codingame.exceptions.InvalidContestException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ContestTest")
public class ContestTest {


   // TO DO: WARNING!!!
   //  DO NOT MODIFY ANY FILES IN THE TESTS/ ASSESSMENTS UNLESS ASKED TO.
   //  Any modifications in this file may result in Assessment failure!



   @Test
   @DisplayName("#1 Contest should throw InvalidContestException if any Question Level in the List is not equal to Contest Level")
   public void contest_ShouldThrowInvalidContestException_GivenInvalidQuestionList(){
       //Arrange
       String name = "Crio.Do PhonePe TechScholars Assessment #1";
       List<Question> questions =  new ArrayList<Question>(){
           {
           add(new Question("Question1", Level.LOW,10));
           add(new Question("Question2",Level.LOW,20));
           add(new Question("Question3",Level.HIGH,30));
           }
       };
       Level level = Level.LOW;
       User creator = new User("Yakshit",0);
       ContestStatus contestStatus = ContestStatus.IN_PROGRESS;

       //Act and Assert
       Assertions.assertThrows(InvalidContestException.class,() -> new Contest(name, questions, level, creator, contestStatus));
   }




}

