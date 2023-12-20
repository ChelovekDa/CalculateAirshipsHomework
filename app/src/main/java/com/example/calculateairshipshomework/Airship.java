package com.example.calculateairshipshomework;

public class Airship implements Calculate {
    private final double speed; //км в час

    public Airship(double speed) {
        this.speed = speed;
    }

    @Override //время
    public double timeCalculate(double distance, double speed) {
        return Calculate.super.timeCalculate(distance, speed);
    }

    public double getSpeed() { return speed; }

    @Override //количество топлива
    public double fuelCalculate(double distance, double usageKGPerHour) {
        distance /= getSpeed();
        return Math.ceil(distance * usageKGPerHour);
    }

    @Override //расход топлива
    public double fuelUsageCalculate(double distance, double usageKG, double speed) {
        return Calculate.super.fuelUsageCalculate(distance, usageKG, speed);
    }
}
