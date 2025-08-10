package com.example.tabletpurchasefinancecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final double PRICE_SMALL_TABLET = 2500.00;
    private static final double PRICE_MEDIUM_TABLET = 3500.00;
    private static final double PRICE_LARGE_TABLET = 4500.00;
    private static final double INTEREST_RATE = 0.854;
    private static final int MONTHS = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextMessage = findViewById(R.id.editTextMessage);
        EditText editTextChoice = findViewById(R.id.editTextChoice);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();
                String message = editTextMessage.getText().toString().trim();
                String choice = editTextChoice.getText().toString().trim().toUpperCase();

                double selectedPrice = 0.0;
                if (choice.equals("S")) {
                    selectedPrice = PRICE_SMALL_TABLET;
                } else if (choice.equals("M")) {
                    selectedPrice = PRICE_MEDIUM_TABLET;
                } else if (choice.equals("L")) {
                    selectedPrice = PRICE_LARGE_TABLET;
                } else {
                    Toast.makeText(MainActivity.this, "Invalid choice. Please enter S, M, or L.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double totalCreditPrice = selectedPrice + (selectedPrice * INTEREST_RATE);
                double monthlyInstallment = totalCreditPrice / MONTHS;

                DecimalFormat currencyFormat = new DecimalFormat("R0.00");
                String formattedMonthlyInstallment = currencyFormat.format(monthlyInstallment);
                String formattedTotalCreditPrice = currencyFormat.format(totalCreditPrice);

                String resultText = "Hello " + name + ",\n" +
                        message + "\n" +
                        "Monthly Installment: " + formattedMonthlyInstallment + "\n" +
                        "Total Credit Price: " + formattedTotalCreditPrice;

                textViewResult.setText(resultText);
            }
        });
    }
}
