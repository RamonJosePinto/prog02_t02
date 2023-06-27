/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ReviewDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Album;
import model.Artista;
import model.Faixa;
import model.Pessoa;
import model.table.FaixasTableModel;
import model.table.ReviewTableModel;
import util.ManipularImagem;
import view.TelaCadastroReview;
import view.TelaListaFaixas;
import view.TelaReviews;

/**
 *
 * @author Usuario
 */
public class ControladorTelaListaFaixas {

    private JFrame telaAnterior;
    private TelaListaFaixas telaListaFaixas;
    private static Album alb;
    private FaixasTableModel faixasTableModel;

    public ControladorTelaListaFaixas(TelaListaFaixas telaListaFaixas, JFrame telaAnterior, Album alb, FaixasTableModel faixasTableModel) {
        this.telaListaFaixas = telaListaFaixas;
        this.telaAnterior = telaAnterior;
        this.alb = alb;
        this.faixasTableModel = faixasTableModel;

        verificarUsuario();
        carregarDetalhesAlbum();
        inicializarBotoes();
        setTableModel();
    }

    public void verificarUsuario() {
        if (Pessoa.getUsuarioLogado() instanceof Artista) {
            telaListaFaixas.getBotaoFazerReview().setVisible(false);
        }
    }

    public void setTableModel() {
        telaListaFaixas.setTableModel(this.faixasTableModel);
    }

    public void carregarDetalhesAlbum() {
        int score = alb.calcularScore();
        int reviews = alb.contarReviews();

        telaListaFaixas.setNomeAlbum(alb.getTitulo());
        telaListaFaixas.setNomeArtista(alb.getArtista().getNome());
//        telaListaFaixas.setFaixasArea(apresentarFaixas());
        telaListaFaixas.setScoreAlbum((score < 0 ? "SN" : Integer.toString(score)));
        telaListaFaixas.setValorAlbum((reviews < 0 ? "SN" : Integer.toString(reviews)));
        
        try {
            telaListaFaixas.atualizarCapa(ManipularImagem.buscarImagem(alb.getCaminhoImagemCapa()));
        } catch (NullPointerException | IOException ex) {
        }
    }

    public String apresentarFaixas() {
        List<Faixa> faixas = alb.getFaixas();
        if (faixas.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Faixa faixa : faixas) {
                sb.append(faixa.apresentarFaixas()).append("\n");
            }
            return sb.toString();
        } else {
            return "Sem faixas cadastradas";
        }
    }

    public void inicializarBotoes() {
        telaListaFaixas.adicionarAcaoBotaoVoltar(acao -> {
            acaoVoltar();
        });
        telaListaFaixas.adicionarAcaoBotaoVerReviews(acao -> {
            acaoVerReviews();
        });
        telaListaFaixas.adicionarAcaoBotaoFazerReviews(acao -> {
            acaoFazerReviews();
        });
    }

    public void acaoVoltar() {
        fecharTela();
        ControladorJFrame controladorJFrame = new ControladorJFrame(telaAnterior);
        controladorJFrame.ExibirTela();
    }

    public void acaoVerReviews() {
        ControladorTelaReviews controladorTelaReviews = new ControladorTelaReviews(new TelaReviews(), this.alb, telaListaFaixas, new ReviewTableModel(new ReviewDAO().getReviewsAlbum(this.alb.getIdAlbum())));
        controladorTelaReviews.exibirTela();
        fecharTela();
    }

    public void acaoFazerReviews() {
        ControladorCadastrarReview controladorTelaCadastroReview = new ControladorCadastrarReview(new TelaCadastroReview(), alb, telaListaFaixas);
        controladorTelaCadastroReview.exibirTela();
        fecharTela();
    }

    public void exibirTela() {
        telaListaFaixas.exibirTela();
    }

    public void fecharTela() {
        telaListaFaixas.fecharTela();
    }

}
