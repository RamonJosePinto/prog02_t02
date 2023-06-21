/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
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
            
    public ControladorCadastrarAlbum(TelaCadastroAlbum telaCadastroAlbum, FaixasTableModel faixasTableModel) {
        this.telaCadastroAlbum = telaCadastroAlbum;
        this.faixasTableModel = faixasTableModel;
        setTableModel();
        inicializarBotoes();
    }
    
    public void setTableModel(){
        telaCadastroAlbum.setTableModel(this.faixasTableModel);
    }

    public void inicializarBotoes() {
        telaCadastroAlbum.adicionarAcaoBotaoCancelar(acao -> {
            acaoCancelar();
        });
        telaCadastroAlbum.adicionarAcaoBotaoEnviar(acao -> {
            acaoEnviar();
        });
//        telaCadastroAlbum.adicionarAcaoBotaoCadastrarFaixas(acao -> {
//            acaoCadastrarFaixas();
//        });
    }

    public void acaoCancelar() {
        Faixa.faixaCadastrando.clear();
        fecharTela();

    }

    public void acaoEnviar() {
        System.out.println(Faixa.faixaCadastrando);
        if (Faixa.faixaCadastrando.size() == 0) {
            telaCadastroAlbum.exibirMensagem("Para cadastrar um album é preciso cadastrar pelo menos uma musica no mesmo");
        } else {
            String titulo = telaCadastroAlbum.getTituloAlbum();
            int anoLan = Integer.parseInt(telaCadastroAlbum.getAnoLancamentoAlbum());
            AlbumDAO albDao = new AlbumDAO();
            albDao.salvarAlbum(Album.getAlbumCadastrando());
            telaCadastroAlbum.exibirMensagem("Album Cadastrado com sucesso");
            int opcao = telaCadastroAlbum.exibirMensagemConfirmacao("Você deseja cadastrar outro album?", "Confirmação");
            if (telaCadastroAlbum.opcaoSelecionada(opcao)) {
                telaCadastroAlbum.setTituloAlbum("");
                telaCadastroAlbum.setAnoLancamentoAlbum("");
                Faixa.faixaCadastrando.clear();
                Album.setAlbumCadastrando();

            } else {
                Faixa.faixaCadastrando.clear();
                Album.setAlbumCadastrando();
                fecharTela();

            }
        }
    }

    public void acaoCadastrarFaixas() {
        if ((telaCadastroAlbum.getTituloAlbum().isEmpty()) || (telaCadastroAlbum.getAnoLancamentoAlbum().isEmpty())) {
            telaCadastroAlbum.exibirMensagem("Antes criar uma faixa, por favor preencha o nome e ano do album");
        } else {
            String titulo = telaCadastroAlbum.getTituloAlbum();
            int anoLan = Integer.parseInt(telaCadastroAlbum.getAnoLancamentoAlbum());
            Artista art = (Artista) Pessoa.getUsuarioLogado();
            Album.setAlbumCadastrando(new Album(titulo, anoLan, art));

            ControladorCadastrarAlbumFaixas controladorCadastroAlbumFaixas = new ControladorCadastrarAlbumFaixas(new TelaCadastroAlbumFaixas(), Album.getAlbumCadastrando());
            controladorCadastroAlbumFaixas.exibirTela();
        }
    }

    public void fecharTela() {
        telaCadastroAlbum.fecharTela();
    }
    
    public void exibirTela(){
        telaCadastroAlbum.exibirTela();
    }

}
