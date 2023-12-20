package com.example.calculateairshipshomework;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public interface Calculate {

    default String around(double object) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        return decimalFormat.format(object);
    }

    //Расчет времени, необходимое транспорту для преодоления нужного расстояния
    default double timeCalculate(double distance, double speed) {
        double v = Math.round(distance / speed);
        return v;
    }

    //Расчет количества топлива, необходимое транспорту для пролета нужного расстояния
    default double fuelCalculate(double distance, double usage) {
        return distance / usage;
    }

    //Расчет потребления топлива транспортом в час (кг)
    default double fuelUsageCalculate(double distance, double usageKG, double speed) {
        double v = fuelCalculate(distance, usageKG) / timeCalculate(distance, speed);
        return Math.ceil(v);
    }


}
