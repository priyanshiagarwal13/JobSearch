package com.example.jobsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpEmployee extends AppCompatActivity {

    private EditText nameEditText, ageEditText, emailEditText, cityEditText, pincodeEditText;
    private Button signUpButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupemployee);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        emailEditText = findViewById(R.id.emailEditText);
        cityEditText = findViewById(R.id.cityEditText);
        pincodeEditText = findViewById(R.id.pincodeEditText);
        signUpButton = findViewById(R.id.signUpButton);
        dbHelper = new DatabaseHelper(this);

        // Set click listener for the sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from EditText fields
                String name = nameEditText.getText().toString().trim();
                String ageStr = ageEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String city = cityEditText.getText().toString().trim();
                String pincode = pincodeEditText.getText().toString().trim();

                // Validate input fields
                if (name.isEmpty() || ageStr.isEmpty() || email.isEmpty() || city.isEmpty() || pincode.isEmpty()) {
                    Toast.makeText(SignUpEmployee.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert age to integer
                int age;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(SignUpEmployee.this, "Invalid age format", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insert data into the database
                long result = dbHelper.insertEmployee(name, age, email, city, pincode);
                if (result != -1) {
                    // Data inserted successfully, proceed to the next activity
                    Intent intent = new Intent(SignUpEmployee.this, UniversityDetails.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignUpEmployee.this, "Error inserting data into database", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database when the activity is destroyed
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}


