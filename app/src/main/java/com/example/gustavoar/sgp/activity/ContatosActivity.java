package com.example.gustavoar.sgp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.gustavoar.sgp.R;
import com.github.clans.fab.FloatingActionButton;

public class ContatosActivity extends AppCompatActivity {

    private Context context;
    private ImageView iv_telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();
        iv_telefone = findViewById(R.id.imageView3);
    }

    private void inicializarAcao() {

        iv_telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_CALL);
                mIntent.setData(Uri.parse("tel:" + "58416555"));

                startActivity(mIntent);
            }
        });
    }
}