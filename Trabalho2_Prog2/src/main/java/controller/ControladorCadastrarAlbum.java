/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
import dao.PessoaDAO;
import exception.AlbumSemFaixaException;
import exception.ImagemInexistenteException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Album;
import model.Artista;
import model.Faixa;
import model.Pessoa;
import model.table.FaixasTableModel;
import util.ManipularImagem;
import view.TelaCadastroAlbum;
import view.TelaCadastroAlbumFaixas;

/**
 *
 * @author Usuario
 */
public class ControladorCadastrarAlbum {

    private TelaCadastroAlbum telaCadastroAlbum;
    private FaixasTableModel faixasTableModel;
    private Album album;

    public ControladorCadastrarAlbum(TelaCadastroAlbum telaCadastroAlbum, FaixasTableModel faixasTableModel, Album album) {
        this.telaCadastroAlbum = telaCadastroAlbum;
        this.faixasTableModel = faixasTableModel;
        this.album = album;

        setTableModel();
        inicializarBotoes();
    }

    public void setTableModel() {
        telaCadastroAlbum.setTableModel(this.faixasTableModel);
    }

    public void inicializarBotoes() {
        telaCadastroAlbum.adicionarAcaoBotaoCancelar(acao -> acaoCancelar());
        telaCadastroAlbum.adicionarAcaoBotaoEnviar(acao -> acaoEnviar());
        telaCadastroAlbum.adicionarAcaoBotaoCadastrarFaixa(acao -> acaoCadastrarFaixas());
        telaCadastroAlbum.adicionarAcaoBotaoAtualizarCapa(acao -> atualizarCapa());
    }

    public void acaoCancelar() {
        //Faixa.faixaCadastrando.clear();
        telaCadastroAlbum.fecharTela();
    }

    public void acaoEnviar() {
        try {
            //System.out.println(Faixa.faixaCadastrando);
            String titulo = telaCadastroAlbum.getTituloAlbum();
            int anoLan = Integer.parseInt(telaCadastroAlbum.getAnoLancamentoAlbum());
            AlbumDAO albDao = new AlbumDAO();
            albDao.salvarAlbum(this.album);
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
                telaCadastroAlbum.fecharTela();
            }
        } catch (AlbumSemFaixaException ex) {
            telaCadastroAlbum.exibirMensagem(ex.getMessage());
        } catch(NumberFormatException ex){
            telaCadastroAlbum.exibirMensagem("Por favor informe valores válidos para o ano de lançamento da faixa");
        }
        
    }

    public void acaoCadastrarFaixas() {
        if ((telaCadastroAlbum.getTituloAlbum().isEmpty()) || (telaCadastroAlbum.getAnoLancamentoAlbum().isEmpty())) {
            telaCadastroAlbum.exibirMensagem("Antes criar uma faixa, por favor preencha o nome e ano do album");
        } else {
            String titulo = telaCadastroAlbum.getTituloAlbum();
            int anoLan = Integer.parseInt(telaCadastroAlbum.getAnoLancamentoAlbum());
            Artista art = (Artista) Pessoa.getUsuarioLogado();
            this.album = (new Album(titulo, anoLan, art));

            ControladorCadastrarAlbumFaixas controladorCadastroAlbumFaixas = new ControladorCadastrarAlbumFaixas(new TelaCadastroAlbumFaixas(), this.album);
            controladorCadastroAlbumFaixas.exibirTela();
            telaCadastroAlbum.fecharTela();
        }
    }

    public void atualizarCapa() {
        File arquivo = telaCadastroAlbum.subirImagemAlbum();
        
        String arquivoOrigem = arquivo.toPath().toString();
        String nomeArquivo = Integer.toString(album.getIdAlbum());
  
        try {
            String caminhoImagemPerfil = ManipularImagem.gravarImagemAlbum(arquivoOrigem, nomeArquivo, 125, 125);
            
            album.setCaminhoImagemCapa(caminhoImagemPerfil);
            telaCadastroAlbum.exibirMensagem("Sua imagem de perfil foi atualizada.");
            inicializarImagemCapa();
        } catch (IOException ex) {
            telaCadastroAlbum.exibirMensagem("Não foi possível fazer upload da imagem de perfil.");
        }
    }
    
    private void inicializarImagemCapa() {
        try {
            telaCadastroAlbum.atualizarImagemCapa(ManipularImagem.buscarImagem(album.getCaminhoImagemCapa()));
        }  catch (IOException ex) {
            telaCadastroAlbum.exibirMensagem("Não foi possível carregar a capa do álbum. Por favor, faça upload novamente.");
        } catch (ImagemInexistenteException ex) {
            Logger.getLogger(ControladorTelaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exibirTela() {
        telaCadastroAlbum.exibirTela();
    }
    
    public void preencherInformacaoAposCadastroFaixa(){
        telaCadastroAlbum.setTituloAlbum(this.album.getTitulo());
        telaCadastroAlbum.setAnoLancamentoAlbum(Integer.toString(this.album.getAnoLancamento()));
    }

}
