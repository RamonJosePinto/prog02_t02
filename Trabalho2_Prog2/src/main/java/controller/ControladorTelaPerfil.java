/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
import dao.FaixaDAO;
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
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Album;
import model.AlbumComparatorScoreCrescente;
import model.AlbumComparatorScoreDecrescente;
import model.Artista;
import model.ManipularImagem;
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
    private List<Map> componentesAlbum = new ArrayList();
    private int paginaAtual = 1;
    private int numeroPaginas;

    public ControladorTelaPerfil(TelaPerfil telaPerfil, JFrame telaAnterior, Pessoa pessoaAcessando) {
        this.telaAnterior = telaAnterior;
        this.telaPerfil = telaPerfil;
        this.pessoa = Pessoa.getUsuarioLogado();

        inicializarBotoes();

        this.telaPerfil.esconderInformacoes();
        carregarComboBoxOrdenacao();
        this.telaPerfil.exibirOpcaoCombo();

        // Continuação do código
        Pessoa usuarioLogado = Pessoa.getUsuarioLogado();
        this.telaPerfil.setNomePerfil(pessoa.getNome());
        this.telaPerfil.setUserName("@" + pessoa.getUsername());

        if (pessoa.getTipoPessoa() == TipoPessoa.ARTISTA) {    // é perfil de artista
            Artista artistaAcessando = (Artista) pessoa;
            this.telaPerfil.setExibindo("Álbuns do artista");

            this.telaPerfil.apresentarInformacoes();

            this.telaPerfil.setScoreValor(Integer.toString(artistaAcessando.calcularScore()));
            this.telaPerfil.setReviewsValor(Integer.toString(artistaAcessando.contarReviews()));

            if (pessoaAcessando.equals(usuarioLogado)) {
                this.telaPerfil.exibirBotaoAdicionarAlbum();
            }

            albuns = artistaAcessando.getAlbuns();

        } else {                                                        // é perfil de reviewer
            Reviewer reviewerAcessando = (Reviewer) pessoaAcessando;
            this.telaPerfil.setExibindo("Reviews do usuário");
            this.telaPerfil.setReviewsValor(Integer.toString(reviewerAcessando.contarReviews()));

            List<Review> reviews = reviewerAcessando.getReviews();
            for (Review r : reviews) {
                albuns.add(r.getAlbum());
            }
        }

        if (albuns == null) {
            albuns = new ArrayList<>();
        }

        inicializarImagemPefil();
        
        // Grid de álbuns
        this.componentesAlbum = prepararGridAlbuns();
        ordenarAlbuns();
        this.numeroPaginas = calcularPaginas();
        carregarGridAlbuns(0);
        carregarGridAlbuns(0);
        controlarBotoesPaginacao();
    }

    private void carregarComboBoxOrdenacao() {
        telaPerfil.adicionarOpcaoCombo("Mais novos");
        telaPerfil.adicionarOpcaoCombo("Mais antigos");
        telaPerfil.adicionarOpcaoCombo("Maior score");
        telaPerfil.adicionarOpcaoCombo("Menor score");
    }

    private List<Map> prepararGridAlbuns() {
        // Preenche Map com JComponent 
        Map<String, JComponent> album_1 = new HashMap();
        album_1.put("btnAlbum", telaPerfil.getAlbum_1());
        album_1.put("lbNomeAlbum", telaPerfil.getNomeAlbum_1());
        album_1.put("lbScore", telaPerfil.getScore_1());
        album_1.put("lbAnoLancamento", telaPerfil.getAnoLancamento_1());

        Map<String, JComponent> album_2 = new HashMap();
        album_2.put("btnAlbum", telaPerfil.getAlbum_2());
        album_2.put("lbNomeAlbum", telaPerfil.getNomeAlbum_2());
        album_2.put("lbScore", telaPerfil.getScore_2());
        album_2.put("lbAnoLancamento", telaPerfil.getAnoLancamento_2());

        Map<String, JComponent> album_3 = new HashMap();
        album_3.put("btnAlbum", telaPerfil.getAlbum_3());
        album_3.put("lbNomeAlbum", telaPerfil.getNomeAlbum_3());
        album_3.put("lbScore", telaPerfil.getScore_3());
        album_3.put("lbAnoLancamento", telaPerfil.getAnoLancamento_3());

        Map<String, JComponent> album_4 = new HashMap();
        album_4.put("btnAlbum", telaPerfil.getAlbum_4());
        album_4.put("lbNomeAlbum", telaPerfil.getNomeAlbum_4());
        album_4.put("lbScore", telaPerfil.getScore_4());
        album_4.put("lbAnoLancamento", telaPerfil.getAnoLancamento_4());

        Map<String, JComponent> album_5 = new HashMap();
        album_5.put("btnAlbum", telaPerfil.getAlbum_5());
        album_5.put("lbNomeAlbum", telaPerfil.getNomeAlbum_5());
        album_5.put("lbScore", telaPerfil.getScore_5());
        album_5.put("lbAnoLancamento", telaPerfil.getAnoLancamento_5());

        Map<String, JComponent> album_6 = new HashMap();
        album_6.put("btnAlbum", telaPerfil.getAlbum_6());
        album_6.put("lbNomeAlbum", telaPerfil.getNomeAlbum_6());
        album_6.put("lbScore", telaPerfil.getScore_6());
        album_6.put("lbAnoLancamento", telaPerfil.getAnoLancamento_6());

        List<Map> componentesAlbum = new ArrayList();
        componentesAlbum.add(album_1);
        componentesAlbum.add(album_2);
        componentesAlbum.add(album_3);
        componentesAlbum.add(album_4);
        componentesAlbum.add(album_5);
        componentesAlbum.add(album_6);

        return componentesAlbum;
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

    private void carregarGridAlbuns(int index) {
        limparGridAlbuns();

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

//            // Se a lista já tem 6 elementos, interrompe a leitura
//            if (albunsGrid.size() >= 6) {
//                break;
//            }
        }

        int albunsCarregados = 0;

        for (Album album : albunsGrid) {
            Map<String, JComponent> componente = this.componentesAlbum.get(albunsCarregados);
            JButton btnAlbum = (JButton) componente.get("btnAlbum");
            JLabel lbNomeAlbum = (JLabel) componente.get("lbNomeAlbum");
            JLabel lbScore = (JLabel) componente.get("lbScore");
            JLabel lbAnoLancamento = (JLabel) componente.get("lbAnoLancamento");

            int score = album.calcularScore();

            btnAlbum.setVisible(true);
            lbNomeAlbum.setVisible(true);
            lbScore.setVisible(true);
            lbAnoLancamento.setVisible(true);

            btnAlbum.setText(album.getTitulo());
            lbNomeAlbum.setText(album.getTitulo());
            lbScore.setText((score < 0 ? "SN" : Integer.toString(score)));
            lbAnoLancamento.setText(Integer.toString(album.getAnoLancamento()));

            albunsCarregados++;
        }
    }

    private void limparGridAlbuns() {
        for (Map m : this.componentesAlbum) {
            JButton btnAlbum = (JButton) m.get("btnAlbum");
            JLabel lbNomeAlbum = (JLabel) m.get("lbNomeAlbum");
            JLabel lbScore = (JLabel) m.get("lbScore");
            JLabel lbAnoLancamento = (JLabel) m.get("lbAnoLancamento");

            btnAlbum.setVisible(false);
            lbNomeAlbum.setVisible(false);
            lbScore.setVisible(false);
            lbAnoLancamento.setVisible(false);
        }
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

    private void inicializarImagemPefil() {
        try {
            File arquivo = pessoa.getPathImagemPerfil().toFile();
            BufferedImage imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
            telaPerfil.atualizarImagemPerfil(imagem);
        } catch(Exception ex) {
            telaPerfil.exibirMensagem("Não foi possível carregar sua imagem de perfil. Por favor, faça upload novamente.");
        }
    }
    
    private void inicializarImagemPefil(Path pathImagem) {
        try {
            File arquivo = pathImagem.toFile();
            BufferedImage imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
            telaPerfil.atualizarImagemPerfil(imagem);
        } catch(Exception ex) {
            telaPerfil.exibirMensagem("Não foi possível carregar sua imagem de perfil. Por favor, faça upload novamente.");
        }
        
    }
    
    private void acaoAtualizarImagemPerfil() {
        boolean imagemSubiu = false;
        Path path = null;
        File arquivo = telaPerfil.subirImagemPerfil();
        
        // Copia o arquivo e coloca na pasta images no projeto
        if (arquivo != null) {
            try {
                path = Files.copy(arquivo.toPath(), new File("images/pessoa/" + pessoa.getIdPessoa()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                
                if (!path.toString().isBlank())
                    imagemSubiu = true;
            } catch (IOException ex) {
                imagemSubiu = false;
            }
        }
        
        if (imagemSubiu) {
            this.pessoa.setPathImagemPerfil(path);
            inicializarImagemPefil(path);
        } else {
            telaPerfil.exibirMensagem("Não foi possível fazer upload da imagem de perfil.");
        }
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
        ControladorTelaInicial controladorTelaInicial = new ControladorTelaInicial(new TelaInicial());
        controladorTelaInicial.exibirTela();

    }

    private void acaoComboBox() {
        ordenarAlbuns();
        carregarGridAlbuns(0);
        controlarBotoesPaginacao();
    }

    private void acaoAnterior() {
        paginaAtual--;
        int index = (paginaAtual - 1) * 6;
        carregarGridAlbuns(index);
        controlarBotoesPaginacao();
    }

    private void acaoProximo() {
        paginaAtual++;
        int index = (paginaAtual - 1) * 6;
        carregarGridAlbuns(index);
        controlarBotoesPaginacao();
    }

}
