package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.teste.hackasafra.R;
import com.teste.hackasafra.adapter.AdapterStatement;
import com.teste.hackasafra.model.Statement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerStatement;
    private List<Statement> listStatement = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar configurations
        getSupportActionBar().setElevation(0); // Remove the shadow
        setTitle("MENU PRINCIPAL"); // Set a title
        //getActionBar().setIcon(R.drawable.); // Set an Icon

        recyclerStatement = findViewById(R.id.recyclerStatement);

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
