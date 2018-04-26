package com.example.gustavoar.sgp.model;

import java.io.Serializable;

/**
 * Created by gustavo.raphael on 3/13/2018.
 */

public class Mensagem implements Serializable{

    private String titulo;
    private String subtitulo;
    private String mensagem;

    public Mensagem() {
    }

    public Mensagem(String titulo, String subtitulo, String mensagem) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
