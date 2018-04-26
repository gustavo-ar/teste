package com.example.gustavoar.sgp.activity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gustavoar.sgp.R;
import com.example.gustavoar.sgp.fragment.IncluirFragment;
import com.example.gustavoar.sgp.fragment.ListaMovimentacoesFragment;
import com.example.gustavoar.sgp.fragment.ResumoMovimentacoesFragment;
import com.example.gustavoar.sgp.fragment.RelatoriosFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class ControleFinanceiroActivityAdmin extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle_financeiro);

        viewPager = findViewById(R.id.viewPager);
        smartTabLayout = findViewById(R.id.viewPagerTab);

        //Aplica configurações na Action Bar
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("SGP");

        //Configurar abas
        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Resumo", ResumoMovimentacoesFragment.class)
                        .add("Lista",ListaMovimentacoesFragment.class)
                        .add("Incluir", IncluirFragment.class)
                        .add("Relatórios", RelatoriosFragment.class)
                        .create()
        );
        viewPager.setAdapter( adapter );
        smartTabLayout.setViewPager( viewPager );
    }
}
