package com.example.camunda.romanEmpire;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class DecideOnExpansion implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random random = new Random();
        int north = random.nextInt(100);
        delegateExecution.setVariable("north", north);
    }
}
