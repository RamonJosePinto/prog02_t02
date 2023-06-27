/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
import dao.FaixaDAO;
import dao.PessoaDAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Album;
import model.AlbumComparatorScoreCrescente;
import model.AlbumComparatorScoreDecrescente;
import model.Artista;
import util.ManipularImagem;
import model.Pessoa;
import model.Pessoa.TipoPessoa;
import model.Review;
import model.Reviewer;
import model.table.FaixasTableModel;
import view.TelaCadastroAlbum;
import view.TelaInicial;
import view.TelaListaFaixas;
import view.TelaPerfil;

/**
 *
 * @author Usuario
 */
public class ControladorTelaPerfil {

    private TelaPerfil telaPerfil;
    private JFrame telaAnterior;
    private Pessoa pessoa;
    private List<Album> albuns = new ArrayList();
//  private List<Map> componentesAlbum = new ArrayList();
    private int paginaAtual = 1;
    private int numeroPaginas;

    public ControladorTelaPerfil(TelaPerfil telaPerfil, JFrame telaAnterior, Pessoa pessoaAcessando) {
        this.telaAnterior = telaAnterior;
        this.telaPerfil = telaPerfil;
        this.pessoa = pessoaAcessando;

        // Continuação do código
        this.telaPerfil.esconderInformacoes();

        //Pessoa usuarioLogado = pessoa;
        this.telaPerfil.setNomePerfil(pessoa.getNome());
        this.telaPerfil.setUserName("@" + pessoa.getUsername());
        inicializarImagemPefil();

        exibirPerfilPessoa();
        
        if (albuns == null) {
            albuns = new ArrayList<>();
        }

        // Grid de álbuns
        this.numeroPaginas = calcularPaginas();
        this.telaPerfil.prepararGridAlbuns();
        selecionarAlbuns(0);
        //ordenarAlbuns();
        //this.telaPerfil.carregarGridAlbuns(albuns);

        controlarBotoesPaginacao();
        carregarComboBoxOrdenacao();
        this.telaPerfil.exibirOpcaoCombo();
        inicializarBotoes();
    }

    public void exibirPerfilPessoa() {
        if (pessoa.getTipoPessoa() == TipoPessoa.ARTISTA) {    // é perfil de artista
            Artista artistaAcessando = (Artista) pessoa;
            this.telaPerfil.setExibindo("Álbuns do artista");
            this.telaPerfil.apresentarInformacoes();
            this.telaPerfil.setScoreValor(Integer.toString(artistaAcessando.calcularScore()));
            this.telaPerfil.setReviewsValor(Integer.toString(artistaAcessando.contarReviews()));

            //if (pessoa.equals(usuarioLogado)) {
            this.telaPerfil.exibirBotaoAdicionarAlbum();
            //}

            albuns = artistaAcessando.getAlbuns();
        } else {                                                        // é perfil de reviewer
            Reviewer reviewerAcessando = (Reviewer) pessoa;
            this.telaPerfil.setExibindo("Reviews do usuário");
            this.telaPerfil.setReviewsValor(Integer.toString(reviewerAcessando.contarReviews()));

            List<Review> reviews = reviewerAcessando.getReviews();
            for (Review r : reviews) {
                albuns.add(r.getAlbum());
            }
        }
    }

    private void selecionarAlbuns(int index) {
        telaPerfil.limparGridAlbuns();

        // Pegar trecho da lista de álbuns correspondente ao index de início, pegando no máximo 6 álbuns ou até o fim da lista.
        List<Album> albunsGrid = new ArrayList();

        for (int i = index; i < (index + 6); i++) {
            Album a = new Album();

            // Tenta pegar o álbum na posição i. Captura qualquer erro e interrompe a leitura.
            try {
                a = albuns.get(i);
                albunsGrid.add(a);
            } catch (Exception e) {
                break;
            }
        }

        telaPerfil.carregarGridAlbuns(albunsGrid, inicializarImagemAlbunsGrid(albunsGrid));
    }

    private void carregarComboBoxOrdenacao() {
        telaPerfil.adicionarOpcaoCombo("Mais novos");
        telaPerfil.adicionarOpcaoCombo("Mais antigos");
        telaPerfil.adicionarOpcaoCombo("Maior score");
        telaPerfil.adicionarOpcaoCombo("Menor score");
    }

    private void ordenarAlbuns() {
        this.paginaAtual = 1;
        String item = telaPerfil.getCbSelecionadoString();

        switch (item) {
            case ("Mais novos"):
                Collections.sort(albuns, new Comparator<Album>() {
                    @Override
                    public int compare(Album a1, Album a2) {
                        if (a1.getAnoLancamento() > a2.getAnoLancamento()) {
                            return -1;
                        }

                        if (a1.getAnoLancamento() < a2.getAnoLancamento()) {
                            return 1;
                        }

                        return 0;
                    }
                });
                break;

            case ("Mais antigos"):
                Collections.sort(albuns, new Comparator<Album>() {
                    @Override
                    public int compare(Album a1, Album a2) {
                        if (a1.getAnoLancamento() < a2.getAnoLancamento()) {
                            return -1;
                        }

                        if (a1.getAnoLancamento() > a2.getAnoLancamento()) {
                            return 1;
                        }

                        return 0;
                    }
                });
                break;

            case ("Maior score"):
                Collections.sort(albuns, new AlbumComparatorScoreDecrescente());
                break;

            case ("Menor score"):
                Collections.sort(albuns, new AlbumComparatorScoreCrescente());
                break;
        }
    }

    private int calcularPaginas() {
        float numeroAlbuns = albuns.size();
        float divisao = numeroAlbuns / 6.0f;
        int divisaoInteiro = (int) divisao;
        return (divisaoInteiro < divisao ? (divisaoInteiro + 1) : divisaoInteiro);
    }

