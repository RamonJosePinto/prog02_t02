/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Album;

/**
 *
 * @author Usuario
 */
public class TelaPerfil extends javax.swing.JFrame {

    private final List<Map> componentesAlbum = new ArrayList();
    
    public TelaPerfil() {
        initComponents();
    }
    
    public void limparGridAlbuns() {
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
    
    public void /*List<Map>*/ prepararGridAlbuns() {
        // Preenche Map com JComponent 
        Map<String, JComponent> album_1 = new HashMap();
        album_1.put("btnAlbum", this.btnAlbum_1);
        album_1.put("lbNomeAlbum", this.lbNomeAlbum_1);
        album_1.put("lbScore", this.lbScore_1);
        album_1.put("lbAnoLancamento", this.lbAnoLancamento_1);

        Map<String, JComponent> album_2 = new HashMap();
        album_2.put("btnAlbum", this.btnAlbum_2);
        album_2.put("lbNomeAlbum", this.lbNomeAlbum_2);
        album_2.put("lbScore", this.lbScore_2);
        album_2.put("lbAnoLancamento", this.lbAnoLancamento_2);

        Map<String, JComponent> album_3 = new HashMap();
        album_3.put("btnAlbum", this.btnAlbum_3);
        album_3.put("lbNomeAlbum", this.lbNomeAlbum_3);
        album_3.put("lbScore", this.lbScore_3);
        album_3.put("lbAnoLancamento", this.lbAnoLancamento_3);

        Map<String, JComponent> album_4 = new HashMap();
        album_4.put("btnAlbum", this.btnAlbum_4);
        album_4.put("lbNomeAlbum", this.lbNomeAlbum_4);
        album_4.put("lbScore", this.lbScore_4);
        album_4.put("lbAnoLancamento", this.lbAnoLancamento_4);

        Map<String, JComponent> album_5 = new HashMap();
        album_5.put("btnAlbum", this.btnAlbum_5);
        album_5.put("lbNomeAlbum", this.lbNomeAlbum_5);
        album_5.put("lbScore", this.lbScore_5);
        album_5.put("lbAnoLancamento", this.lbAnoLancamento_5);

        Map<String, JComponent> album_6 = new HashMap();
        album_6.put("btnAlbum", this.btnAlbum_6);
        album_6.put("lbNomeAlbum", this.lbNomeAlbum_6);
        album_6.put("lbScore", this.lbScore_6);
        album_6.put("lbAnoLancamento", this.lbAnoLancamento_6);
        
        componentesAlbum.add(album_1);
        componentesAlbum.add(album_2);
        componentesAlbum.add(album_3);
        componentesAlbum.add(album_4);
        componentesAlbum.add(album_5);
        componentesAlbum.add(album_6);
        //return componentesAlbum;
    }
    
    public void carregarGridAlbuns(List<Album> albunsGrid, Map<Integer, Image> imagensGrid) {
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

            lbNomeAlbum.setText(album.getTitulo());
            lbScore.setText((score < 0 ? "SN" : Integer.toString(score)));
            lbAnoLancamento.setText(Integer.toString(album.getAnoLancamento()));
            
            try {
                btnAlbum.setIcon(new ImageIcon(imagensGrid.get(album.getIdAlbum())));
                btnAlbum.setText(null);
            } catch(NullPointerException ex) {
                System.out.println(ex.getMessage());
                btnAlbum.setIcon(null);
                btnAlbum.setText(album.getTitulo());
            }
            
            albunsCarregados++;
        }
    }
    
    public void esconderInformacoes() {
        lbScoreLabel.setVisible(false);
        lbScoreValor.setVisible(false);
        lbReviewsLabel.setVisible(false);
        lbReviewsValor.setVisible(false);
        btnAdicionarAlbum.setVisible(false);
    }
    
    public void apresentarInformacoes() {
        cbOrdenacao.setVisible(true);
        lbScoreLabel.setVisible(true);
        lbScoreValor.setVisible(true);
        lbReviewsLabel.setVisible(true);
        lbReviewsValor.setVisible(true);
    }
    
    public File subirImagemPerfil() {
        JFileChooser fileChooser = new JFileChooser();
        int resposta = fileChooser.showOpenDialog(null);

        if (resposta == JFileChooser.APPROVE_OPTION)
            return fileChooser.getSelectedFile();
            
        return null;
    }
    
    public void atualizarImagemPerfil(Image imagem) {
        this.btnFotoPerfil.setIcon(new ImageIcon(imagem));
    }
    
    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void adicionarOpcaoCombo(String item) {
        cbOrdenacao.addItem(item);
    }
    
