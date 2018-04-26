package com.example.gustavoar.sgp.possiveldedeletar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.example.gustavoar.sgp.R;
import com.example.gustavoar.sgp.activity.EventosActivityAdmin;
import com.example.gustavoar.sgp.config.ConfiguracaoFirebase;
import com.example.gustavoar.sgp.fragment.AdminFragment;
import com.example.gustavoar.sgp.helper.Base64Custom;
import com.example.gustavoar.sgp.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class PrincipalActivityAdmin3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

//    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
//    private DatabaseReference firebaseRef = ConfiguracaoFirebase.getFirebaseDatabase();
//    private DatabaseReference usuarioRef;
//    private ValueEventListener valueEventListenerUsuario;

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
                this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view_admin);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
       // recuperarResumo();
    }

//    public void recuperarResumo() {
//
//        String emailUsuario = autenticacao.getCurrentUser().getEmail();
//        String idUsuario = Base64Custom.codificarBase64(emailUsuario);
//        usuarioRef = firebaseRef.child("usuarios").child(idUsuario);
//
//        valueEventListenerUsuario = usuarioRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Usuario usuario = dataSnapshot.getValue(Usuario.class);
////
////                despesaTotal = usuario.getDespesaTotal();
////                receitaTotal = usuario.getReceitaTotal();
////                resumoUsuario = receitaTotal - despesaTotal;
////
////                DecimalFormat decimalFormat = new DecimalFormat("0.##");
////                String resultadoFormatado = decimalFormat.format( resumoUsuario );
////
////                textoSaudacao.setText("Olá, " + usuario.getNome() );
////                textoSaldo.setText( "R$ " + resultadoFormatado );
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSair:
//                autenticacao.signOut();
//                startActivity(new Intent(this, MainActivity3.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
       //usuarioRef.removeEventListener(valueEventListenerUsuario);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_visao_geral) {


        } else if (id == R.id.nav_controle_financeiro) {


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
}
