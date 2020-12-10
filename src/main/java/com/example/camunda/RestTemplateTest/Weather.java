package com.example.camunda.RestTemplateTest;

import com.example.camunda.RestTemplateTest.Models.Coord;
import com.example.camunda.RestTemplateTest.Models.Main;

public class Weather{
    private Coord coord;
    private Main main;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "coord=" + coord +
                ", main=" + main +
                '}';
    }
}
