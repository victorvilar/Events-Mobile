package com.example.victor.events;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Profile extends ActionBarActivity {

    ImageButton fotoBtn;
    DatePickerDialog dataDialog;
    SimpleDateFormat formatador;
    EditText dataText, telText;
    Button btnCadastrar;

    private static final int FOTO = 1;
    private static final int DESCRICAO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        formatador = new SimpleDateFormat("dd/MM/yyyy");
        dataText = (EditText)findViewById(R.id.editText2);
        telText = (EditText)findViewById(R.id.editText4);

        fotoBtn = (ImageButton) findViewById(R.id.fotoBtn);
        fotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, FOTO);
            }
        });

        Calendar novadata = Calendar.getInstance();
        dataDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                Calendar data = Calendar.getInstance();
                data.set(year, monthOfYear, dayOfMonth);
                dataText.setText(formatador.format(data.getTime()));
            }
        },novadata.get(Calendar.YEAR), novadata.get(Calendar.MONTH),novadata.get(Calendar.DAY_OF_MONTH));

        btnCadastrar = (Button)findViewById(R.id.button2);
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                confirmarDialog();
            }
        });

        dataText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus)
                    dataDialog.show();
            }
        });
        dataText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataDialog.show();
            }
        });
    }

    public void confirmarDialog() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Atençao");
        alerta.setMessage("Deseja realmente cadastrar?");
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                finish();
            }
        });
        alerta.setNegativeButton("Nao", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });
        alerta.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==FOTO){
            Bitmap foto = (Bitmap) data.getExtras().get("data");
            fotoBtn.setImageBitmap(foto);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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

    public void mostrarData(View view) {
        dataDialog.show();
    }

    public void Ligar(View view) {
        Intent ligar = new Intent(Intent.ACTION_CALL);
        ligar.setData(Uri.parse("tel:" + telText.getText().toString()));
        startActivity(ligar);
    }

    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}
