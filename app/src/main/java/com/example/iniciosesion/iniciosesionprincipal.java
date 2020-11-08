package com.example.iniciosesion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class iniciosesionprincipal extends AppCompatActivity {

    //UI Views
    private TextView authStatusTv;
    private Button authBtn,btnopcion3;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosesionprincipal);
        configureopcion1();
        configureopcion2();
        configureopcion3();

        //init UI views
        authStatusTv = findViewById(R.id.authStatusTv);
        authBtn = findViewById(R.id.authBtn);

        //init Biometric
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(iniciosesionprincipal.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                authStatusTv.setText("Error de Autenticación: "+errString);
                Toast.makeText(iniciosesionprincipal.this, "Error de Autenticación: "+errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                authStatusTv.setText("Autenticación Exitosa");
                Toast.makeText(iniciosesionprincipal.this, "Autenticación Exitosa", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                authStatusTv.setText("Autenticación Fallida");
                Toast.makeText(iniciosesionprincipal.this, "Autenticación Fallida", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Autenticación Biometrica").setSubtitle("Login usando huella").setNegativeButtonText("Salir").build();

        authBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
            }
        });


    }

    private void configureopcion1()
    {
        Button btnopcion1 = (Button) findViewById(R.id.registrobtn);
        btnopcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(iniciosesionprincipal.this, registro.class));
            }
        });
    }

    private void configureopcion2()
    {
        Button btnopcion2 = (Button) findViewById(R.id.iniciobtn);
        btnopcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(iniciosesionprincipal.this, ingresacorreo.class));
            }
        });
    }

    private void configureopcion3()
    {
        btnopcion3 = (Button) findViewById(R.id.olvidecontr_btn);
        btnopcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(iniciosesionprincipal.this, cambcontr.class));
            }
        });
    }

    private void iniciofail_btnsend(){
        Button btnsend = (Button) findViewById(R.id.iniciobtn);
        btnsend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                alertaSend();
            }
        });
    }

    private void alertaSend(){
        new AlertDialog.Builder(this).setTitle("Notificación").setMessage("Los datos ingresados son incorrectos o usted no se encuentra registrado en nuestra plataforma.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(iniciosesionprincipal.this,iniciosesionprincipal.class));
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        }).setCancelable(false).show();
    }

}