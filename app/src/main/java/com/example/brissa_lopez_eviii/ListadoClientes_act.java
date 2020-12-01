package com.example.brissa_lopez_eviii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Clases.Clientes;

public class ListadoClientes_act extends AppCompatActivity {

    private ListView listado;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    private List<Clientes> listadoClientes = new ArrayList<Clientes>();

    private Button eliminar;

    private Clientes clientesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);
        iniciarFirebase();

        listado = (ListView)findViewById(R.id.lv);
        eliminar = (Button)findViewById(R.id.btn_eliminar);

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot :  snapshot.getChildren()){

                    Clientes cli = objSnapshot.getValue(Clientes.class);
                    listadoClientes.add(cli);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listadoClientes);
                    listado.setAdapter(adapt);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clientesSelected = (Clientes) parent.getItemAtPosition(position);
            }
        });



    }


    public void iniciarFirebase(){

        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void eliminar(View v){

        Clientes cli = new Clientes();
        cli.setId(clientesSelected.getId());
        databaseReference.child("Clientes").child(cli.getId()).removeValue();
        Toast.makeText(this, "Has eleiminado un cliente.", Toast.LENGTH_LONG).show();

    }
}