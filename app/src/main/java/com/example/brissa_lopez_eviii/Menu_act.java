package com.example.brissa_lopez_eviii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Menu_act extends AppCompatActivity {
    private VideoView videoView;
    private String ruta;

    private Intent i;

    private Button gestion;
    private Button promociones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        videoView = (VideoView)findViewById(R.id.vv);
        gestion = (Button)findViewById(R.id.btn1);
        promociones = (Button)findViewById(R.id.btn2);

        ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);

        videoView.setVideoURI(uri);
        videoView.start();
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);

        gestion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                i = new Intent(getBaseContext(), Firebase_act.class);
                startActivity(i);
            }
        });

        promociones.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                i = new Intent(getBaseContext(), Promociones_act.class);
                startActivity(i);
            }
        });

    }
}