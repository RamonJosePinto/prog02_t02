/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionListener;
import model.Album;
import model.Faixa;
import view.TelaCadastroAlbumFaixas;

/**
 *
 * @author Usuario
 */
public class ControladorCadastrarAlbumFaixas {

    private TelaCadastroAlbumFaixas telaCadastroAlbumFaixas;
    private Album alb;
    private int contNumero = 1;

    public ControladorCadastrarAlbumFaixas(TelaCadastroAlbumFaixas telaCadastroAlbumFaixas, Album alb) {
        this.telaCadastroAlbumFaixas = telaCadastroAlbumFaixas;
        this.alb = alb;

        inicializarBotoes();
    }

    public void exibirTela() {
        telaCadastroAlbumFaixas.exibirTela();
    }

    public void fecharTela() {
        telaCadastroAlbumFaixas.fecharTela();
    }

    public void inicializarBotoes() {
        telaCadastroAlbumFaixas.adicioanarAcaoBotaoCadastrar(acao -> {
            acaoCadastrar();
        });
        telaCadastroAlbumFaixas.adicioanarAcaoBotaoVoltar(acao -> {
            acaoVoltar();
        });
    }

    public void acaoCadastrar() {
        if (telaCadastroAlbumFaixas.getNomeFaixa().isEmpty() || telaCadastroAlbumFaixas.getDuracaoFaixa().isEmpty()) {
            telaCadastroAlbumFaixas.exibirMensagem("Informe o nome e duração da faixa para cadastra-la");
        } else {
            String nome = telaCadastroAlbumFaixas.getNomeFaixa();
            int duracao = Integer.parseInt(telaCadastroAlbumFaixas.getDuracaoFaixa());
            Faixa f = new Faixa(nome, alb, duracao, contNumero);
            contNumero++;
            alb.getFaixas().add(f);
            Faixa.faixaCadastrando.add(f);
            telaCadastroAlbumFaixas.exibirMensagem("Faixa cadastrada com sucesso");
            int opcao = telaCadastroAlbumFaixas.exibirMensagemConfirmacao("Você deseja cadastrar outra faixa?", "Confirmação");
            if (telaCadastroAlbumFaixas.opcaoSelecionada(opcao)) {
                telaCadastroAlbumFaixas.setNomeFaixa("");
                telaCadastroAlbumFaixas.setDuracaoFaixa("");

            } else {
                fecharTela();
            }

        }
    }

    public void acaoVoltar() {
        fecharTela();
    }

}
