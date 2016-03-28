package com.example.android.cysforce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultadoRcq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_rcq);

        Intent intent = getIntent();
        String finalResult = intent.getStringExtra("result_rcq");

        TextView resultado = (TextView) findViewById(R.id.result_rcq_text);
        resultado.setText(finalResult);
    }
}
