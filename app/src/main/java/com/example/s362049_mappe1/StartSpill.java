package com.example.s362049_mappe1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartSpill extends AppCompatActivity implements View.OnClickListener{
    TextView regnestykk;
    EditText svarfelt;
    TextView resultat;
    private String riktigSvar;
    int teller = 1;
    int antallRegnestykker;
    List<String> regnestykkerArr = new ArrayList<>();
    List<String> regnestykkerSvar = new ArrayList<>();

    public void velgeRegnestykker() {
        if (teller <= antallRegnestykker) {
            Random random = new Random();
            int indeks = random.nextInt(regnestykkerArr.size());
            String valgtRegnestykk = regnestykkerArr.get(indeks);
            riktigSvar = regnestykkerSvar.get(indeks);
            boolean removed = regnestykkerArr.remove(valgtRegnestykk);
            regnestykkerSvar.remove(indeks);
            regnestykk = (TextView) findViewById(R.id.regnestykke);
            regnestykk.setText(valgtRegnestykk + " = ?");
            teller++;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle(R.string.ferdigmelding);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            });
            builder.show();
        }
    }

    private void sjekkSvar(int riktigSvar, int svar) {
        if (svar == riktigSvar) {
            resultat.setText(R.string.riktig);
            resultat.setTextColor(ContextCompat.getColor(this, R.color.green));
            svarfelt.setText("");
            velgeRegnestykker();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resultat.setText("");
                }
            }, 4000);
        } else if (svar < riktigSvar) {
            resultat.setText(R.string.feilforlite);
            resultat.setTextColor(ContextCompat.getColor(this, R.color.red));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resultat.setText("");
                }
            }, 6000);
        } else if (svar > riktigSvar) {
            resultat.setText(R.string.feilforhøy);
            resultat.setTextColor(ContextCompat.getColor(this, R.color.red));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resultat.setText("");
                }
            }, 6000);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.avbryte);
        builder.setMessage(R.string.avbrytemsg);
        builder.setPositiveButton(R.string.ja, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.nei, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                return;
            }
        });
        builder.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putString("regnestykk",regnestykk.getText().toString());
        outstate.putString("svarfelt",svarfelt.getText().toString());
        outstate.putString("resultatet",resultat.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle
                                                  savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        regnestykk.setText(savedInstanceState.getString("regnestykk"));
        svarfelt.setText(savedInstanceState.getString("svarfelt"));
        resultat.setText(savedInstanceState.getString("resultat"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_spill);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        antallRegnestykker = Integer.parseInt((sharedPreferences.getString("antallpreferanse","5")));
        regnestykkerArr.addAll(Arrays.asList(getResources().getStringArray(R.array.regnestykkerArr)));
        regnestykkerSvar.addAll(Arrays.asList(getResources().getStringArray(R.array.regnestykkerSvar)));
        velgeRegnestykker();

        svarfelt = findViewById(R.id.svar);
        resultat = findViewById(R.id.resultat);
        Button nullknapp = findViewById(R.id.zero);
        nullknapp.setOnClickListener(this);
        Button enknapp = findViewById(R.id.one);
        enknapp.setOnClickListener(this);
        Button toknapp = findViewById(R.id.two);
        toknapp.setOnClickListener(this);
        Button treknapp = findViewById(R.id.three);
        treknapp.setOnClickListener(this);
        Button fireknapp = findViewById(R.id.four);
        fireknapp.setOnClickListener(this);
        Button femknapp = findViewById(R.id.five);
        femknapp.setOnClickListener(this);
        Button seksknapp = findViewById(R.id.six);
        seksknapp.setOnClickListener(this);
        Button syvknapp = findViewById(R.id.seven);
        syvknapp.setOnClickListener(this);
        Button atteknapp = findViewById(R.id.eight);
        atteknapp.setOnClickListener(this);
        Button niknapp = findViewById(R.id.nine);
        niknapp.setOnClickListener(this);
        Button tomknapp = findViewById(R.id.tom);
        tomknapp.setOnClickListener(this);
        Button ferdigknapp = findViewById(R.id.ferdig);
        ferdigknapp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.zero) {
            svarfelt.append("0");
        } else if (id == R.id.one) {
            svarfelt.append("1");
        } else if (id == R.id.two) {
            svarfelt.append("2");
        } else if (id == R.id.three) {
            svarfelt.append("3");
        } else if (id == R.id.four) {
            svarfelt.append("4");
        } else if (id == R.id.five) {
            svarfelt.append("5");
        } else if (id == R.id.six) {
            svarfelt.append("6");
        } else if (id == R.id.seven) {
            svarfelt.append("7");
        } else if (id == R.id.eight) {
            svarfelt.append("8");
        } else if (id == R.id.nine) {
            svarfelt.append("9");
        } else if (id == R.id.tom) {
            svarfelt.setText("");
        } else if (id == R.id.ferdig) {
            String finalsvar = svarfelt.getText().toString();
            int riktigSvarInt = Integer.parseInt(riktigSvar);
            int finalsvarInt = Integer.parseInt(finalsvar);
            sjekkSvar(riktigSvarInt,finalsvarInt);
        }
    }
}
