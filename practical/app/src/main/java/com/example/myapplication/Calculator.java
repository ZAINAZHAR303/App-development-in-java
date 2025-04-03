package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
    EditText resultEditText;
    private double operand1 = 0;
    private String operator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultEditText = findViewById(R.id.resultEditText);
    }

    // Method to handle number button clicks
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = resultEditText.getText().toString();
// Append the clicked number to the EditText
        if (currentText.equals("0")) {
            resultEditText.setText(buttonText);
        } else {
            resultEditText.setText(currentText + buttonText);
        }
    }

    // Method to handle operator button clicks
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(resultEditText.getText().toString());
        resultEditText.setText("");
    }

    // Method to handle equals button click
    public void onEqualClick(View view) {
        double operand2 = Double.parseDouble(resultEditText.getText().toString());
        double result = 0;
// Perform the operation based on the operator
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "x":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    resultEditText.setText("Error");
                    return;
                }
                break;
        }
// Display the result
        resultEditText.setText(String.valueOf(result));
    }
    // Method to handle clear button click
    public void onClearClick(View view) {
        resultEditText.setText("0");
        operand1 = 0;
        operator = "";
    }
}