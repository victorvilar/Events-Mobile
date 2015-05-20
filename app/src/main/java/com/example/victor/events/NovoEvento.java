package com.example.victor.events;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;


public class NovoEvento extends ActionBarActivity {

    DatePickerDialog dataDialog;
    SimpleDateFormat dataFormato;
    TimePickerDialog horaDialog;
    EditText nomeEvento, data, hora, local, tema, descricao;
    int t_hora, t_minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_evento);

        dataFormato = new SimpleDateFormat("dd/MM/yyyy");
        data = (EditText)findViewById(R.id.etData);
        hora = (EditText)findViewById(R.id.etHora);

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

        //Para fazer o dialog da hora
        Calendar horario = Calendar.getInstance();
        horaDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar horario2 = Calendar.getInstance();
                horario2.set(Calendar.HOUR_OF_DAY, hourOfDay);
                horario2.set(Calendar.MINUTE, minute);
                hora.setText(""+hourOfDay+":"+minute);
            }
        },calendario.get(Calendar.HOUR_OF_DAY), calendario.get(Calendar.MINUTE), true);

        hora.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus)
                    horaDialog.show();
            }
        });
        hora.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                horaDialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_novo_evento, menu);
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

    public void goMainApp(View view) {
        Intent a = new Intent(this, MainApp.class);
        startActivity(a);
        finish();
    }

    public void openCalendar(View view) {
        dataDialog.show();
    }

    public void goMap(View view) {
        Intent a = new Intent(this, goMaps.class);
        startActivity(a);
    }

    public void goConvidar(View view) {
        Intent a = new Intent(this, ConvidarAmigos.class);
        startActivity(a);
    }


    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}
