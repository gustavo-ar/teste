package com.example.gustavoar.sgp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gustavoar.sgp.R;

public class ResumoMovimentacoesFragment extends Fragment {

    public ResumoMovimentacoesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resumo_movimentacoes, container, false);
    }
}
