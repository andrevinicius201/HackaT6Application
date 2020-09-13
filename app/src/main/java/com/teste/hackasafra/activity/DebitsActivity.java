package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.teste.hackasafra.R;
import com.teste.hackasafra.RecyclerItemClickListener;
import com.teste.hackasafra.adapter.AdapterDebits;
import com.teste.hackasafra.model.Debits;

import java.util.ArrayList;
import java.util.List;

public class DebitsActivity extends AppCompatActivity {

    private RecyclerView recyclerDebits;
    private List<Debits> listDebits = new ArrayList<>();
    private Button buttonBack;
    private Button buttonHome;
    private Button buttonCollection;
    private Button buttonDebits;
    private int stickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debits);

        // ActionBar configurations
        setTitle("DÉBITOS");
        getSupportActionBar().setElevation(0);

        // Find view by ID
        recyclerDebits = findViewById(R.id.recyclerDebits);
        buttonBack = findViewById(R.id.buttonBack2);
        buttonHome = findViewById(R.id.buttonHomeBottom3);
        buttonCollection = findViewById(R.id.buttonCollectionBottom3);
        buttonDebits = findViewById(R.id.buttonDebitsBottom3);

        // Get sent data
        Bundle data = getIntent().getExtras();
        stickers = data.getInt("stickers");

        // List of debits
        this.createDebits();

        // Adapter configurations
        final AdapterDebits adapterDebits = new AdapterDebits(listDebits);

        // Recycler View configurations
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext() );
        recyclerDebits.setLayoutManager( layoutManager );
        recyclerDebits.setHasFixedSize( true ); // Determine fixed size
        recyclerDebits.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL )); // Creates a vertical divisor
        recyclerDebits.setAdapter( adapterDebits );

        // Configure Click Event
        recyclerDebits.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerDebits,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Debits debit = listDebits.get( position );

                                stickers += 2;

                                debit.setStatus("Aprovado");
                                adapterDebits.notifyItemChanged( position );

                                Toast.makeText(
                                        getApplicationContext(),
                                        Html.fromHtml("<font color='#374281' ><b>" + "Você ganhou 2 figurinhas" + "</b></font>"),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        // Action methods for button click
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("stickers", stickers);

                setResult(RESULT_OK, intent);

                finish();
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                startActivity( intent );
            }
        });

        buttonCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getApplicationContext(), SafraCollectionActivity.class );
                startActivity( intent );
            }
        });

        buttonDebits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), DebitsActivity.class );
                startActivity( intent );
            }
        });
    }

    // Method used for list the insurances
    public void createDebits (){

        Debits debits = new Debits( "Eletropaulo", "R$ 256,41", "Pendente");
        this.listDebits.add(debits);

        debits = new Debits( "SABESP", "R$ 163,90", "Pendente");
        this.listDebits.add(debits);

        debits = new Debits( "TIM", "R$ 79,90", "Pendente");
        this.listDebits.add(debits);

    }
}
