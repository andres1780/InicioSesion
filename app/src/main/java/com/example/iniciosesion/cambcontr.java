package com.example.iniciosesion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cambcontr extends AppCompatActivity {

    private Button cambiocontrbtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambcontr);
        cambiocontr_btnsend();

        cambiocontrbtn = (Button) findViewById(R.id.cambiocontrbtn);
    }

    private void cambiocontr_btnsend(){
        cambiocontrbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                alertaSend();
            }
        });
    }

    private void alertaSend(){
        new AlertDialog.Builder(this).setTitle("Confirmación").setMessage("Se ha cambiado la contraseña correctamente")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeContextMenu();
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        }).setCancelable(false).show();
    }

}