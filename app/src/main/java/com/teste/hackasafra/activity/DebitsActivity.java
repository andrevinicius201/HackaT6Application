package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debits);

        // ActionBar configurations
        setTitle("DÉBITOS");
        getSupportActionBar().setElevation(0);

        // Find view by ID
        recyclerDebits = findViewById(R.id.recyclerDebits);

        // List of debits
        this.createDebits();

        // Adapter configurations
        final AdapterDebits adapterDebits = new AdapterDebits(listDebits);

        // Recycler View configurations
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext() );
        recyclerDebits.setLayoutManager( layoutManager );
        recyclerDebits.setHasFixedSize( true ); // Determina que há um tamanho fixo
        recyclerDebits.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL )); // Cria divisor vertical
        recyclerDebits.setAdapter( adapterDebits );

        // Configurar Evento de Clique
        recyclerDebits.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerDebits,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Debits debit = listDebits.get( position );

                                debit.setStatus("Aprovado");
                                adapterDebits.notifyItemChanged( position );
                                Toast.makeText(
                                        getApplicationContext(),
                                        Html.fromHtml("<font color='#374281' ><b>" + "Você ganhou 2 figurinhas" + "</b></font>"),
                                        //"Você ganhou 2 figurinhas",
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
