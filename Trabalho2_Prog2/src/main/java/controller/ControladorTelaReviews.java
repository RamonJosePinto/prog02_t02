/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ReviewDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import model.Album;
import model.Review;
import view.TelaReviews;

/**
 *
 * @author Usuario
 */
public class ControladorTelaReviews {

    private TelaReviews telaReviews;
    private Album alb;
    private JFrame janelaAnterior;
    List<Review> reviewsDoAlbumAtual = new ArrayList();

    public ControladorTelaReviews(TelaReviews telaReviews, Album alb, JFrame janelaAnterior) {
        this.telaReviews = telaReviews;
        this.alb = alb;
        this.janelaAnterior = janelaAnterior;

        carregarComboBoxOrdenacao();
        apresentarInformacoes();
        inicializarBotoes();
    }

    public void inicializarBotoes() {
        telaReviews.adicionarAcaoBotaoVoltar(acao -> {
            acaoVoltar();
        });
        telaReviews.adicionarAcaoComboBox(acao -> {
            acaoComboBox();
        });
    }

    public void carregarComboBoxOrdenacao() {
        telaReviews.addItemsComboBox("Mais novos");
        telaReviews.addItemsComboBox("Mais antigos");
        telaReviews.addItemsComboBox("Maior score");
        telaReviews.addItemsComboBox("Menor score");
    }

    public void apresentarInformacoes() {
        int score = alb.calcularScore();
        int reviews = alb.contarReviews();

        telaReviews.setNomeAlbum(alb.getTitulo());
        telaReviews.setNomeArtista(alb.getArtista().getNome());
        telaReviews.setScore((score < 0 ? "SN" : Integer.toString(score)));
        telaReviews.setReviewsValor((reviews < 0 ? "SN" : Integer.toString(reviews)));

        reviewsDoAlbumAtual = new ReviewDAO().getReviewsAlbum(this.alb.getIdAlbum());

        ordenarReviews();
        telaReviews.setTextArea(apresentarReviewAlbum(reviewsDoAlbumAtual));
    }

    public String apresentarReviewAlbum(List<Review> reviews) {
        if (reviews.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Review r : reviews) {
                sb.append(r.apresentarReview()).append("\n\n-------------//-------------\n\n");
            }
            return sb.toString();
        } else {
            return "Sem reviews cadastradas";
        }
    }

    private void ordenarReviews() {
        String item = telaReviews.getItemSelecionadoComboBox();

        switch (item) {
            case ("Mais novos"):
                Collections.sort(reviewsDoAlbumAtual, new Comparator<Review>() {
                    @Override
                    public int compare(Review r1, Review r2) {
                        if (r1.getIdReview() > r2.getIdReview()) {
                            return -1;
                        }

                        if (r1.getIdReview() < r2.getIdReview()) {
                            return 1;
                        }

                        return 0;
                    }
                });
                break;

            case ("Mais antigos"):
                Collections.sort(reviewsDoAlbumAtual, new Comparator<Review>() {
                    @Override
                    public int compare(Review r1, Review r2) {
                        if (r1.getIdReview() < r2.getIdReview()) {
                            return -1;
                        }

                        if (r1.getIdReview() > r2.getIdReview()) {
                            return 1;
                        }

                        return 0;
                    }
                });
                break;

            case ("Maior score"):
                Collections.sort(reviewsDoAlbumAtual, new Comparator<Review>() {
                    @Override
                    public int compare(Review r1, Review r2) {
                        if (r1.getNota() > r2.getNota()) {
                            return -1;
                        }

                        if (r1.getNota() < r2.getNota()) {
                            return 1;
                        }

                        return 0;
                    }
                });
                break;

            case ("Menor score"):
                Collections.sort(reviewsDoAlbumAtual, new Comparator<Review>() {
                    @Override
                    public int compare(Review r1, Review r2) {
                        if (r1.getNota() < r2.getNota()) {
                            return -1;
                        }

                        if (r1.getNota() > r2.getNota()) {
                            return 1;
                        }

                        return 0;
                    }
                });
                break;
        }
    }

    public void exibirTela() {
        telaReviews.exibirTela();
    }

    public void fecharTela() {
        telaReviews.fecharTela();
    }

    public void acaoVoltar() {
        fecharTela();
        ControladorJFrame controladorJFrame = new ControladorJFrame(janelaAnterior);
        controladorJFrame.ExibirTela();
    }

    public void acaoComboBox() {
        ordenarReviews();
        telaReviews.setTextArea(apresentarReviewAlbum(reviewsDoAlbumAtual));
    }

}
