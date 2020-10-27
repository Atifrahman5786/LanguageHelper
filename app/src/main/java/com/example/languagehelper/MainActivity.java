package com.example.languagehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnFamily, btnNumbers, btnConversations, btnBasics;
    private LinearLayout lineartextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFamily = findViewById(R.id.btnFamily);
        btnNumbers = findViewById(R.id.btnNumbers);
        btnConversations = findViewById(R.id.btnConversations);
        btnBasics = findViewById(R.id.btnBasics);
        lineartextView = findViewById(R.id.linearTextView);

        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);

            }
        });

        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lineartextView.setBackground(Color.RED);
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
                //lineartextView.setBackgroundColor(Color.RED);
            }
        });

        btnConversations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConversationActivity.class);
                startActivity(intent);
                //lineartextView.setBackgroundColor(Color.BLUE);
            }
        });

        btnBasics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicsActivity.class);
                startActivity(intent);
                //lineartextView.setBackgroundColor(Color.GREEN);
            }
        });
    }
}