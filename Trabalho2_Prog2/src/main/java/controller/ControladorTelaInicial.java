/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import model.Album;
import model.Pessoa;
import model.table.FaixasTableModel;
import util.ManipularImagem;
import view.TelaInicial;
import view.TelaListaFaixas;
import view.TelaPerfil;

/**
 *
 * @author Usuario
 */
public class ControladorTelaInicial {

    private TelaInicial telaInicial;
    private Pessoa pessoa;
    private List<Album> albuns;
//  private List<Map> componentesAlbum;
    private int numeroPaginas;
    private int paginaAtual = 1;

    public ControladorTelaInicial(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        this.pessoa = Pessoa.getUsuarioLogado();
        this.albuns = new AlbumDAO().getListaAlbuns();
        Collections.sort(albuns);

        this.telaInicial.prepararGridAlbuns();
        selecionarAlbuns(paginaAtual);
        controlarBotoesPaginacao();

        this.telaInicial.setNomePessoaLogada(pessoa.getNome());
        inicializarBotoes();
        inicializarImagemPefil();
    }

    private void controlarBotoesPaginacao() {
        this.numeroPaginas = calcularPaginas();
        if (paginaAtual == 1) {
            telaInicial.getBotaoAnterior().setEnabled(false);
        } else {
            telaInicial.getBotaoAnterior().setEnabled(true);
        }

        if (paginaAtual == numeroPaginas) {
            telaInicial.getBotaoProxima().setEnabled(false);
        } else {
            telaInicial.getBotaoProxima().setEnabled(true);
        }

        telaInicial.setLbPagina(paginaAtual + " | " + numeroPaginas);
    }

    private int calcularPaginas() {
        float numeroAlbuns = albuns.size();
        float divisao = numeroAlbuns / 6.0f;
        int divisaoInteiro = (int) divisao;
        return (divisaoInteiro < divisao ? (divisaoInteiro + 1) : divisaoInteiro);
    }

    private void selecionarAlbuns(int index) {
        telaInicial.limparGridAlbuns();

        // Pegar trecho da lista de álbuns correspondente ao index de início, pegando no máximo 6 álbuns ou até o fim da lista.
        List<Album> albunsGrid = new ArrayList();

        for (int i = index; i < (index + 6); i++) {
            Album a = new Album();

            // Tenta pegar o álbum na posição i. Captura *qualquer* erro e interrompe a leitura.
            try {
                a = albuns.get(i);
                albunsGrid.add(a);
            } catch (Exception e) {
                break;
            }
        }
        
        telaInicial.carregarGridAlbuns(albunsGrid, inicializarImagemAlbunsGrid(albunsGrid));
    }

    private Map<Integer, Image> inicializarImagemAlbunsGrid(List<Album> albunsGrid) {     // ADICIONAR PARÂMETRO PARA RECEBER O ÁLBUM
        Map<Integer, Image> imagensGrid = new HashMap();
        
        for (Album album : albunsGrid) {
            try {
                imagensGrid.put(album.getIdAlbum(), ManipularImagem.buscarImagem(album.getCaminhoImagemCapa()));
            } catch(NullPointerException ex) {
                System.out.println("");
            }  catch (IOException ex) {
                System.out.println("");
            }
        }

        return imagensGrid;
    }
    
    private void inicializarImagemPefil() {
        try {
            telaInicial.atualizarImagemPerfil(ManipularImagem.buscarImagem(pessoa.getCaminhoImagemPerfil()));
        } catch(NullPointerException ex) {
            System.out.println("O usuário não tem foto de perfil cadastrada.");
        }  catch (IOException ex) {
            telaInicial.exibirMensagem("Não foi possível carregar sua imagem de perfil. Por favor, faça upload novamente.");
        }
    }
    
    public void inicializarBotoes() {
        telaInicial.adicionarAcaoBotaoProximo(acao -> acaoProximo());
        telaInicial.adicionarAcaoBotaoAnterior(acao -> acaoAnterior());
        telaInicial.adicionarAcaoFotoPerfil(acao -> acaoFotoPerfil());
        telaInicial.adicionarAcaoBotaoAlbum_1(acao -> acaoAlbum_1());
        telaInicial.adicionarAcaoBotaoAlbum_2(acao -> acaoAlbum_2());
        telaInicial.adicionarAcaoBotaoAlbum_3(acao -> acaoAlbum_3());
        telaInicial.adicionarAcaoBotaoAlbum_4(acao -> acaoAlbum_4());
        telaInicial.adicionarAcaoBotaoAlbum_5(acao -> acaoAlbum_5());
        telaInicial.adicionarAcaoBotaoAlbum_6(acao -> acaoAlbum_6());
    }

    public void acaoFotoPerfil() {
        ControladorTelaPerfil controladorTelaPerfil = new ControladorTelaPerfil(new TelaPerfil(), telaInicial, pessoa);
        controladorTelaPerfil.exibirTela();
        telaInicial.fecharTela();
    }

    private void acaoAnterior() {
        paginaAtual--;
        int index = (paginaAtual - 1) * 6;
        selecionarAlbuns(index);
        controlarBotoesPaginacao();
    }

    private void acaoProximo() {
        paginaAtual++;
        int index = (paginaAtual - 1) * 6;
        selecionarAlbuns(index);
        controlarBotoesPaginacao();
    }

    public void acaoAlbum_1() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_1());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_2() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_2());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_3() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_3());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_4() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_4());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_5() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_5());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_6() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_6());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void exibirTela() {
        telaInicial.exibirTela();
    }
}
