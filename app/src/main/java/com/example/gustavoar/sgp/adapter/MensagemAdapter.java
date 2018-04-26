package com.example.gustavoar.sgp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gustavoar.sgp.R;
import com.example.gustavoar.sgp.model.Mensagem;

import java.util.List;

/**
 * Created by gustavo.raphael on 3/13/2018.
 */

public class MensagemAdapter extends RecyclerView.Adapter<MensagemAdapter.MyViewHolder> {

    private List<Mensagem> mensagems;

    public MensagemAdapter(List<Mensagem> listaMensagens) {
        this.mensagems = listaMensagens;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mensagem_detalhe, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mensagem msg = mensagems.get(position);

        holder.titulo.setText(msg.getTitulo());
        holder.subtitulo.setText(msg.getSubtitulo());
        holder.mensagem.setText(msg.getMensagem());
    }

    @Override
    public int getItemCount() {
        return mensagems != null ? mensagems.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView subtitulo;
        private TextView mensagem;


        public MyViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tv_titulo);
            subtitulo = itemView.findViewById(R.id.tv_subtitulo);
            mensagem = itemView.findViewById(R.id.tv_mensagem);
        }
    }
}