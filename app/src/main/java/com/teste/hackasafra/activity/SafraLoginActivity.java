package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teste.hackasafra.R;

public class SafraLoginActivity extends AppCompatActivity {

    private Button buttonEntra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safra_login);

        setTitle("LOGIN SAFRA");
        getSupportActionBar().setElevation(0);

        buttonEntra = findViewById(R.id.buttonEntrar);

        buttonEntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext(), MainActivity.class );
                startActivity( intent );
            }
        });

    }

}
