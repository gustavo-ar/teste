package com.example.gustavoar.sgp.possiveldedeletar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gustavoar.sgp.R;
import com.example.gustavoar.sgp.activity.PrincipalActivityAdmin;

public class LoginActivity2 extends AppCompatActivity {

    private Context context;

    private EditText et_email;
    private EditText et_senha;
    private Button btn_cancelar;
    private Button btn_login;
    private String msgErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        inicializarVariavel();
        inicializarAcao();
    }

    private void inicializarVariavel() {
        context = getBaseContext();

        et_email = findViewById(R.id.et_email);
        et_senha = findViewById(R.id.et_senha);
        btn_cancelar = findViewById(R.id.btn_cancelar);
        btn_login = findViewById(R.id.btn_login);
    }

    private void inicializarAcao() {
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCtrls();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()) {
                    exibirLogin();
                    abrirTelaPrincipalAdmin();
                } else {
                    exibirErro();
                }
            }
        });
    }

    private void limparCtrls() {
        et_email.setText("");
        et_senha.setText("");

        et_email.requestFocus();

    }

    private boolean validacao() {
        String nome = et_email.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();

        if (nome.length() == 0) {
            msgErro = getString(R.string.mensagem_erro_nome);

            return false;
        }

        if (senha.length() == 0) {
            msgErro = getString(R.string.mensagem_erro_senha);

            return false;
        }

        if ((!nome.equalsIgnoreCase("paroquiasle@gmail.com"))
                ||
                (
                        !senha.equals("batata"))
                ) {

            msgErro = getString(R.string.mensagem_erro_credenciais);

            return false;
        }
        return true;
    }

    private void exibirLogin() {
        StringBuilder sb = new StringBuilder();

        sb.append(getString(R.string.mensagem_saudacao))
                .append(et_email.getText().toString().trim());

        exibirMensagem(sb.toString());
    }

    private void exibirErro() {
        exibirMensagem(msgErro);
    }

    private void exibirMensagem(String mensagem) {
        Toast.makeText(
                context,
                mensagem,
                Toast.LENGTH_SHORT
        ).show();
    }

    public void abrirTelaPrincipalAdmin() {
        startActivity(new Intent(this, PrincipalActivityAdmin.class));
    }
}

