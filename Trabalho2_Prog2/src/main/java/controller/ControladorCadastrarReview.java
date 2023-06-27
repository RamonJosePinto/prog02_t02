/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ReviewDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Album;
import model.Pessoa;
import model.Review;
import model.Reviewer;
import view.TelaCadastroReview;

/**
 *
 * @author Usuario
 */
public class ControladorCadastrarReview {

    private TelaCadastroReview telaCadastroReview;
    private Album alb;
    private JFrame janelaAnterior;

    public ControladorCadastrarReview(TelaCadastroReview telaCadastroReview, Album alb, JFrame janelaAnterior) {
        this.telaCadastroReview = telaCadastroReview;
        this.alb = alb;
        this.janelaAnterior = janelaAnterior;

        telaCadastroReview.setNomeAlbum(alb.getTitulo());
        inicializarBotoes();
    }

    public void inicializarBotoes() {
        telaCadastroReview.adicionarAcaoBotaoEnviar(acao -> {
            acaoEnviar();
        });
        telaCadastroReview.adicionarAcaoBotaoVoltar(acao -> {
            acaoVoltar();
        });
    }

    public void acaoEnviar() {
        int nota = telaCadastroReview.getNota();
        System.out.println(nota);
        String descricao = telaCadastroReview.getDescricao();
        if (nota < 0 || descricao.isEmpty()) {
            telaCadastroReview.exibirMensagem("Por favor, informe uma descrição para a review e utilize apenas notas positivas");
        } else {
            ReviewDAO daoReview = new ReviewDAO();
            // gravar review
            Review review = new Review((Reviewer) Pessoa.getUsuarioLogado(), alb, nota, descricao);
            ReviewDAO reviewDao = new ReviewDAO();
            reviewDao.salvarReview(review);
            // apresnetar joptionpane
            telaCadastroReview.exibirMensagem("Review Cadastrada com sucesso");
            ControladorJFrame controladorJFrame = new ControladorJFrame(janelaAnterior);
            controladorJFrame.ExibirTela();
            fecharTela();
        }
    }

    public void acaoVoltar() {
        ControladorJFrame controladorJFrame = new ControladorJFrame(janelaAnterior);
        controladorJFrame.ExibirTela();
        fecharTela();

    }

    public void fecharTela() {
        telaCadastroReview.fecharTela();
    }

    public void exibirTela() {
        telaCadastroReview.exibirTela();
    }

}
