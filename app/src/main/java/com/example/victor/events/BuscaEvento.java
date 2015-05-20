package com.example.victor.events;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BuscaEvento extends ActionBarActivity {

    DatePickerDialog dataDialog, dataDialog2;
    SimpleDateFormat dataFormato;
    EditText nomeEvento, data, dataF, local, tema, descricao;
    int t_hora, t_minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_evento);

        dataFormato = new SimpleDateFormat("dd/MM/yyyy");
        data = (EditText)findViewById(R.id.etData);
        dataF = (EditText)findViewById(R.id.etDataF);

        //Para fazer o dialog do calendario
        Calendar calendario = Calendar.getInstance();
        dataDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar data2 = Calendar.getInstance();
                data2.set(year, monthOfYear, dayOfMonth);
                data.setText(dataFormato.format(data2.getTime()));
            }
        },calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH));

        data.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus)
                    dataDialog.show();
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataDialog.show();
            }
        });

        //Para fazer o dialog do calendario2
        Calendar calendario2 = Calendar.getInstance();
        dataDialog2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar data2 = Calendar.getInstance();
                data2.set(year, monthOfYear, dayOfMonth);
                dataF.setText(dataFormato.format(data2.getTime()));
            }
        },calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH));

        dataF.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus)
                    dataDialog2.show();
            }
        });
        dataF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataDialog2.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_busca_evento, menu);
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

    public void goMap(View view) {
        Intent a = new Intent(this, goMaps.class);
        startActivity(a);
    }

    public void goMainApp(View view) {
        Intent a = new Intent(this, MainApp.class);
        startActivity(a);
        finish();
    }
}
