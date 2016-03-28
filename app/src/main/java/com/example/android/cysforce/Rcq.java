package com.example.android.cysforce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import java.text.DecimalFormat;

public class Rcq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcq);
    }

    public void abrirResultadoRcq(View view) {
        Intent resultadoRcqActivity = new Intent(this, ResultadoRcq.class);
        startActivity(resultadoRcqActivity);
    }

    public void reset(View view) {
        DecimalFormat format = new DecimalFormat("#.##");

        EditText editCintura = (EditText) findViewById(R.id.edit_cintura);

        String vlrCintura = format.format(0.00);
        editCintura.setText(vlrCintura);
        Log.v("MainActivity", "Cintura: " + vlrCintura);

        EditText editQuadril = (EditText) findViewById(R.id.edit_quadril);
        String vlrQuadril = format.format(0.00);
        editQuadril.setText(vlrCintura);
        Log.v("MainActivity", "Quadril: " + vlrQuadril);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void resultadoRcq(View view) {
        Switch swtSexo = (Switch) findViewById(R.id.sexo_switch);
        EditText editCintura = (EditText) findViewById(R.id.edit_cintura);
        EditText editQuadril = (EditText) findViewById(R.id.edit_quadril);

        boolean isHomem = swtSexo.getShowText();

        String vlrCintura = editCintura.getText().toString();
        String vlrQuadril = editQuadril.getText().toString();

        Float rcq = Float.parseFloat(vlrCintura) / Float.parseFloat(vlrQuadril);

        String resultRcq = "";
        if (isHomem == true) {
            if (rcq <= 0.89) {
                resultRcq = "Risco: Baixo";
            } else if (rcq <= 0.90) {
                resultRcq = "Risco: Moderado";
            } else if (rcq <= 0.96) {
                resultRcq = "Risco: Alto";
            } else {
                resultRcq = "Risco: Muito Alto";
            }
        } else {
            if (rcq <= 0.74) {
                resultRcq = "Risco: Baixo";
            } else if (rcq <= 0.76) {
                resultRcq = "Risco: Moderado";
            } else if (rcq <= 0.86) {
                resultRcq = "Risco: Alto";
            } else {
                resultRcq = "Risco: Muito Alto";
            }
        }

        EditText rrr = (EditText) findViewById(R.id.rrrrtext);
        rrr.setText(rcq.toString());

        Intent resultadoActivity = new Intent(this, ResultadoRcq.class);
        resultadoActivity.putExtra("result_rcq", resultRcq);
        startActivity(resultadoActivity);

    }

}
