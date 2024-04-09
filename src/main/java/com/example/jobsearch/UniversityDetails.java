package com.example.jobsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class UniversityDetails extends AppCompatActivity {

    private EditText universityEditText, majorEditText, minorEditText, yearEditText, cgpaEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universitydetails);

        // Initialize views
        universityEditText = findViewById(R.id.editTextUniversityName);
        majorEditText = findViewById(R.id.editTextMajor);
        minorEditText = findViewById(R.id.editTextMinor);
        yearEditText = findViewById(R.id.editTextYearOfGraduating);
        cgpaEditText = findViewById(R.id.editTextCGPA);
        nextButton = findViewById(R.id.nextButtonUniversityDetails);

        // Set click listener for the Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from EditText fields
                String university = universityEditText.getText().toString().trim();
                String major = majorEditText.getText().toString().trim();
                String minor = minorEditText.getText().toString().trim();
                String yearStr = yearEditText.getText().toString().trim();
                String cgpaStr = cgpaEditText.getText().toString().trim();

                // Validate input fields
                if (university.isEmpty() || major.isEmpty() || yearStr.isEmpty() || cgpaStr.isEmpty()) {
                    Toast.makeText(UniversityDetails.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert year and CGPA to integer and double respectively
                int year;
                double cgpa;
                try {
                    year = Integer.parseInt(yearStr);
                    cgpa = Double.parseDouble(cgpaStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(UniversityDetails.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Store the values or pass them to another activity as needed
                storeValues(university, major, minor, year, cgpa);
            }
        });
    }

    private void storeValues(String university, String major, String minor, int year, double cgpa) {
        // You can store these values using SharedPreferences, SQLite database, or pass them to another activity
        // For example, you can use SharedPreferences to store them temporarily
        // SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        // SharedPreferences.Editor editor = preferences.edit();
        // editor.putString("university", university);
        // editor.putString("major", major);
        // editor.putString("minor", minor);
        // editor.putInt("year", year);
        // editor.putFloat("cgpa", (float) cgpa);
        // editor.apply();

        // Alternatively, you can pass these values to another activity using Intent extras
        Intent intent = new Intent(UniversityDetails.this,PersonalPreferences.class);

        intent.putExtra("university", university);
        intent.putExtra("major", major);
        intent.putExtra("minor", minor);
        intent.putExtra("year", year);
        intent.putExtra("cgpa", cgpa);
        startActivity(intent);
    }
}

