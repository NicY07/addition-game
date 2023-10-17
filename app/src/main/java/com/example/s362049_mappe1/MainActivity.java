package com.example.s362049_mappe1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startknapp = findViewById(R.id.startSpill);
        Intent i = new Intent(this, StartSpill.class);
        startknapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

        Button omspillknapp = findViewById(R.id.omSpillet);
        Intent j = new Intent(this, OmSpillet.class);
        omspillknapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(j);
            }
        });

        Button preferanseknapp=findViewById(R.id.preferanser);
        Intent k = new Intent(this, SettingsActivity.class);
        preferanseknapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(k);
            }
        });
    }
}