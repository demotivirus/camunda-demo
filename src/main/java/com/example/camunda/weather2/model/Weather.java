package com.example.camunda.weather2.model;

public class Weather {
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main=" + main +
                '}';
    }
}
