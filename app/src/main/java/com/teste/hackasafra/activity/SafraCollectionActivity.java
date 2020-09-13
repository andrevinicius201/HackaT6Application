package com.teste.hackasafra.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.teste.hackasafra.R;

public class SafraCollectionActivity extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonBuy;
    private TextView textStickersBalance;
    private TextView textStickersLeft;
    private final int TOTAL_STICKERS = 50;
    private int balance, stickers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safra_collection);

        // ActionBar configurations
        getSupportActionBar().setElevation(0); // Remove the shadow
        setTitle("SAFRA COLLECTION"); // Set a title

        // Find view by ID
        buttonBack = findViewById(R.id.buttonBack);
        buttonBuy = findViewById(R.id.buttonBuyStickers);
        textStickersBalance = findViewById(R.id.textStickerBalance);
        textStickersLeft = findViewById(R.id.textStickersLeft);

        // Get sent data
        Bundle data = getIntent().getExtras();
        stickers = data.getInt("stickers");
        balance = data.getInt("balance");

        // Configure retrieved data
        textStickersBalance.setText( String.valueOf(stickers) + "/" + TOTAL_STICKERS);
        textStickersLeft.setText( (TOTAL_STICKERS - stickers) + " figurinhas restantes");

        // Action method for the button click
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("stickers", stickers);
                intent.putExtra("balance", balance);
                setResult(RESULT_OK, intent);
                finish(); // This method finishes the Activity, as the Activities are stacked, the last one is shown

            }
        });

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), BuyStickersActivity.class );
                intent.putExtra("balance", balance);
                intent.putExtra("stickers", stickers);
                intent.putExtra("totalStickers", TOTAL_STICKERS);
                startActivityForResult( intent, 1 );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                stickers = data.getExtras().getInt("stickers");
                balance = data.getExtras().getInt("balance");

                textStickersBalance.setText( String.valueOf(stickers) + "/" + TOTAL_STICKERS);
                textStickersLeft.setText( (TOTAL_STICKERS - stickers) + " figurinhas restantes");
            }
        }
    }
}
