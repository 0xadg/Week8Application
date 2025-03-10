package com.example.week8application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText number1Text;
    private EditText number2Text;
    private TextView resultText;
    private Button sumButton;
    private Button subButton;
    private Button mulButton;
    private Button divButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        number1Text = findViewById(R.id.number1Input);
        number2Text = findViewById(R.id.number2Input);
        resultText = findViewById(R.id.resultText);

        sumButton = findViewById(R.id.sumButton);
        sumButton.setOnClickListener(this);
        subButton = findViewById(R.id.subButton);
        subButton.setOnClickListener(this);
        mulButton = findViewById(R.id.mulButton);
        mulButton.setOnClickListener(this);
        divButton = findViewById(R.id.divButton);
        divButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        try
        {
            // converting to floats
            float num1 = Float.parseFloat(number1Text.getText().toString());
            float num2 = Float.parseFloat(number2Text.getText().toString());
            float result = 0;

            // switch doesn't work with R.id, had to resort to this
            if(v.getId() == R.id.sumButton) {
                result = num1 + num2;
            } else if (v.getId() == R.id.subButton) {
                result = num1 - num2;
            } else if (v.getId() == R.id.mulButton) {
                result = num1 * num2;
            } else if (v.getId() == R.id.divButton) {
                result = num1 / num2;
            }
            resultText.setText(String.format(Locale.ROOT,"%.2f", result));
        }
        catch (NumberFormatException e)
        {
            resultText.setText("Not a number!");
        }

    }
}