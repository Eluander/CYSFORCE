package com.example.android.cysforce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirViewOpcoes(View view) {
        Intent rcqActivity = new Intent(this, Rcq.class);
        startActivity(rcqActivity);
    }
}
