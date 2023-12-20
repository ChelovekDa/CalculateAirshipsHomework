package com.example.calculateairshipshomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button culcButton = findViewById(R.id.button);
        culcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText distanceInput = findViewById(R.id.distanceInput);
                double distance = Double.valueOf((String) distanceInput.getText().toString());

                createApplication(distance);
            }
        });
    }

    private static String buildAirShip(Airship object, double distance, double usage, double speed, int capacity) {
        String text = "Необходимое топливо для полета: " + object.fuelCalculate(distance, usage) + " кг" + "\n";
        text = text + "Время полета: " + object.timeCalculate(distance, speed) + " часа(ов)" + "\n";
        text = text + "Расход топлива: " + object.fuelUsageCalculate(distance, object.fuelCalculate(distance, usage), speed) + " кг/час" + "\n";
        text = text + "Вместимость: " + capacity + " человек";
        return text;
    }

    private static String buildHelicopter(Helicopter object, double distance, double usage, double speed, int capacity) {
        String text = "Необходимое топливо для полета: " + object.fuelCalculate(distance, usage) + " кг" + "\n";
        text = text + "Время полета: " + object.timeCalculate(distance, speed) + " часа(ов)" + "\n";
        text = text + "Расход топлива: " + object.fuelUsageCalculate(distance, usage, speed) + " кг/час" + "\n";
        text = text + "Вместимость: " + capacity + " человек";
        return text;
    }

    private void createApplication(double distance) {
        Helicopter helicopter = new Helicopter();
        Airship airshipOneObject = new Airship(850);

        TextView asOneView = findViewById(R.id.airshipOne);
        asOneView.setText(buildAirShip(airshipOneObject, distance, 3700, 850, 210));

        TextView asTwoView = findViewById(R.id.airshipTwo);
        asTwoView.setText(buildAirShip(airshipOneObject, distance, 2800, 900, 189));

        TextView asThreeView = findViewById(R.id.airshipThree);
        asThreeView.setText(buildHelicopter(helicopter, distance, 14, 250, 8));

    }
}