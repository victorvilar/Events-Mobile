package com.example.victor.events;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainApp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_app, menu);
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

    public void goNewEvent(View view) {
        Intent a = new Intent(this,NovoEvento.class);
        startActivity(a);
    }

    public void goMyEvents(View view) {
        Intent a = new Intent(this,MeusEventos.class);
        startActivity(a);
    }

    public void goFeedbacks(View view) {
        Intent a = new Intent(this,Feedbacks.class);
        startActivity(a);
    }

    public void goDetalhes(View view) {
        Intent a = new Intent(this, DetalhesEvento.class);
        startActivity(a);
    }
}
