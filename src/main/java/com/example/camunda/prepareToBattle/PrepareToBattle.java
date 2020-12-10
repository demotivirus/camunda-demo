package com.example.camunda.prepareToBattle;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int enemyWarriors = (int) (Math.random() * 100);
        long ourWarriors = (long) delegateExecution.getVariable("ourWarriors");
        //int ourWarriors = (int) (Math.random() * 200);
        String battleStatus = "Undefined";

        if(ourWarriors < 1 || ourWarriors > 100) throw new BpmnError("warriorsError");

        boolean isWin = false;
        if((ourWarriors - enemyWarriors) > 0) {
            isWin = true;
            battleStatus = "Victory";
        } else battleStatus = "Defeat";

        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("battleStatus", battleStatus);
        delegateExecution.setVariable("isWin", isWin);
        delegateExecution.setVariable("ourWarriors", ourWarriors);
    }
}
