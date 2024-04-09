package com.example.jobsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseCompanies extends AppCompatActivity {

    EditText companyNameEditText, ceoNameEditText, headOfficeEditText, emailEditText, contactEditText, companyTypeEditText;
    DatabaseHelper dbHelper; // Assuming DatabaseHelper is accessible here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosecompanies);

        // Initialize DatabaseHelper (assuming it's accessible here)
        dbHelper = new DatabaseHelper(this);

        // Initialize EditText fields
        companyNameEditText = findViewById(R.id.editTextCompanyName);
        ceoNameEditText = findViewById(R.id.editTextCEOName);
        headOfficeEditText = findViewById(R.id.editTextHeadOffice);
        emailEditText = findViewById(R.id.editTextEmail);
        contactEditText = findViewById(R.id.editTextContact);
        companyTypeEditText = findViewById(R.id.editTextCompanyType);

        // Button for Next
        Button nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText fields
                String companyName = companyNameEditText.getText().toString().trim();
                String ceoName = ceoNameEditText.getText().toString().trim();
                String headOffice = headOfficeEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String contact = contactEditText.getText().toString().trim();
                String companyType = companyTypeEditText.getText().toString().trim();

                // Validate input fields
                if (companyName.isEmpty() || ceoName.isEmpty() || headOffice.isEmpty() ||
                        email.isEmpty() || contact.isEmpty() || companyType.isEmpty()) {
                    showToast("All fields are required.");
                } else {
                    // Insert data into database using existing DatabaseHelper
                    long newRowId = dbHelper.insertCompany(companyName, ceoName, headOffice,
                            email, contact, companyType);
                    if (newRowId != -1) {
                        showToast("Data inserted successfully.");
                        // Proceed to next activity or action
                        // For example, start CompanyDetails2 activity
                        Intent intent = new Intent(ChooseCompanies.this, CompanyDetails2.class);
                        startActivity(intent);
                    } else {
                        showToast("Error inserting data.");
                    }
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
