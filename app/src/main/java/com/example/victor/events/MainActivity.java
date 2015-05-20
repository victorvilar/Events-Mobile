package com.example.victor.events;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Button goLoginApp, goCadastro;
    private int MENU_ABOUT = 1;
    private int MENU_TELLAFRIEND = 2;
    private int MENU_PROFILE = 3;
    private int MENU_BUTTONSETTINGS = 4;
    private int MENU_HELP = 5;
    private int MENU_BUSCAEVENTO = 6;
    final CharSequence[] items = {" Direita ", " Esquerda "};
    long sss = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goLoginApp = (Button) findViewById(R.id.BtnLogin);
        goCadastro = (Button) findViewById(R.id.BtnCadastrar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(Menu.NONE, MENU_BUSCAEVENTO, Menu.NONE, "Buscar Evento");
        menu.add(Menu.NONE, MENU_ABOUT, Menu.NONE, "Sobre");
        //.setIcon(R.drawable.ic_menu_add);
        menu.add(Menu.NONE, MENU_TELLAFRIEND, Menu.NONE, "Convide um amigo");
        //.setIcon(R.drawable.ic_menu_refresh);
        menu.add(Menu.NONE, MENU_PROFILE, Menu.NONE, "Profile");
        menu.add(Menu.NONE, MENU_BUTTONSETTINGS, Menu.NONE, "Configuração do Botão");
        menu.add(Menu.NONE, MENU_HELP, Menu.NONE, "Ajuda");


        return (super.onCreateOptionsMenu(menu));
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        switch (item.getItemId()) {
            case 1:
                goAbout();
                return true;
            case 2:
                goConvideAmigo();
                return true;
            case 3:
                goProfile();
                return true;
            case 4:
                goConfigButton();
                return true;
            case 5:
                goHelp();
                return true;
            case 6:
                goBuscaEvento();
            default:
                return super.onOptionsItemSelected(item);
        }

        //return super.onOptionsItemSelected(item);
    }

    private void goBuscaEvento() {
        Intent a = new Intent(this, BuscaEvento.class);
        startActivity(a);
    }


    private void goHelp() {
        AlertDialog alertaHelp = new AlertDialog.Builder(this).create();
        alertaHelp.setTitle("Ajuda");
        alertaHelp.setMessage("Incitação ao ódio: não permitimos conteúdo contra grupos de pessoas com base em raça ou origem étnica, religião, deficiência, sexo, idade, condição de veterano ou orientação");
        alertaHelp.setButton("Entendi!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertaHelp.show();
    }

    private void goConfigButton() {
        AlertDialog levelDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione a posição dos botões");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {


                switch (item) {
                    case 0:
                        // Your code when first option seletced
                        break;
                    case 1:
                        // Your code when 2nd  option seletced

                        break;
                    case 2:
                        // Your code when 3rd option seletced
                        break;
                    case 3:
                        // Your code when 4th  option seletced
                        break;

                }
            }
        });
        levelDialog = builder.create();
        levelDialog.show();
    }

    private void goProfile() {
        Intent a = new Intent(this, Profile.class);
        startActivity(a);
    }

    private void goConvideAmigo() {
        Intent a = new Intent(this, ConvideAmigo.class);
        startActivity(a);
    }

    private void goAbout() {
        AlertDialog alertaAbout = new AlertDialog.Builder(this).create();
        alertaAbout.setTitle("Sobre");
        alertaAbout.setMessage("Incitação ao ódio: não permitimos conteúdo contra grupos de pessoas com base em raça ou origem étnica, religião, deficiência, sexo, idade, condição de veterano ou orientação");
        alertaAbout.setButton("Entendi!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertaAbout.show();
    }

    public void goLoginApp(View view) {
        Intent a = new Intent(this, Login.class);
        startActivity(a);
    }

    public void goCadastro(View view) {
        Intent a = new Intent(this, Cadastro.class);
        startActivity(a);
    }

    public void tryit() {
        ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);

        Intent a = new Intent(this, MainApp.class);
        startActivity(a);
    }
}
