package com.example.myapplication;

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

import java.text.DecimalFormat;

public class TipCalculator extends AppCompatActivity {

    private EditText editTextBillAmount, editTextTipPercentage;
    private Button buttonCalculate;
    private TextView textviewTipAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tip_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextTipPercentage =findViewById(R.id.editTextTipPercentage);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textviewTipAmount = findViewById(R.id.textViewTipAmount);

        buttonCalculate.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View v){
            calculateTip();
        }

        });


    }
    private void calculateTip(){
        double billAmount = Double.parseDouble(editTextBillAmount.getText().toString());
        double tipPercentage = Double.parseDouble(editTextTipPercentage.getText().toString());

        double tipAmount = (billAmount*tipPercentage)/100;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedTipAmount = decimalFormat.format(tipAmount);
        textviewTipAmount.setText("Tip Amount : $" + formattedTipAmount);
    }

}