package com.example.gustavoar.sgp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gustavoar.sgp.R;

public class EventosActivityAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_admin);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_eventos_admin);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarEvento();
            }
        });
    }

    public void criarEvento(){
        startActivity(new Intent(this, NovoEventoActivityAdmin.class));
    }
}