    private void controlarBotoesPaginacao() {
        if (paginaAtual == 1) {
            telaPerfil.getBotaoAnterior().setEnabled(false);
        } else {
            telaPerfil.getBotaoAnterior().setEnabled(true);
        }

        if (paginaAtual == numeroPaginas) {
            telaPerfil.getBotaoProxima().setEnabled(false);
        } else {
            telaPerfil.getBotaoProxima().setEnabled(true);
        }

        telaPerfil.setLbPagina(paginaAtual + " | " + numeroPaginas);
    }

    public void exibirTela() {
        telaPerfil.exbirTela();
    }

    private Map<Integer, Image> inicializarImagemAlbunsGrid(List<Album> albunsGrid) {     // ADICIONAR PARÂMETRO PARA RECEBER O ÁLBUM
        Map<Integer, Image> imagensGrid = new HashMap();

        for (Album album : albunsGrid) {
            try {
                imagensGrid.put(album.getIdAlbum(), ManipularImagem.buscarImagem(album.getCaminhoImagemCapa()));
                /*            } catch(NullPointerException ex) {
                System.out.println("");*/
            } catch (IOException ex) {
                System.out.println("");
            }
        }

        return imagensGrid;
    }

    private void inicializarImagemPefil() {
        try {
            telaPerfil.atualizarImagemPerfil(ManipularImagem.buscarImagem(pessoa.getCaminhoImagemPerfil()));
        } catch (NullPointerException ex) {
            System.out.println("O usuário não tem foto de perfil cadastrada.");
        } catch (IOException ex) {
            telaPerfil.exibirMensagem("Não foi possível carregar sua imagem de perfil. Por favor, faça upload novamente.");
        }
    }

    private void acaoAtualizarImagemPerfil() {
        File arquivo = telaPerfil.subirImagemPerfil();

        String arquivoOrigem = arquivo.toPath().toString();

        String nomeArquivo = Integer.toString(pessoa.getIdPessoa());

        try {
            String caminhoImagemPerfil = ManipularImagem.gravarImagemPerfil(arquivoOrigem, nomeArquivo, 135, 135);

            if (new PessoaDAO().atualizarImagemPessoa(pessoa.getIdPessoa(), caminhoImagemPerfil)) {
                pessoa.setCaminhoImagemPerfil(caminhoImagemPerfil);
                telaPerfil.exibirMensagem("Sua imagem de perfil foi atualizada.");
                inicializarImagemPefil();
            } else {
                telaPerfil.exibirMensagem("Não foi possível fazer upload da imagem de perfil.");
            }
        } catch (IOException | NullPointerException ex) {
            telaPerfil.exibirMensagem("Não foi possível fazer upload da imagem de perfil.");
        }
    }

    private void inicializarBotoes() {
        telaPerfil.adicionarAcaoBotaoPerfil(acao -> acaoAtualizarImagemPerfil());
        telaPerfil.adicionarAcaoBotaoProximo(acao -> acaoProximo());
        telaPerfil.adicionarAcaoBotaoAnterior(acao -> acaoAnterior());
        telaPerfil.adicionarAcaoComboBox(acao -> acaoComboBox());
        telaPerfil.adicionarAcaoVoltar(acao -> acaoVoltar());
        telaPerfil.adicionarAcaoBotaoAlbum_1(acao -> acaoAlbum_1());
        telaPerfil.adicionarAcaoBotaoAlbum_2(acao -> acaoAlbum_2());
        telaPerfil.adicionarAcaoBotaoAlbum_3(acao -> acaoAlbum_3());
        telaPerfil.adicionarAcaoBotaoAlbum_4(acao -> acaoAlbum_4());
        telaPerfil.adicionarAcaoBotaoAlbum_5(acao -> acaoAlbum_5());
        telaPerfil.adicionarAcaoBotaoAlbum_6(acao -> acaoAlbum_6());
        telaPerfil.adicionarAcaoBotaoCadastrarAlbum(acao -> acaoCadastrarAlbum());
    }

    private void acaoCadastrarAlbum() {
        Album novoAlb = new Album();
        ControladorCadastrarAlbum controladorCadastroAlbum = new ControladorCadastrarAlbum(new TelaCadastroAlbum(), new FaixasTableModel(novoAlb.getFaixas()), novoAlb);
        controladorCadastroAlbum.exibirTela();
    }

    private void acaoAlbum_1() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaPerfil.getNomeAlbum_1().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaPerfil, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaPerfil.fecharTela();

    }

    private void acaoAlbum_2() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaPerfil.getNomeAlbum_2().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaPerfil, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaPerfil.fecharTela();

    }

    private void acaoAlbum_3() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaPerfil.getNomeAlbum_3().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaPerfil, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaPerfil.fecharTela();

    }

    private void acaoAlbum_4() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaPerfil.getNomeAlbum_4().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaPerfil, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaPerfil.fecharTela();

    }

    private void acaoAlbum_5() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaPerfil.getNomeAlbum_5().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaPerfil, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaPerfil.fecharTela();

    }

    private void acaoAlbum_6() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaPerfil.getNomeAlbum_6().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaPerfil, albumSelected, new FaixasTableModel(albumSelected.getFaixas()));
        controladorTelaListaFaixas.exibirTela();
        telaPerfil.fecharTela();
    }

    private void acaoVoltar() {
        telaPerfil.fecharTela();
        ControladorTelaInicial controladorTelaInicial = new ControladorTelaInicial(new TelaInicial(), pessoa);
        controladorTelaInicial.exibirTela();

    }

    private void acaoComboBox() {
        ordenarAlbuns();
        selecionarAlbuns(0);
        controlarBotoesPaginacao();
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

}
