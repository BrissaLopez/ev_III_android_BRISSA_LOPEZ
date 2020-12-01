package com.example.brissa_lopez_eviii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.Clientes;
import Clases.Promocion;

public class Promociones_act extends AppCompatActivity {
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    private Spinner listado;
    private ArrayList<String> listadoClientes = new ArrayList<String>();
    private EditText promo;
    private EditText envio;
    private TextView tvInfo;
    private TextView tvPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);
        anadeCliente();

        listado = (Spinner)findViewById(R.id.spinner);
        promo = (EditText)findViewById(R.id.et_promo1);
        envio = (EditText)findViewById(R.id.et_promo2);
        tvInfo = (TextView)findViewById(R.id.tv1);
        tvPrecio =(TextView)findViewById(R.id.tv2);

        ArrayAdapter<String> adaptaCliente = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listadoClientes);
        listado.setAdapter(adaptaCliente);


    }


    public void calcularPromocion(View v){
        String promoString = promo.getText().toString();
        int envioInt = Integer.parseInt(envio.getText().toString());
        Promocion p = new Promocion();
        p.verificaPromo(promoString);


        int resultado = p.getPrecio() + envioInt;

        tvInfo.setText("Estimado "+ listado.getSelectedItem().toString()+", el valor final según promoción y envío es: ");
        tvPrecio.setText("$"+resultado);
    }

    public void iniciarFirebase(){

        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void anadeCliente(){
        listadoClientes.add("Ramiro");
        listadoClientes.add("Rosa");
        listadoClientes.add("Robert");
    }
}