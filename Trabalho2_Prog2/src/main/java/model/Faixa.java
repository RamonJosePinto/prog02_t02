/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Faixa {
    
    private int idFaixa;
    private String nome;
    private Album album;
    private int duracao;
    private int numero;
    public static List<Faixa> faixaCadastrando = new ArrayList<>();
    protected static int geradorIdFaixa = 0;

    public Faixa(String nome, Album album, int duracao, int numero) {
        this.idFaixa = ++geradorIdFaixa;
        this.nome = nome;
        this.album = album;
        this.duracao = duracao;
        this.numero = numero;
    }

    public int getIdFaixa() {
        return idFaixa;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Faixa{" + "idFaixa=" + idFaixa + ", nome=" + nome + ", album=" + album + ", duracao=" + duracao + ", numero=" + numero + '}';
    }
    
    public String apresentarFaixas(){
        return numero+"ª Faixa - "+nome+" / "+duracao+"min";
    }
    
    
}
