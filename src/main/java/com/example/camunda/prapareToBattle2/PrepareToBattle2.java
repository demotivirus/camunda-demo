package com.example.camunda.prapareToBattle2;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PrepareToBattle2 implements JavaDelegate {

    @Value("${maxWarriors}")
    private int maxWarriors;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        long ourWarriors = (long) delegateExecution.getVariable("ourWarriors");
        int enemyWarriors = (int) (Math.random() * 100);

        boolean isWin = false;

        if (ourWarriors < 1 || ourWarriors > 100) throw new BpmnError("warriorsError");

        List<Boolean> army = new ArrayList<>(Collections.nCopies((int) ourWarriors, true));
        System.out.println("Prepare to battle. Our army " + ourWarriors + " vs enemy army " + enemyWarriors);

        delegateExecution.setVariable("army", army);
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("ourWarriors", ourWarriors);
    }
}
