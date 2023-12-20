package com.example.calculateairshipshomework;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Helicopter implements Calculate {

    @Override
    public double timeCalculate(double distance, double speed) {
        return Calculate.super.timeCalculate(distance, speed);
    }

    @Override
    public double fuelCalculate(double distance, double usagePerHundredKM) {
        distance /= 100;
        double v = distance * usagePerHundredKM;
        return Math.ceil(v);
    }

    @Override
    public double fuelUsageCalculate(double distance, double usagePerHundredKM, double speed) {
        double v = speed / 100;
        v = v * usagePerHundredKM;
        return Math.ceil(v);
    }
}
