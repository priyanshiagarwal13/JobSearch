package com.example.jobsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyDetails2 extends AppCompatActivity {

    EditText editTextMission, editTextVision, editTextPositionsAvailable,
            editTextJobDescription, editTextJobRequirements, editTextJobSpecifications;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companydetails2);

        // Initialize views
        editTextMission = findViewById(R.id.editTextMission);
        editTextVision = findViewById(R.id.editTextVision);
        editTextPositionsAvailable = findViewById(R.id.editTextPositionsAvailable);
        editTextJobDescription = findViewById(R.id.editTextJobDescription);
        editTextJobRequirements = findViewById(R.id.editTextJobRequirements);
        editTextJobSpecifications = findViewById(R.id.editTextJobSpecifications);
        nextButton = findViewById(R.id.buttonNext);

        // Set click listener for Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from EditText fields
                String mission = editTextMission.getText().toString().trim();
                String vision = editTextVision.getText().toString().trim();
                String positionsAvailable = editTextPositionsAvailable.getText().toString().trim();
                String jobDescription = editTextJobDescription.getText().toString().trim();
                String jobRequirements = editTextJobRequirements.getText().toString().trim();
                String jobSpecifications = editTextJobSpecifications.getText().toString().trim();

                // Validate input fields
                if (mission.isEmpty() || vision.isEmpty() || positionsAvailable.isEmpty() ||
                        jobDescription.isEmpty() || jobRequirements.isEmpty() || jobSpecifications.isEmpty()) {
                    showToast("All fields are required");
                    return;
                }

                // Store the values or pass them to another activity as needed
                // For example, you can use Intent extras to pass these values to the next activity
                Intent intent = new Intent(CompanyDetails2.this, CompanyRequirements.class);
                intent.putExtra("mission", mission);
                intent.putExtra("vision", vision);
                intent.putExtra("positionsAvailable", positionsAvailable);
                intent.putExtra("jobDescription", jobDescription);
                intent.putExtra("jobRequirements", jobRequirements);
                intent.putExtra("jobSpecifications", jobSpecifications);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