    public void exibirOpcaoCombo() {
        cbOrdenacao.setVisible(true);
    }
    
    public void setNomePerfil(String nome) {
        lbNomePerfil.setText(nome);
    }
    
    public void setUserName(String nome) {
        lbUsernamePerfil.setText(nome);
    }
    
    public void setExibindo(String text) {
        lbExibindo.setText(text);
    }
    
    public void setScoreValor(String text) {
        lbScoreValor.setText(text);
    }
    
    public void setReviewsValor(String text) {
        lbReviewsValor.setText(text);
    }
    
    public void adicionarAcaoBotaoPerfil(ActionListener acao) {
        btnFotoPerfil.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoCadastrarAlbum(ActionListener acao){
        btnAdicionarAlbum.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAlbum_1(ActionListener acao) {
        btnAlbum_1.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAlbum_2(ActionListener acao) {
        btnAlbum_2.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAlbum_3(ActionListener acao) {
        btnAlbum_3.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAlbum_4(ActionListener acao) {
        btnAlbum_4.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAlbum_5(ActionListener acao) {
        btnAlbum_5.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAlbum_6(ActionListener acao) {
        btnAlbum_6.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoProximo(ActionListener acao) {
        btnProxima.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoAnterior(ActionListener acao) {
        btnAnterior.addActionListener(acao);
    }
    
    public void adicionarAcaoComboBox(ActionListener acao) {
        cbOrdenacao.addActionListener(acao);
    }
    
    public void adicionarAcaoVoltar(ActionListener acao) {
        btnVoltar.addActionListener(acao);
    }
    
    public List<Map> getComponentesAlbum() {
        return componentesAlbum;
    }
    
    public JButton getAlbum_1() {
        return btnAlbum_1;
    }
    
    public JButton getAlbum_2() {
        return btnAlbum_2;
    }
    
    public JButton getAlbum_3() {
        return btnAlbum_3;
    }
    
    public JButton getAlbum_4() {
        return btnAlbum_4;
    }
    
    public JButton getAlbum_5() {
        return btnAlbum_5;
    }
    
    public JButton getAlbum_6() {
        return btnAlbum_6;
    }
    
    public JLabel getNomeAlbum_1() {
        return lbNomeAlbum_1;
    }
    
    public JLabel getNomeAlbum_2() {
        return lbNomeAlbum_2;
    }
    
    public JLabel getNomeAlbum_3() {
        return lbNomeAlbum_3;
    }
    
    public JLabel getNomeAlbum_4() {
        return lbNomeAlbum_4;
    }
    
    public JLabel getNomeAlbum_5() {
        return lbNomeAlbum_5;
    }
    
    public JLabel getNomeAlbum_6() {
        return lbNomeAlbum_6;
    }
    
    public JLabel getScore_1() {
        return lbScore_1;
    }
    
    public JLabel getScore_2() {
        return lbScore_2;
    }
    
    public JLabel getScore_3() {
        return lbScore_3;
    }
    
    public JLabel getScore_4() {
        return lbScore_4;
    }
    
    public JLabel getScore_5() {
        return lbScore_5;
    }
    
    public JLabel getScore_6() {
        return lbScore_6;
    }
    
    public JLabel getAnoLancamento_1() {
        return lbAnoLancamento_1;
    }
    
    public JLabel getAnoLancamento_2() {
        return lbAnoLancamento_2;
    }
    
    public JLabel getAnoLancamento_3() {
        return lbAnoLancamento_3;
    }
    
    public JLabel getAnoLancamento_4() {
        return lbAnoLancamento_4;
    }
    
    public JLabel getAnoLancamento_5() {
        return lbAnoLancamento_5;
    }
    
    public JLabel getAnoLancamento_6() {
        return lbAnoLancamento_6;
    }
    
    public String getCbSelecionadoString() {
        return cbOrdenacao.getSelectedItem().toString();
    }
    
    public void setLbPagina(String text) {
        lbPagina.setText(text);
    }
    
    public JButton getBotaoAnterior() {
        return btnAnterior;
    }
    
    public JButton getBotaoProxima() {
        return btnProxima;
    }
    
    public void exibirBotaoAdicionarAlbum() {
        btnAdicionarAlbum.setVisible(true);
    }
    
    public void exbirTela() {
        setVisible(true);
    }
    
    public void fecharTela() {
        setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbExibindo = new javax.swing.JLabel();
        cbOrdenacao = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnFotoPerfil = new javax.swing.JButton();
        lbNomePerfil = new javax.swing.JLabel();
        lbUsernamePerfil = new javax.swing.JLabel();
        lbScoreLabel = new javax.swing.JLabel();
        lbScoreValor = new javax.swing.JLabel();
        lbReviewsLabel = new javax.swing.JLabel();
        lbReviewsValor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbScore_1 = new javax.swing.JLabel();
        lbAnoLancamento_1 = new javax.swing.JLabel();
        btnAlbum_1 = new javax.swing.JButton();
        lbNomeAlbum_1 = new javax.swing.JLabel();
        lbNomeAlbum_3 = new javax.swing.JLabel();
        lbScore_2 = new javax.swing.JLabel();
        lbScore_3 = new javax.swing.JLabel();
        lbAnoLancamento_2 = new javax.swing.JLabel();
        lbAnoLancamento_3 = new javax.swing.JLabel();
        btnAlbum_2 = new javax.swing.JButton();
        btnAlbum_3 = new javax.swing.JButton();
        lbNomeAlbum_2 = new javax.swing.JLabel();
        lbScore_4 = new javax.swing.JLabel();
        lbAnoLancamento_4 = new javax.swing.JLabel();
        btnAlbum_4 = new javax.swing.JButton();
        lbNomeAlbum_4 = new javax.swing.JLabel();
        lbNomeAlbum_5 = new javax.swing.JLabel();
        lbScore_5 = new javax.swing.JLabel();
        lbAnoLancamento_5 = new javax.swing.JLabel();
        btnAlbum_5 = new javax.swing.JButton();
        lbNomeAlbum_6 = new javax.swing.JLabel();
        lbScore_6 = new javax.swing.JLabel();
        lbAnoLancamento_6 = new javax.swing.JLabel();
        btnAlbum_6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnProxima = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnAdicionarAlbum = new javax.swing.JButton();
        lbPagina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbExibindo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbExibindo.setText("<EXIBINDO AGORA>");

        btnFotoPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFotoPerfil.setFocusable(false);
        btnFotoPerfil.setMaximumSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil.setMinimumSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil.setPreferredSize(new java.awt.Dimension(115, 115));

        lbNomePerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNomePerfil.setText("Nome");

        lbUsernamePerfil.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbUsernamePerfil.setText("@");

        lbScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbScoreLabel.setText("Score");

        lbScoreValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbScoreValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbScoreValor.setText("Score");

        lbReviewsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReviewsLabel.setText("Reviews");

        lbReviewsValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReviewsValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbReviewsValor.setText("Reviews");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbReviewsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbReviewsValor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(lbScoreValor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbUsernamePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNomePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbNomePerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUsernamePerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbScoreLabel)
                            .addComponent(lbScoreValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbReviewsLabel)
                            .addComponent(lbReviewsValor))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(413, 425));
        jPanel2.setMinimumSize(new java.awt.Dimension(413, 425));

        lbScore_1.setText("lbScore_1");
        lbScore_1.setToolTipText("");

        lbAnoLancamento_1.setText("lbAnoLancamento_1");

        btnAlbum_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_1.setFocusable(false);
        btnAlbum_1.setMargin(null);
        btnAlbum_1.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_1.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_1.setName("btnAlbum_1"); // NOI18N
        btnAlbum_1.setPreferredSize(new java.awt.Dimension(115, 115));

        lbNomeAlbum_1.setText("lbNomeAlbum_1");

        lbNomeAlbum_3.setText("lbNomeAlbum_3");

        lbScore_2.setText("lbScore_2");

        lbScore_3.setText("lbScore_3");

        lbAnoLancamento_2.setText("lbAnoLancamento_2");

        lbAnoLancamento_3.setText("lbAnoLancamento_3");

        btnAlbum_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_2.setFocusable(false);
        btnAlbum_2.setMargin(null);
        btnAlbum_2.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_2.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_2.setName("btnAlbum_2"); // NOI18N
        btnAlbum_2.setPreferredSize(new java.awt.Dimension(115, 115));

        btnAlbum_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_3.setFocusable(false);
        btnAlbum_3.setMargin(null);
        btnAlbum_3.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_3.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_3.setName("btnAlbum_3"); // NOI18N
        btnAlbum_3.setPreferredSize(new java.awt.Dimension(115, 115));

        lbNomeAlbum_2.setText("lbNomeAlbum_2");

        lbScore_4.setText("lbScore_4");

        lbAnoLancamento_4.setText("lbAnoLancamento_4");

        btnAlbum_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_4.setFocusable(false);
        btnAlbum_4.setMargin(null);
        btnAlbum_4.setMaximumSize(new java.awt.Dimension(115, 115));
        btnAlbum_4.setMinimumSize(new java.awt.Dimension(115, 115));
        btnAlbum_4.setName("btnAlbum_4"); // NOI18N
        btnAlbum_4.setPreferredSize(new java.awt.Dimension(80, 80));

        lbNomeAlbum_4.setText("lbNomeAlbum_4");

        lbNomeAlbum_5.setText("lbNomeAlbum_5");

        lbScore_5.setText("lbScore_5");

        lbAnoLancamento_5.setText("lbAnoLancamento_5");

        btnAlbum_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_5.setFocusable(false);
        btnAlbum_5.setMargin(null);
        btnAlbum_5.setMaximumSize(new java.awt.Dimension(115, 115));
        btnAlbum_5.setMinimumSize(new java.awt.Dimension(115, 115));
        btnAlbum_5.setName("btnAlbum_5"); // NOI18N
        btnAlbum_5.setPreferredSize(new java.awt.Dimension(80, 80));

        lbNomeAlbum_6.setText("lbNomeAlbum_6");

        lbScore_6.setText("lbScore_6");

        lbAnoLancamento_6.setText("lbAnoLancamento_6");

        btnAlbum_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_6.setFocusable(false);
        btnAlbum_6.setMargin(null);
        btnAlbum_6.setMaximumSize(new java.awt.Dimension(115, 115));
        btnAlbum_6.setMinimumSize(new java.awt.Dimension(115, 115));
        btnAlbum_6.setName("btnAlbum_6"); // NOI18N
        btnAlbum_6.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlbum_4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbScore_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAnoLancamento_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbScore_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAnoLancamento_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbScore_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbScore_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAnoLancamento_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAnoLancamento_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbScore_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlbum_3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addComponent(btnAlbum_6, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addComponent(lbNomeAlbum_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbScore_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAnoLancamento_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAnoLancamento_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbNomeAlbum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlbum_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlbum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lbScore_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlbum_1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNomeAlbum_1)
                            .addComponent(lbNomeAlbum_2)
                            .addComponent(lbNomeAlbum_3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbScore_1)
                            .addComponent(lbScore_2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAnoLancamento_1)
                            .addComponent(lbAnoLancamento_2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlbum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbScore_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlbum_4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlbum_5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbScore_5)
                            .addComponent(lbScore_4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAnoLancamento_5)
                            .addComponent(lbAnoLancamento_4))))
                .addGap(70, 70, 70))
        );

        btnVoltar.setText("Voltar");

        btnProxima.setText("Próxima");
        btnProxima.setEnabled(false);

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);

        btnAdicionarAlbum.setText("+ Adicionar Álbum");

        lbPagina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPagina.setText("---");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionarAlbum)
                .addGap(68, 68, 68))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProxima))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(lbPagina)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarAlbum)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPagina)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbExibindo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbExibindo)
                    .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAlbum;
    private javax.swing.JButton btnAlbum_1;
    private javax.swing.JButton btnAlbum_2;
    private javax.swing.JButton btnAlbum_3;
    private javax.swing.JButton btnAlbum_4;
    private javax.swing.JButton btnAlbum_5;
    private javax.swing.JButton btnAlbum_6;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFotoPerfil;
    private javax.swing.JButton btnProxima;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbOrdenacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbAnoLancamento_1;
    private javax.swing.JLabel lbAnoLancamento_2;
    private javax.swing.JLabel lbAnoLancamento_3;
    private javax.swing.JLabel lbAnoLancamento_4;
    private javax.swing.JLabel lbAnoLancamento_5;
    private javax.swing.JLabel lbAnoLancamento_6;
    private javax.swing.JLabel lbExibindo;
    private javax.swing.JLabel lbNomeAlbum_1;
    private javax.swing.JLabel lbNomeAlbum_2;
    private javax.swing.JLabel lbNomeAlbum_3;
    private javax.swing.JLabel lbNomeAlbum_4;
    private javax.swing.JLabel lbNomeAlbum_5;
    private javax.swing.JLabel lbNomeAlbum_6;
    private javax.swing.JLabel lbNomePerfil;
    private javax.swing.JLabel lbPagina;
    private javax.swing.JLabel lbReviewsLabel;
    private javax.swing.JLabel lbReviewsValor;
    private javax.swing.JLabel lbScoreLabel;
    private javax.swing.JLabel lbScoreValor;
    private javax.swing.JLabel lbScore_1;
    private javax.swing.JLabel lbScore_2;
    private javax.swing.JLabel lbScore_3;
    private javax.swing.JLabel lbScore_4;
    private javax.swing.JLabel lbScore_5;
    private javax.swing.JLabel lbScore_6;
    private javax.swing.JLabel lbUsernamePerfil;
    // End of variables declaration//GEN-END:variables

}
