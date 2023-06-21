/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
import exception.AlbumSemFaixaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Album;
import model.Artista;
import model.Faixa;
import model.Pessoa;
import model.table.FaixasTableModel;
import view.TelaCadastroAlbum;
import view.TelaCadastroAlbumFaixas;

/**
 *
 * @author Usuario
 */
public class ControladorCadastrarAlbum {

    private TelaCadastroAlbum telaCadastroAlbum;
    private FaixasTableModel faixasTableModel;
    private Album alb;

    public ControladorCadastrarAlbum(TelaCadastroAlbum telaCadastroAlbum, FaixasTableModel faixasTableModel, Album alb) {
        this.telaCadastroAlbum = telaCadastroAlbum;
        this.faixasTableModel = faixasTableModel;
        this.alb = alb;

        setTableModel();
        inicializarBotoes();
    }

    public void setTableModel() {
        telaCadastroAlbum.setTableModel(this.faixasTableModel);
    }

    public void inicializarBotoes() {
        telaCadastroAlbum.adicionarAcaoBotaoCancelar(acao -> {
            acaoCancelar();
        });
        telaCadastroAlbum.adicionarAcaoBotaoEnviar(acao -> {
            acaoEnviar();
        });
        telaCadastroAlbum.adicionarAcaoBotaoCadastrarFaixa(acao -> {
            acaoCadastrarFaixas();
        });
    }

    public void acaoCancelar() {
        //Faixa.faixaCadastrando.clear();
        fecharTela();

    }

    public void acaoEnviar() {
        try {
            //System.out.println(Faixa.faixaCadastrando);
            String titulo = telaCadastroAlbum.getTituloAlbum();
            int anoLan = Integer.parseInt(telaCadastroAlbum.getAnoLancamentoAlbum());
            AlbumDAO albDao = new AlbumDAO();
            albDao.salvarAlbum(this.alb);
            telaCadastroAlbum.exibirMensagem("Album Cadastrado com sucesso");
            int opcao = telaCadastroAlbum.exibirMensagemConfirmacao("Você deseja cadastrar outro album?", "Confirmação");
            if (telaCadastroAlbum.opcaoSelecionada(opcao)) {
                telaCadastroAlbum.setTituloAlbum("");
                telaCadastroAlbum.setAnoLancamentoAlbum("");
                //Faixa.faixaCadastrando.clear();
                //Album.setAlbumCadastrando();

            } else {
                //Faixa.faixaCadastrando.clear();
                //Album.setAlbumCadastrando();
                fecharTela();

            }
        } catch (AlbumSemFaixaException ex) {
            telaCadastroAlbum.exibirMensagem(ex.getMessage());
        }
        
    }

    public void acaoCadastrarFaixas() {
        if ((telaCadastroAlbum.getTituloAlbum().isEmpty()) || (telaCadastroAlbum.getAnoLancamentoAlbum().isEmpty())) {
            telaCadastroAlbum.exibirMensagem("Antes criar uma faixa, por favor preencha o nome e ano do album");
        } else {
            String titulo = telaCadastroAlbum.getTituloAlbum();
            int anoLan = Integer.parseInt(telaCadastroAlbum.getAnoLancamentoAlbum());
            Artista art = (Artista) Pessoa.getUsuarioLogado();
            this.alb = (new Album(titulo, anoLan, art));

            ControladorCadastrarAlbumFaixas controladorCadastroAlbumFaixas = new ControladorCadastrarAlbumFaixas(new TelaCadastroAlbumFaixas(), this.alb);
            controladorCadastroAlbumFaixas.exibirTela();
            fecharTela();
        }
    }

    public void fecharTela() {
        telaCadastroAlbum.fecharTela();
    }

    public void exibirTela() {
        telaCadastroAlbum.exibirTela();
    }
    
    public void preencherInformacaoAposCadastroFaixa(){
        telaCadastroAlbum.setTituloAlbum(this.alb.getTitulo());
        telaCadastroAlbum.setAnoLancamentoAlbum(Integer.toString(this.alb.getAnoLancamento()));
    }

}
