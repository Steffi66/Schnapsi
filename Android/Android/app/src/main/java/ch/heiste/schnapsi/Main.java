package ch.heiste.schnapsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    protected ImageButton but_Dilute;
    protected ImageButton but_Limoncello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Listener für die Buttons kreieren
        but_Dilute = (ImageButton)findViewById(R.id.but_dilute);
        but_Dilute.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {
                                                      Intent myIntent;
                                                      myIntent = new Intent(Main.this, Dilute.class);
                                                      Main.this.startActivity(myIntent);
                                                  }
                                              });

        but_Limoncello = (ImageButton)findViewById(R.id.but_limoncello);
        but_Limoncello.setOnClickListener(new
                                              View.OnClickListener(){
                                                  @Override
                                                  public void onClick(View v){
                                                      Intent myIntent;
                                                      myIntent = new Intent(Main.this, Limoncello.class);
                                                      Main.this.startActivity(myIntent);
                                                  }
                                              });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
