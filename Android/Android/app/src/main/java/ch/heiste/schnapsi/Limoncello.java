/*****************************************************************************************
 * Limoncello (Verdünnen)
 * ***************************************************************************************
 * Zweck: Rezeptumrechner für Limoncello
 *
 * Beschreibung:
 *
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

public class Limoncello extends AppCompatActivity implements View.OnClickListener {
    protected Button but_Limoncello_Calc;
    protected Button but_Limoncello_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limoncello);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Listener für die Buttons kreieren
        but_Limoncello_Calc = (Button)findViewById(R.id.but_limoncello_calc);
        but_Limoncello_Reset = (Button)findViewById(R.id.but_limoncello_reset);
        but_Limoncello_Calc.setOnClickListener((View.OnClickListener) this);
        but_Limoncello_Reset.setOnClickListener((View.OnClickListener) this);

        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.but_limoncello_calc:
                // it was the first button
                this.Limoncello_calc();
                break;
            case R.id.but_limoncello_reset:
                // it was the second button
                this.Limoncello_reset();
                break;
        }
    }

    private void Limoncello_calc() {
        double citrone = 0, wasser = 0, zucker = 0, alkohol = 0;
        String str_citrone = "", str_wasser = "", str_zucker = "", str_alkohol = "";

        EditText fld_citrone;
        EditText fld_zucker;
        EditText fld_wasser;
        EditText fld_alkohol;

        fld_citrone = (EditText) findViewById(R.id.zitrone);
        fld_zucker = (EditText) findViewById(R.id.zucker);
        fld_wasser = (EditText) findViewById(R.id.wasser);
        fld_alkohol = (EditText) findViewById(R.id.alkohol);

        str_citrone = fld_citrone.getText().toString();
        if (str_citrone.equals("")) citrone = 0; else citrone = Double.parseDouble(str_citrone);

        str_zucker = fld_zucker.getText().toString();
        if (str_zucker.equals("")) zucker = 0; else zucker = Double.parseDouble(str_zucker);


        str_wasser = fld_wasser.getText().toString();
        if (str_wasser.equals("")) wasser = 0; else wasser = Double.parseDouble(str_wasser);

        str_alkohol = fld_alkohol.getText().toString();
        if (str_alkohol.equals("")) alkohol = 0; else alkohol = Double.parseDouble(str_alkohol);

        if (alkohol>0){
            wasser=1.4*alkohol/1;
            zucker=0.8*alkohol/1;
            citrone=8*alkohol/1;
        }

        /*
        if (citrone > 0 && zucker > 0 && alkohol > 0) wasser = zucker * alkohol / citrone;
        else if (zucker > 0 && wasser > 0 && alkohol > 0) citrone = zucker * alkohol / wasser;
        else if (citrone > 0 && wasser > 0 && alkohol > 0) zucker = citrone * wasser / alkohol;
        else if (citrone > 0 && wasser > 0 && zucker > 0) alkohol = citrone * wasser / zucker;
        else Toast.makeText(Limoncello.this, "3 Dinge ausfüllen", Toast.LENGTH_SHORT).show();
*/
        fld_citrone.setText(String.valueOf(citrone));
        fld_zucker.setText(String.valueOf(zucker));
        fld_wasser.setText(String.valueOf(wasser));
        fld_alkohol.setText(String.valueOf(alkohol));

    }
    private void Limoncello_reset() {

        EditText fld_citrone;
        EditText fld_wasser;
        EditText fld_zucker;
        EditText fld_alkohol;

        fld_citrone = (EditText) findViewById(R.id.zitrone);
        fld_wasser = (EditText) findViewById(R.id.wasser);
        fld_zucker = (EditText) findViewById(R.id.zucker);
        fld_alkohol = (EditText) findViewById(R.id.alkohol);


        fld_citrone.setText("");
        fld_zucker.setText("");
        fld_wasser.setText("");
        fld_alkohol.setText("");

    }

}
