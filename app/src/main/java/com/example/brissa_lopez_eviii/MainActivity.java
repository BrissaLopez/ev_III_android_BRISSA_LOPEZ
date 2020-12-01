package com.example.brissa_lopez_eviii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText contrasena;
    private Button loguear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.et_login1);
        contrasena = (EditText)findViewById(R.id.et_login2);
        loguear = (Button)findViewById(R.id.btn_login);


        loguear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                loguearse(nombre, contrasena);
            }
        });
    }

    public void loguearse(EditText nombre, EditText contrasena){

        String nombreString = nombre.getText().toString();
        String contrasenaString = contrasena.getText().toString();

        if("android".equalsIgnoreCase(nombreString) && "123".equalsIgnoreCase(contrasenaString)){

            Toast.makeText(this, "Bienvenido a Pizza's!",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i);

        }else{
            Toast.makeText(this, "Usuario o clave incorrecta. Intente nuevamente",Toast.LENGTH_LONG).show();
        }



    }
}