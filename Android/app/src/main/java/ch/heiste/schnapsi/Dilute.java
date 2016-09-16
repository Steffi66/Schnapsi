/*****************************************************************************************
 * Dilute (Verdünnen)
 * ***************************************************************************************
 * Zweck: Klasse für die Verdünnungsrechnung
 *
 * Beschreibung: Hier wird die Verdünnung nach folgender Formel V1*C1=V2*C2 berechnet.
 *               Dabei wird immer die fehlende Variable berechnet.
 *
 * Eingabe: Über das Formular werden drei der vier Variablen eingegeben.
 * Ausgabe: Die fehlende Variable
 *
 * Fehlerbehandlung:
 *
 *****************************************************************************************/

 package ch.heiste.schnapsi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dilute extends AppCompatActivity implements View.OnClickListener {
    protected Button but_Dilute_Calc;
    protected Button but_Dilute_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilute);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Listener für die Buttons kreieren
        but_Dilute_Calc = (Button)findViewById(R.id.but_dilute_calc);
        but_Dilute_Reset = (Button)findViewById(R.id.but_dilute_reset);
        but_Dilute_Calc.setOnClickListener((View.OnClickListener) this);
        but_Dilute_Reset.setOnClickListener((View.OnClickListener) this);

        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.but_dilute_calc:
                // it was the first button
                this.dilute_calc();
                break;
            case R.id.but_dilute_reset:
                // it was the second button
                this.dilute_reset();
                break;
        }
    }

    private void dilute_calc() {
        double v1 = 0, c1 = 0, v2 = 0, c2 = 0;
        String str_v1 = "", str_v2 = "", str_c1 = "", str_c2 = "";

        EditText fld_v1;
        EditText fld_c1;
        EditText fld_v2;
        EditText fld_c2;

        fld_v1 = (EditText) findViewById(R.id.NumberV1);
        fld_c1 = (EditText) findViewById(R.id.NumberC1);
        fld_v2 = (EditText) findViewById(R.id.NumberV2);
        fld_c2 = (EditText) findViewById(R.id.NumberC2);

        str_v1 = fld_v1.getText().toString();
        if (str_v1.equals("")) v1 = 0; else v1 = Double.parseDouble(str_v1);

        str_v2 = fld_v2.getText().toString();
        if (str_v2.equals("")) v2 = 0; else v2 = Double.parseDouble(str_v2);


        str_c1 = fld_c1.getText().toString();
        if (str_c1.equals("")) c1 = 0; else c1 = Double.parseDouble(str_c1);

        str_c2 = fld_c2.getText().toString();
        if (str_c2.equals("")) c2 = 0; else c2 = Double.parseDouble(str_c2);

        if (v1 > 0 && v2 > 0 && c2 > 0) c1 = v2 * c2 / v1;
        else if (v2 > 0 && c1 > 0 && c2 > 0) v1 = v2 * c2 / c1;
        else if (v1 > 0 && c1 > 0 && c2 > 0) v2 = v1 * c1 / c2;
        else if (v1 > 0 && c1 > 0 && v2 > 0) c2 = v1 * c1 / v2;
        else Toast.makeText(Dilute.this, "3 Dinge ausfüllen", Toast.LENGTH_SHORT).show();

        fld_v1.setText(String.valueOf(v1));
        fld_v2.setText(String.valueOf(v2));
        fld_c1.setText(String.valueOf(c1));
        fld_c2.setText(String.valueOf(c2));

    }
    private void dilute_reset() {

        EditText fld_v1;
        EditText fld_c1;
        EditText fld_v2;
        EditText fld_c2;

        fld_v1 = (EditText) findViewById(R.id.NumberV1);
        fld_c1 = (EditText) findViewById(R.id.NumberC1);
        fld_v2 = (EditText) findViewById(R.id.NumberV2);
        fld_c2 = (EditText) findViewById(R.id.NumberC2);


        fld_v1.setText("");
        fld_v2.setText("");
        fld_c1.setText("");
        fld_c2.setText("");

    }

}
