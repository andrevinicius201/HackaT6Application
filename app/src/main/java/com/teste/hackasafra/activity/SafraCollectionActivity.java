package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teste.hackasafra.R;

public class SafraCollectionActivity extends AppCompatActivity {

    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safra_collection);

        // ActionBar configurations
        getSupportActionBar().setElevation(0); // Remove the shadow
        setTitle("SAFRA COLLECTION"); // Set a title

        // Find view by ID
        buttonBack = findViewById(R.id.buttonBack);

        // Action method for the button click
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish(); // This method finishes the Activity, as the Activities are stacked, the last one is shown

            }
        });
    }
}
