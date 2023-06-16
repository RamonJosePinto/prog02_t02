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
    private List<Map> componentesAlbum;
    private int numeroPaginas;
    private int paginaAtual = 1;

    public ControladorTelaInicial(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        this.pessoa = Pessoa.getUsuarioLogado();
        this.albuns = new AlbumDAO().getListaAlbuns();
        Collections.sort(albuns);

        this.componentesAlbum = prepararGridAlbuns();
        carregarGridAlbuns(paginaAtual);
        controlarBotoesPaginacao();

        telaInicial.setNomePessoaLogada(pessoa.getNome());
        inicializarBotoes();
    }

    private List<Map> prepararGridAlbuns() {
        // Preenche Map com JComponent 
        Map<String, JComponent> album_1 = new HashMap();
        album_1.put("btnAlbum", telaInicial.getAlbum_1());
        album_1.put("lbNomeAlbum", telaInicial.getNomeAlbum_1());
        album_1.put("lbNomeArtista", telaInicial.getNomeArtista_1());
        album_1.put("lbAnoLancamento", telaInicial.getAnoLancamento_1());

        Map<String, JComponent> album_2 = new HashMap();
        album_2.put("btnAlbum", telaInicial.getAlbum_2());
        album_2.put("lbNomeAlbum", telaInicial.getNomeAlbum_2());
        album_2.put("lbNomeArtista", telaInicial.getNomeArtista_2());
        album_2.put("lbAnoLancamento", telaInicial.getAnoLancamento_2());

        Map<String, JComponent> album_3 = new HashMap();
        album_3.put("btnAlbum", telaInicial.getAlbum_3());
        album_3.put("lbNomeAlbum", telaInicial.getNomeAlbum_3());
        album_3.put("lbNomeArtista", telaInicial.getNomeArtista_3());
        album_3.put("lbAnoLancamento", telaInicial.getAnoLancamento_3());

        Map<String, JComponent> album_4 = new HashMap();
        album_4.put("btnAlbum", telaInicial.getAlbum_4());
        album_4.put("lbNomeAlbum", telaInicial.getNomeAlbum_4());
        album_4.put("lbNomeArtista", telaInicial.getNomeArtista_4());
        album_4.put("lbAnoLancamento", telaInicial.getAnoLancamento_4());

        Map<String, JComponent> album_5 = new HashMap();
        album_5.put("btnAlbum", telaInicial.getAlbum_5());
        album_5.put("lbNomeAlbum", telaInicial.getNomeAlbum_5());
        album_5.put("lbNomeArtista", telaInicial.getNomeArtista_5());
        album_5.put("lbAnoLancamento", telaInicial.getAnoLancamento_5());

        Map<String, JComponent> album_6 = new HashMap();
        album_6.put("btnAlbum", telaInicial.getAlbum_6());
        album_6.put("lbNomeAlbum", telaInicial.getNomeAlbum_6());
        album_6.put("lbNomeArtista", telaInicial.getNomeArtista_6());
        album_6.put("lbAnoLancamento", telaInicial.getAnoLancamento_6());

        List<Map> componentesAlbum = new ArrayList();
        componentesAlbum.add(album_1);
        componentesAlbum.add(album_2);
        componentesAlbum.add(album_3);
        componentesAlbum.add(album_4);
        componentesAlbum.add(album_5);
        componentesAlbum.add(album_6);

        return componentesAlbum;
    }

    private void limparGridAlbuns() {
        for (Map m : this.componentesAlbum) {
            JButton btnAlbum = (JButton) m.get("btnAlbum");
            JLabel lbNomeAlbum = (JLabel) m.get("lbNomeAlbum");
            JLabel lbNomeArtista = (JLabel) m.get("lbNomeArtista");
            JLabel lbAnoLancamento = (JLabel) m.get("lbAnoLancamento");

            btnAlbum.setVisible(false);
            lbNomeAlbum.setVisible(false);
            lbNomeArtista.setVisible(false);
            lbAnoLancamento.setVisible(false);
        }
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

            albunsCarregados++;
        }
    }

    public void inicializarBotoes() {
        telaInicial.adicionarAcaoBotaoAlbum_1(acao -> {
            acaoAlbum_1();
        });
        telaInicial.adicionarAcaoBotaoAlbum_2(acao -> {
            acaoAlbum_2();
        });
        telaInicial.adicionarAcaoBotaoAlbum_3(acao -> {
            acaoAlbum_3();
        });
        telaInicial.adicionarAcaoBotaoAlbum_4(acao -> {
            acaoAlbum_4();
        });
        telaInicial.adicionarAcaoBotaoAlbum_5(acao -> {
            acaoAlbum_5();
        });
        telaInicial.adicionarAcaoBotaoAlbum_6(acao -> {
            acaoAlbum_6();
        });
        telaInicial.adicionarAcaoBotaoProximo(acao -> {
            acaoProximo();
        });
        telaInicial.adicionarAcaoBotaoAnterior(acao -> {
            acaoAnterior();
        });
        telaInicial.adicionarAcaoFotoPerfil(acao -> {
            acaoFotoPerfil();
        });

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
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_1().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected);
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_2() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_2().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected);
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_3() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_3().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected);
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_4() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_4().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected);
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_5() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_5().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected);
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void acaoAlbum_6() {
        AlbumDAO albDao = new AlbumDAO();
        Album albumSelected = albDao.getAlbumNome(telaInicial.getNomeAlbum_6().getText());
        ControladorTelaListaFaixas controladorTelaListaFaixas = new ControladorTelaListaFaixas(new TelaListaFaixas(), telaInicial, albumSelected);
        controladorTelaListaFaixas.exibirTela();
        telaInicial.fecharTela();

    }

    public void exibirTela() {
        telaInicial.exibirTela();
    }
}
