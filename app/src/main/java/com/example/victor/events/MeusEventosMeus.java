package com.example.victor.events;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MeusEventosMeus extends ActionBarActivity {
    Button invited, mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_eventos_meus);
        invited = (Button)findViewById(R.id.btnConvidado);
        mine = (Button)findViewById(R.id.btnMeus);
        mine.setPressed(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meus_eventos_meus, menu);
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

    public void goDetalhes(View view) {
        Intent a = new Intent(this, DetalhesEvento.class);
        startActivity(a);
    }

    public void goME(View view) {
        Intent a = new Intent(this, MeusEventos.class);
        startActivity(a);
    }

    public void setclicked(View view) {
        mine.setPressed(true);
    }
}
