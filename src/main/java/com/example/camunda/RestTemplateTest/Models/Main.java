package com.example.camunda.RestTemplateTest.Models;

public class Main {
    private Double temp;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp='" + temp + '\'' +
                '}';
    }
}
