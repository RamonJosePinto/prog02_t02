/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FaixaDAO;
import exception.CampoVazioCadastroFaixaException;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Album;
import model.Faixa;
import model.table.FaixasTableModel;
import view.TelaCadastroAlbum;
import view.TelaCadastroAlbumFaixas;

/**
 *
 * @author Usuario
 */
public class ControladorCadastrarAlbumFaixas {

    private TelaCadastroAlbumFaixas telaCadastroAlbumFaixas;
    private Album album;
    private int contNumero = 1;

    public ControladorCadastrarAlbumFaixas(TelaCadastroAlbumFaixas telaCadastroAlbumFaixas, Album album) {
        this.telaCadastroAlbumFaixas = telaCadastroAlbumFaixas;
        this.album = album;
        System.out.println(album.toString());
        inicializarBotoes();
    }

    public void exibirTela() {
        telaCadastroAlbumFaixas.exibirTela();
    }

    public void fecharTela() {
        telaCadastroAlbumFaixas.fecharTela();
    }

    public void inicializarBotoes() {
        telaCadastroAlbumFaixas.adicioanarAcaoBotaoCadastrar(acao -> acaoCadastrar());
        telaCadastroAlbumFaixas.adicioanarAcaoBotaoVoltar(acao -> acaoVoltar());
    }

    public void acaoCadastrar() {
        try {
            String nome = telaCadastroAlbumFaixas.getNomeFaixa();
            int duracao = Integer.parseInt(telaCadastroAlbumFaixas.getDuracaoFaixa());
            Faixa f = new Faixa(nome, album, duracao, contNumero);
            album.getFaixas().add(f);
            FaixaDAO faixaDAO = new FaixaDAO();
            faixaDAO.salvarFaixa(f);
            contNumero++;
            
            telaCadastroAlbumFaixas.exibirMensagem("Faixa cadastrada com sucesso.");
            int opcao = telaCadastroAlbumFaixas.exibirMensagemConfirmacao("Você deseja cadastrar outra faixa?", "Cadastro de faixas");
            
            if (telaCadastroAlbumFaixas.opcaoSelecionada(opcao)) {
                telaCadastroAlbumFaixas.setNomeFaixa("");
                telaCadastroAlbumFaixas.setDuracaoFaixa("");
            } else {
                fecharTela();
                ControladorCadastrarAlbum controladorCadastroAlbum = new ControladorCadastrarAlbum(new TelaCadastroAlbum(), new FaixasTableModel(this.album.getFaixas()), this.album);
                controladorCadastroAlbum.preencherInformacaoAposCadastroFaixa();
                controladorCadastroAlbum.exibirTela();
            }
        } catch (NumberFormatException ex) {
            telaCadastroAlbumFaixas.exibirMensagem("Por favor informe valores válidos para o campo duração da faixa");
        } catch (CampoVazioCadastroFaixaException ex) {
            telaCadastroAlbumFaixas.exibirMensagem(ex.getMessage());
        }
    }

    public void acaoVoltar() {
        fecharTela();
        ControladorCadastrarAlbum controladorCadastroAlbum = new ControladorCadastrarAlbum(new TelaCadastroAlbum(), new FaixasTableModel(this.album.getFaixas()), this.album);
        controladorCadastroAlbum.preencherInformacaoAposCadastroFaixa();
        controladorCadastroAlbum.exibirTela();
    }

}
