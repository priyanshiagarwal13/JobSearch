package com.example.jobsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    RadioGroup roleRadioGroup;
    Button resetButton, submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        roleRadioGroup = findViewById(R.id.emp);
        resetButton = findViewById(R.id.reset);
        submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = roleRadioGroup.getCheckedRadioButtonId();
                if (checkedId == -1) {
                    showToast("Please select an option.");
                } else {
                    findRole(checkedId);
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roleRadioGroup.clearCheck();
            }
        });
    }

    private void findRole(int checkedId) {
        switch (checkedId) {
            case R.id.radioButton8: // Employer
                showToast("Employer");
                // Redirect to ChooseCompanies only if Employer is selected
                startChooseCompaniesActivity();
                break;
            case R.id.radioButton9: // Employee
                showToast("Employee");
                startSignUpEmployeeActivity();
                break;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void startChooseCompaniesActivity() {
        Intent intent = new Intent(this, CompanyDetails2.class);
        startActivity(intent);
    }

    private void startSignUpEmployeeActivity() {
        Intent intent = new Intent(this, SignUpEmployee.class);
        startActivity(intent);
    }
}

