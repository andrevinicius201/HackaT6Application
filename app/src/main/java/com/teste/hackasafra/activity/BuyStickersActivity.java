package com.teste.hackasafra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.teste.hackasafra.R;

public class BuyStickersActivity extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonPlusOne;
    private Button buttonPlusFive;
    private Button buttonPlusTen;
    private Button buttonBuyIt;
    private TextView textStickersBalance;
    private TextView textStickersQuantity;
    private TextView textStickersValue;
    private int totalValue, quantity, balance, stickers, totalStickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_stickers);

        getSupportActionBar().setElevation(0);
        setTitle("SAFRA COLLECTION - ADQUIRIR FIGURINHAS");

        buttonBack = findViewById(R.id.buttonBack3);
        buttonBuyIt = findViewById(R.id.buttonBuyIt);
        buttonPlusOne = findViewById(R.id.buttonPlusOne);
        buttonPlusFive = findViewById(R.id.buttonPlusFive);
        buttonPlusTen = findViewById(R.id.buttonPlusTen);
        textStickersBalance = findViewById(R.id.textStickerBalance2);
        textStickersQuantity = findViewById(R.id.textStickersQuantity);
        textStickersValue = findViewById(R.id.textStickersValue);

        // Initialize quantity and value for the calculation
        quantity = 0;
        totalValue = 0;
        textStickersQuantity.setText(quantity + " Figurinhas");
        textStickersValue.setText("R$ " + totalValue + ",00");

        // Get sent data
        Bundle data = getIntent().getExtras();
        stickers = data.getInt("stickers");
        totalStickers = data.getInt("totalStickers");
        balance = data.getInt("balance");

        // Configure retrieved data
        textStickersBalance.setText( String.valueOf(stickers) + "/" + String.valueOf(totalStickers));

        // Action methods for button click
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("stickers", stickers);
                intent.putExtra("balance", balance);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                textStickersQuantity.setText(quantity + " Figurinhas");
                totalValue = quantity * 50;
                textStickersValue.setText("R$ " + totalValue + ",00");
            }
        });

        buttonPlusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity += 5;
                textStickersQuantity.setText(quantity + " Figurinhas");
                totalValue = quantity * 50;
                textStickersValue.setText("R$ " + totalValue + ",00");
            }
        });

        buttonPlusTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity += 10;
                textStickersQuantity.setText(quantity + " Figurinhas");
                totalValue = quantity * 50;
                textStickersValue.setText("R$ " + totalValue + ",00");
            }
        });

        buttonBuyIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Toast.makeText(
                getApplicationContext(),
                Html.fromHtml(
                    "<font color='#374281' ><b>"
                        + "Você comprou "
                        + quantity
                        + " figurinhas"
                        + "</b></font>"),
                Toast.LENGTH_SHORT
            ).show();

            balance -= totalValue;
            stickers += quantity;
            textStickersBalance.setText(String.valueOf(stickers) + "/" + String.valueOf(totalStickers));

            if (stickers >= totalStickers) { // If the client earned the prize
                stickers -= totalStickers;
                textStickersBalance.setText(String.valueOf(stickers) + "/" + String.valueOf(totalStickers));
                Toast.makeText(
                        getApplicationContext(),
                        Html.fromHtml("<font color='#374281' ><b>" + "PARABÉNS! VOCÊ GANHOU UMA GELADEIRA!" + "</b></font>"),
                        Toast.LENGTH_LONG
                ).show();
            }

            quantity = 0;
            totalValue = 0;
            textStickersQuantity.setText(quantity + " Figurinhas");
            textStickersValue.setText("R$ " + totalValue + ",00");
            }
        });
    }
}
