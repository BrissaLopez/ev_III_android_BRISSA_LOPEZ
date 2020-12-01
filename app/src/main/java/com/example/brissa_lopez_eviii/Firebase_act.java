package com.example.brissa_lopez_eviii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Clases.Clientes;

public class Firebase_act extends AppCompatActivity {

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    private EditText nombre;
    private EditText destino;
    private EditText promocion;
    private Button guardarCliente;
    private Button listadoClientes;
    ContentValues registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        nombre = (EditText)findViewById(R.id.et_fire1);
        destino = (EditText)findViewById(R.id.et_fire2);
        promocion = (EditText)findViewById(R.id.et_fire3);
        guardarCliente = (Button)findViewById(R.id.btn_fire1);
        listadoClientes = (Button)findViewById(R.id.btn_fire2);

        iniciarFirebase();


        guardarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nombre.equals("")){
                    //guarda en firebase
                    Clientes cli = new Clientes();
                    cli.setId(UUID.randomUUID().toString());
                    cli.setNombre(nombre.getText().toString());
                    cli.setDestino(destino.getText().toString());
                    cli.setPromocion(promocion.getText().toString());

                    databaseReference.child("Clientes").child(cli.getId()).setValue(cli);
                    registro.put("nombre", nombre.getText().toString());

                    Toast.makeText(getBaseContext(),"Se ha guardado!", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getBaseContext(),"No se ha guardado...", Toast.LENGTH_LONG).show();
                }


            }
        });

        listadoClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),ListadoClientes_act.class);
                startActivity(i);
            }
        });
    }


    public void iniciarFirebase(){

        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}