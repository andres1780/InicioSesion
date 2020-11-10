package com.example.iniciosesion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        configureopcion1();
        regist_btnsend();
        laFotico();
    }

    private void configureopcion1()
    {
        Button btnopcion1 = (Button) findViewById(R.id.registrobtn);
        btnopcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registro.this, iniciosesionprincipal.class));
            }
        });
    }

    private void laFotico(){
        Button laFotico = (Button) findViewById(R.id.btnTomarFoto);
        laFotico.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(registro.this, actividad_Camara.class));
            }
        });
    }

    private void regist_btnsend(){
        Button btnsend = (Button) findViewById(R.id.registrobtn);
        btnsend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                alertaSend();
            }
        });
    }

    private void alertaSend(){
        new AlertDialog.Builder(this).setTitle("Notificación").setMessage("Se envió un código a su correo, por favor verifique e ingréselo a la aplicación ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(registro.this,registro.class));
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        }).setCancelable(false).show();
    }

}