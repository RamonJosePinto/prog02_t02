/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author guilh
 */
public class Review {
    
    private int idReview;
    private Reviewer reviewer;
    private Album album;
    private int nota;
    private String descricao;
    protected static int geradorIdReview = 0;

    public Review(Reviewer reviewer, Album album, int nota, String descricao) {
        this.idReview = ++geradorIdReview;
        this.reviewer = reviewer;
        this.album = album;
        this.nota = nota;
        this.descricao = descricao;
    }
    
    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Review{" + "idReview=" + idReview + ", reviewer=" + reviewer.getIdPessoa() + ", album=" + album.getIdAlbum() + ", nota=" + nota + ", descricao=" + descricao + '}';
    }
    
    public String apresentarReview(){
        return "Nome do Reviewer: " + reviewer.getNome() + "\n"
       + "Nota: " + nota + "\n"
       + "Descrição: " + descricao;     
    }
}
