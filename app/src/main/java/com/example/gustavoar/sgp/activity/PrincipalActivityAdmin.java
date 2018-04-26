package com.example.gustavoar.sgp.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gustavoar.sgp.R;
import com.example.gustavoar.sgp.fragment.AdminFragment;
import com.google.firebase.auth.FirebaseAuth;

public class PrincipalActivityAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_admin);

        Toolbar toolbar = findViewById(R.id.toolbar_admin);
        toolbar.setTitle("SGP");
        setSupportActionBar(toolbar);

        //Carrega tela principal
        AdminFragment adminFragment = new AdminFragment();
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.frameContainer_admin, adminFragment);
        fragment.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view_admin);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PrincipalActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSair:
                autenticacao.signOut();
                abrirTelaPrincipal();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_visao_geral) {

            startActivity( new Intent(this, AdminFragment.class ) );

        } else if (id == R.id.nav_controle_financeiro) {

            startActivity( new Intent(this, FinanceiroActivity.class ) );

        } else if (id == R.id.nav_eventos) {

            startActivity( new Intent(this, EventosActivityAdmin.class ) );

        } else if (id == R.id.nav_mensagens_paroco) {

            //startActivity( new Intent(this, MensagemParocoActivity.class ) );

        } else if (id == R.id.nav_banners_site) {


        } else if (id == R.id.nav_membros) {


        } else if (id == R.id.nav_pastorais) {


        } else if (id == R.id.nav_comunidades){


        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}