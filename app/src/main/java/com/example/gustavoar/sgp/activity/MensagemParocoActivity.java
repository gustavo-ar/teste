package com.example.gustavoar.sgp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gustavoar.sgp.R;
import com.example.gustavoar.sgp.adapter.MensagemAdapter;
import com.example.gustavoar.sgp.model.Mensagem;

import android.util.Log;


import com.example.gustavoar.sgp.util.HttpUtils;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MensagemParocoActivity extends Activity {

    private RecyclerView recyclerMensagem;
    private List<Mensagem> mensagems = new ArrayList<>();

//    FloatingActionButton fabAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            makeRequest();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_paroco);

    }

    public void prepararMensagens(JSONObject mensagemDoJSON) throws JSONException {

        String titulo = mensagemDoJSON.getString("titulo");
        String subtitulo = mensagemDoJSON.getString("subtitulo");
        String mensagem = mensagemDoJSON.getString("mensagem");

        Mensagem msg = new Mensagem(titulo, subtitulo,mensagem);
        mensagems.add(msg);
    }


    public void makeRequest() throws JSONException {
        HttpUtils.get("mensagensParoco", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("asd", "---------------- this is response : " + response);

                int len = response.length();

                for (int index = 0; index < len; index++) {
                    try {
                        prepararMensagens(response.getJSONObject(index));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setAdapter();
            }

        });
    }

    public void setAdapter(){
        for (Mensagem msg: mensagems) {
            Log.d("asd", msg.getTitulo());
        }
        recyclerMensagem = findViewById(R.id.recyclerMensagem);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerMensagem.setLayoutManager(layoutManager);


        MensagemAdapter adapter = new MensagemAdapter(mensagems);
        recyclerMensagem.setAdapter(adapter);

    }
}


