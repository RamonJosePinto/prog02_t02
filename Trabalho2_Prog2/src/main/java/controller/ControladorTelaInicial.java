/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AlbumDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import model.Album;
import model.Pessoa;
import model.table.FaixasTableModel;
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
        carregarGridAlbuns(paginaAtual);
        controlarBotoesPaginacao();

        this.telaInicial.setNomePessoaLogada(pessoa.getNome());
        inicializarBotoes();
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

    private void carregarGridAlbuns(int index) {
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

        int indexAlbunsCarregados = 0;

        for (Album album : albunsGrid) {
            Map<String, JComponent> componente = telaInicial.getComponentesAlbum().get(indexAlbunsCarregados);
            JButton btnAlbum = (JButton) componente.get("btnAlbum");
            JLabel lbNomeAlbum = (JLabel) componente.get("lbNomeAlbum");
            JLabel lbNomeArtista = (JLabel) componente.get("lbNomeArtista");
            JLabel lbAnoLancamento = (JLabel) componente.get("lbAnoLancamento");

            btnAlbum.setVisible(true);
            lbNomeAlbum.setVisible(true);
            lbNomeArtista.setVisible(true);
            lbAnoLancamento.setVisible(true);

            btnAlbum.setText(album.getTitulo());
            lbNomeAlbum.setText(album.getTitulo());
            lbNomeArtista.setText(album.getArtista().getNome());
            lbAnoLancamento.setText(Integer.toString(album.getAnoLancamento()));

            indexAlbunsCarregados++;
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

    public void acaoAnterior() {
        paginaAtual--;
        int index = (paginaAtual - 1) * 6;
        carregarGridAlbuns(index);
        controlarBotoesPaginacao();
    }

    public void acaoProximo() {
        paginaAtual++;
        int index = (paginaAtual - 1) * 6;
        carregarGridAlbuns(index);
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
