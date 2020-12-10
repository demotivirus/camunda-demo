package com.example.camunda.prapareToBattle2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class FightTheEnemy implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ArrayList<Boolean> army = (ArrayList<Boolean>) delegateExecution.getVariable("army");
        Integer enemyWarriors = (Integer) delegateExecution.getVariable("enemyWarriors");

        Thread.sleep(100);

        if(new Random().nextBoolean()){
            enemyWarriors--;
            System.out.println("Enemy warrior killed. Now is a " + enemyWarriors);
        } else {
            army.remove(army.size()-1);
            System.out.println("Our warrior killed. Now is a " + army.size());
        }

        long ourWarriors = army.size();
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("ourWarriors", ourWarriors);
    }
}
