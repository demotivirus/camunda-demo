package com.example.camunda.prapareToBattle2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EvaluateTheBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        long ourWarriors = (long) delegateExecution.getVariable("ourWarriors");
        int enemyWarriors = (int) delegateExecution.getVariable("enemyWarriors");
        ArrayList<Boolean> army = (ArrayList<Boolean>) delegateExecution.getVariable("army");

        if (army.size() > enemyWarriors) {
            delegateExecution.setVariable("isWin", true);
            delegateExecution.setVariable("battleStatus",  "Victory");
        } else {
            delegateExecution.setVariable("isWin", false);
            delegateExecution.setVariable("battleStatus", "Defeat");
        }
        delegateExecution.setVariable("ourWarriors", army.size());
        System.out.println("===END BATTLE===\nOur warriors: " + army.size() + " enemies: " + enemyWarriors);
    }
}
