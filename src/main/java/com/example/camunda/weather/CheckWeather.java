package com.example.camunda.weather;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class CheckWeather implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random random = new Random();
        delegateExecution.setVariable("name", "Andrey");
        delegateExecution.setVariable("weatherOk", random.nextBoolean());
    }
}
