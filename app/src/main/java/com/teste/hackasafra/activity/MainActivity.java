package com.teste.hackasafra.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.teste.hackasafra.R;
import com.teste.hackasafra.adapter.AdapterStatement;
import com.teste.hackasafra.model.Statement;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity<buttonColection> extends AppCompatActivity {

    private RecyclerView recyclerStatement;
    private List<Statement> listStatement = new ArrayList<>();
    private Button buttonCollection;
    private Button buttonCollectionBottom;
    private Button buttonInsurance;
    private Button buttonDebits;
    private TextView textBalance;
    private int balance = 6000; // Arbitrary balance
    private int stickers = 20; // Statements amount
    private boolean backButtonPressed = false; // Check if it was returned for this Activity by another one

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
        textBalance = findViewById(R.id.textBalance);

        textBalance.setText("R$ " + balance + ",00");

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

                // Send data through intent to another activity
                intent.putExtra("balance", balance);
                intent.putExtra("stickers", stickers);

                startActivityForResult( intent, 1 );

            }
        });

        buttonCollectionBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent determine which activity this action will show
                Intent intent = new Intent ( getApplicationContext(), SafraCollectionActivity.class );

                // Send data through intent to another activity
                intent.putExtra("balance", balance);
                intent.putExtra("stickers", stickers);

                startActivityForResult( intent, 2 );

            }
        });

        buttonInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent determine which activity this action will show
                Intent intent = new Intent ( getApplicationContext(), HireInsuranceActivity.class );

                intent.putExtra("stickers", stickers);

                startActivityForResult( intent, 3 );

            }
        });

        buttonDebits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent ( getApplicationContext(), DebitsActivity.class );

                intent.putExtra("stickers", stickers);

                startActivityForResult( intent, 4 );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1: // Collection
            case 2: // Collection Bottom
                if (resultCode == RESULT_OK){
                    stickers = data.getExtras().getInt("stickers");
                    balance = data.getExtras().getInt("balance");
                    textBalance.setText("R$ " + balance + ",00");
                }
                break;

            case 3: // Insurance
            case 4: // Debits
                if (resultCode == RESULT_OK){
                    stickers = data.getExtras().getInt("stickers");
                }
                break;
        }
    }

    // Method used for list the statements
    public void createStatement (){

        Statement statement = new Statement( "Burguer King Shopping Jardim Sul", "29/AGO", "R$ 51,99", "1 Figurinha");
        this.listStatement.add(statement);

        statement = new Statement( "C&A Shopping Jardim Sul", "29/AGO", "R$ 164,00", "3 Figurinhas");
        this.listStatement.add(statement);

        statement = new Statement( "Compra Online STEAM", "28/AGO", "R$ 5,34", "");
        this.listStatement.add(statement);

        statement = new Statement( "Transferência para Warren Buffett", "27/AGO", "R$ 20,00", "1 Figurinha");
        this.listStatement.add(statement);

        statement = new Statement( "Pagamento TIM BLACK", "27/AGO", "R$ 230,78", "4 Figurinhas");
        this.listStatement.add(statement);


    }

    // Method for DialogAlert
    public void openDialog (View view){

        // Instance AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        // Set up the input
        final EditText input = new EditText(this);

        // Configure title and message
        dialog.setTitle("CONVIDE AMIGOS");
        dialog.setMessage("Digite o nome do amigo que deseja convidar");
        // Specify the type of input expected
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        input.setPadding(100,0,0,0);
        dialog.setView(input);

        // Configure AlertDialog cancel possibility
        dialog.setCancelable(false); // That way it's impossible to close the DialogAlert without choosing an option

        // Configure Yes / No Actions
        dialog.setPositiveButton("Convidar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                stickers += 10;

                Toast.makeText(
                        getApplicationContext(),
                        Html.fromHtml("<font color='#374281' ><b>" + "Você ganhou 10 figurinhas" + "</b></font>"),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        Html.fromHtml("<font color='#374281' ><b>" + "ATENÇÃO: Convide amigos para ganhar figurinhas" + "</b></font>"),
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        // Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
    }
}
