/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JFrame;
import model.Album;
import model.Artista;
import model.Faixa;
import model.Pessoa;
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

    public ControladorTelaListaFaixas(TelaListaFaixas telaListaFaixas, JFrame telaAnterior, Album alb) {
        this.telaListaFaixas = telaListaFaixas;
        this.telaAnterior = telaAnterior;
        this.alb = alb;

        verificarUsuario();
        carregarDetalhesAlbum();
        inicializarBotoes();
    }

    public void verificarUsuario() {
        if (Pessoa.getUsuarioLogado() instanceof Artista) {
            telaListaFaixas.getBotaoFazerReview().setVisible(false);
        }
    }

    public void carregarDetalhesAlbum() {
        int score = alb.calcularScore();
        int reviews = alb.contarReviews();

        telaListaFaixas.setNomeAlbum(alb.getTitulo());
        telaListaFaixas.setNomeArtista(alb.getArtista().getNome());
        telaListaFaixas.setFaixasArea(apresentarFaixas());
        telaListaFaixas.setScoreAlbum((score < 0 ? "SN" : Integer.toString(score)));
        telaListaFaixas.setValorAlbum((reviews < 0 ? "SN" : Integer.toString(reviews)));
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
        telaAnterior.setVisible(true);
    }

    public void acaoVerReviews() {
        ControladorTelaReviews controladorTelaReviews = new ControladorTelaReviews(new TelaReviews(), this.alb, telaListaFaixas);
        controladorTelaReviews.exibirTela();
        fecharTela();
    }

    public void acaoFazerReviews() {
        ControladorTelaCadastroReview controladorTelaCadastroReview = new ControladorTelaCadastroReview(new TelaCadastroReview(), alb, telaAnterior);
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
