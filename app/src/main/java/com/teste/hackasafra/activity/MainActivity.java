package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.teste.hackasafra.R;
import com.teste.hackasafra.adapter.AdapterStatement;
import com.teste.hackasafra.model.Statement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<buttonColection> extends AppCompatActivity {

    private RecyclerView recyclerStatement;
    private List<Statement> listStatement = new ArrayList<>();
    private Button buttonCollection;
    private Button buttonCollectionBottom;
    private Button buttonInsurance;
    private Button buttonDebits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar configurations
        getSupportActionBar().setElevation(0); // Remove the shadow
        setTitle("MENU PRINCIPAL"); // Set a title
        //getActionBar().setIcon(R.drawable.); // Set an Icon

        // Find view by ID
        recyclerStatement = findViewById(R.id.recyclerStatement);
        buttonCollection = findViewById(R.id.buttonCollection);
        buttonCollectionBottom = findViewById(R.id.buttonCollectionBottom);
        buttonInsurance = findViewById(R.id.buttonInsurance);
        buttonDebits = findViewById(R.id.buttonDebitsBottom);

        // List of Statements
        this.createStatement();

        // Adapter configuration ( Adapter receive data, format the layout and use it on Recycler View )
        AdapterStatement adapterStatement = new AdapterStatement( listStatement );

        // RecyclerView configuration
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext() );
        recyclerStatement.setLayoutManager( layoutManager );
        recyclerStatement.setHasFixedSize( true ); // Determina que há um tamanho fixo
        recyclerStatement.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL )); // Cria divisor vertical
        recyclerStatement.setAdapter( adapterStatement );

        // Action method for the button click
        buttonCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent determine which activity this action will show
                Intent intent = new Intent ( getApplicationContext(), SafraCollectionActivity.class );

                startActivity( intent );

            }
        });

        buttonCollectionBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent determine which activity this action will show
                Intent intent = new Intent ( getApplicationContext(), SafraCollectionActivity.class );

                startActivity( intent );

            }
        });

        buttonInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent determine which activity this action will show
                Intent intent = new Intent ( getApplicationContext(), HireInsuranceActivity.class );

                startActivity( intent );

            }
        });

        buttonDebits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent ( getApplicationContext(), DebitsActivity.class );

                startActivity( intent );
            }
        });
    }

    // Method used for list the statements
    public void createStatement (){

        Statement statement = new Statement( "Burguer King Shopping Jardim Sul", "29/AGO", "R$ 49,99", "2 Figurinhas");
        this.listStatement.add(statement);

        statement = new Statement( "C&A Shopping Jardim Sul", "29/AGO", "R$ 134,00", "6 Figurinhas");
        this.listStatement.add(statement);

        statement = new Statement( "Compra Online STEAM", "29/AGO", "R$ 5,34", "");
        this.listStatement.add(statement);

        statement = new Statement( "Transferência para Warren Buffett", "29/AGO", "R$ 20,00", "1 Figurinha");
        this.listStatement.add(statement);

        statement = new Statement( "Pagamento TIM BLACK", "29/AGO", "R$ 230,78", "11 Figurinhas");
        this.listStatement.add(statement);


    }
}
