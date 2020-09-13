package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.teste.hackasafra.R;
import com.teste.hackasafra.adapter.AdapterInsurance;
import com.teste.hackasafra.model.Insurance;

import java.util.ArrayList;
import java.util.List;

public class HireInsuranceActivity extends AppCompatActivity {

    private RecyclerView recyclerInsurance;
    private List<Insurance> listInsurance = new ArrayList<>();
    private Button buttonHomeBottom;
    private Button buttonCollectionBottom;
    private Button buttonBack;
    private Button buttonHire;
    private int stickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_insurance);

        // ActionBar configurations
        getSupportActionBar().setElevation(0); // Remove the shadow
        setTitle("CONTRATAR SEGURO"); // Set a title

        // Find view by ID
        recyclerInsurance = findViewById(R.id.recyclerInsurance);
        buttonBack = findViewById(R.id.buttonBack);
        buttonCollectionBottom = findViewById(R.id.buttonCollectionBottom2);
        buttonHomeBottom = findViewById(R.id.buttonHomeBottom2);
        buttonHire = findViewById(R.id.buttonHire);

        // Get sent data
        Bundle data = getIntent().getExtras();
        stickers = data.getInt("stickers");

        // List of Insurance
        this.createInsurance();

        // Adapter configuration ( Adapter receive data, format the layout and use it on Recycler View )
        AdapterInsurance adapterInsurance = new AdapterInsurance( listInsurance );

        // RecyclerView configuration
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext() );
        recyclerInsurance.setLayoutManager( layoutManager );
        recyclerInsurance.setHasFixedSize( true ); // Determina que há um tamanho fixo
        recyclerInsurance.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL )); // Cria divisor vertical
        recyclerInsurance.setAdapter( adapterInsurance );

        // Action method for the button click
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("stickers", stickers);

                setResult(RESULT_OK, intent);

                finish();
            }
        });

        buttonHomeBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext(), MainActivity.class );
                startActivity( intent );
            }
        });

        buttonCollectionBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( getApplicationContext(), SafraCollectionActivity.class);
                startActivity( intent );

            }
        });

        buttonHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickers += 4;

                Toast.makeText(
                        getApplicationContext(),
                        Html.fromHtml("<font color='#374281' ><b>" + "Você ganhou 4 figurinhas" + "</b></font>"),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    // Method used for list the insurances
    public void createInsurance (){

        Insurance insurance = new Insurance( "Incêndio, queda de raio, explosão", "R$ 200.000,00");
        this.listInsurance.add(insurance);

        insurance = new Insurance( "Danos elétricos", "R$ 16.000,00");
        this.listInsurance.add(insurance);

        insurance = new Insurance( "Roubo ou Furto Qualificado", "R$ 20.000,00");
        this.listInsurance.add(insurance);

    }
}
