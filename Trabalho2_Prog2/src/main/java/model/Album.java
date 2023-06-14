/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.ReviewDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Album implements Comparable<Album> {

    private int idAlbum;
    private String titulo;
    private int anoLancamento;
    private Artista artista;
    private List<Faixa> faixas = new ArrayList();
    protected static Album albumCadastrando;
    protected static int geradorIdAlbum = 0;

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(Faixa faixas) {
        this.faixas.add(faixas);
    }

    public static Album getAlbumCadastrando() {
        return albumCadastrando;
    }

    public static void setAlbumCadastrando(Album albumCadastrando) {
        Album.albumCadastrando = albumCadastrando;
    }

    public static void setAlbumCadastrando() {

    }

    public static int getGeradorIdAlbum() {
        return geradorIdAlbum;
    }

    public static void setGeradorIdAlbum(int geradorIdAlbum) {
        Album.geradorIdAlbum = geradorIdAlbum;
    }

    public Album(String titulo, int anoLancamento, Artista artista) {
        this.idAlbum = ++geradorIdAlbum;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
    }

    public Album() {

    }

    /*    public boolean cadastrarFaixa(Album album, int duracao, int numero) {
        Faixa f = new Faixa(album, duracao, numero);
        if (f.equals(faixas.put(numero, f))) {
            // cadastra em banco de dados
            return true;
        } else {
            // cadastra em banco de dados
            return false;
        }
    }
     */
    public int calcularScore() {
        ReviewDAO daoReview = new ReviewDAO();
        List<Review> reviews = daoReview.getReviewsAlbum(idAlbum);

        if ((reviews == null) || (reviews.size() <= 0)) {
            return -1;
        }

        int score = 0;
        for (Review r : reviews) {
            score += r.getNota();
        }

        return (int) Math.round(score / reviews.size());
    }
    
    public int contarReviews() {
        ReviewDAO daoReview = new ReviewDAO();
        List<Review> reviews = daoReview.getReviewsAlbum(idAlbum);

        if ((reviews == null) || (reviews.size() <= 0)) {
            return -1;
        }
        
        return reviews.size();

    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Album{" + "idAlbum=" + idAlbum + ", titulo=" + titulo + ", anoLancamento=" + anoLancamento + ", artista=" + artista.getIdPessoa();
    }

    @Override   // Vai ordenar pelo ID - indica ordem de cadastro
    public int compareTo(Album a) {
        if (this.idAlbum > a.idAlbum) {
            return -1;
        }

        if (this.idAlbum > a.idAlbum) {
            return 1;
        }

        return 0;
    }

}
