/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Album;

/**
 *
 * @author Usuario
 */
public class TelaInicial extends javax.swing.JFrame {

    private List<Map> componentesAlbum = new ArrayList();
    
    public TelaInicial() {
        initComponents();
    }
    
    public void limparGridAlbuns() {
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
    
    public void /*List<Map>*/ prepararGridAlbuns() {
        // Preenche Map com JComponent 
        Map<String, JComponent> album_1 = new HashMap();
        album_1.put("btnAlbum", this.btnAlbum_1);
        album_1.put("lbNomeAlbum", this.lbNomeAlbum_1);
        album_1.put("lbNomeArtista", this.lbNomeArtista_1);
        album_1.put("lbAnoLancamento", this.lbAnoLancamento_1);

        Map<String, JComponent> album_2 = new HashMap();
        album_2.put("btnAlbum", this.btnAlbum_2);
        album_2.put("lbNomeAlbum", this.lbNomeAlbum_2);
        album_2.put("lbNomeArtista", this.lbNomeArtista_2);
        album_2.put("lbAnoLancamento", this.lbAnoLancamento_2);

        Map<String, JComponent> album_3 = new HashMap();
        album_3.put("btnAlbum", this.btnAlbum_3);
        album_3.put("lbNomeAlbum", this.lbNomeAlbum_3);
        album_3.put("lbNomeArtista", this.lbNomeArtista_3);
        album_3.put("lbAnoLancamento", this.lbAnoLancamento_3);

        Map<String, JComponent> album_4 = new HashMap();
        album_4.put("btnAlbum", this.btnAlbum_4);
        album_4.put("lbNomeAlbum", this.lbNomeAlbum_4);
        album_4.put("lbNomeArtista", this.lbNomeArtista_4);
        album_4.put("lbAnoLancamento", this.lbAnoLancamento_4);

        Map<String, JComponent> album_5 = new HashMap();
        album_5.put("btnAlbum", this.btnAlbum_5);
        album_5.put("lbNomeAlbum", this.lbNomeAlbum_5);
        album_5.put("lbNomeArtista", this.lbNomeArtista_5);
        album_5.put("lbAnoLancamento", this.lbAnoLancamento_5);

        Map<String, JComponent> album_6 = new HashMap();
        album_6.put("btnAlbum", this.btnAlbum_6);
        album_6.put("lbNomeAlbum", this.lbNomeAlbum_6);
        album_6.put("lbNomeArtista", this.lbNomeArtista_6);
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
            JLabel lbNomeArtista = (JLabel) componente.get("lbNomeArtista");
            JLabel lbAnoLancamento = (JLabel) componente.get("lbAnoLancamento");

            btnAlbum.setVisible(true);
            lbNomeAlbum.setVisible(true);
            lbNomeArtista.setVisible(true);
            lbAnoLancamento.setVisible(true);

            lbNomeAlbum.setText(album.getTitulo());
            lbNomeArtista.setText(album.getArtista().getNome());
            lbAnoLancamento.setText(Integer.toString(album.getAnoLancamento()));
            
            try {
                btnAlbum.setIcon(new ImageIcon(imagensGrid.get(album.getIdAlbum())));
            } catch(NullPointerException ex) {
                System.out.println(ex.getMessage());
                btnAlbum.setIcon(null);
                btnAlbum.setText(album.getTitulo());
            }
            
            albunsCarregados++;
        }
    }
    
    public void atualizarImagemPerfil(Image imagem) {
        btnFotoPerfil.setIcon(new ImageIcon(imagem));
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public List<Map> getComponentesAlbum() {
        return componentesAlbum;
    }
    
    public String getNomeAlbum_1() {
        return this.lbNomeAlbum_1.getText();
    }
    
    public String getNomeAlbum_2() {
        return this.lbNomeAlbum_2.getText();
    }
    
    public String getNomeAlbum_3() {
        return this.lbNomeAlbum_3.getText();
    }
    
    public String getNomeAlbum_4() {
        return this.lbNomeAlbum_4.getText();
    }
    
    public String getNomeAlbum_5() {
        return this.lbNomeAlbum_5.getText();
    }
    
    public String getNomeAlbum_6() {
        return this.lbNomeAlbum_6.getText();
    }
    
    public void adicionarAcaoFotoPerfil(ActionListener acao) {
        btnFotoPerfil.addActionListener(acao);
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
    
    public void setNomePessoaLogada(String nome) {
        lbNomePessoaLogada.setText(nome);
    }
    
    public JButton getBotaoAnterior() {
        return btnAnterior;
    }
    
    public JButton getBotaoProxima() {
        return btnProxima;
    }
    
    public void setLbPagina(String text) {
        lbPagina.setText(text);
    }
    
    public void exibirTela() {
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

        lbBemVindo = new javax.swing.JLabel();
        lbNomePessoaLogada = new javax.swing.JLabel();
        btnFotoPerfil = new javax.swing.JButton();
        lbTituloAlbunsRecentes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbAnoLancamento_6 = new javax.swing.JLabel();
        lbNomeArtista_5 = new javax.swing.JLabel();
        lbNomeArtista_3 = new javax.swing.JLabel();
        btnAlbum_2 = new javax.swing.JButton();
        btnAlbum_6 = new javax.swing.JButton();
        lbNomeAlbum_4 = new javax.swing.JLabel();
        lbNomeAlbum_1 = new javax.swing.JLabel();
        btnAlbum_3 = new javax.swing.JButton();
        lbNomeArtista_1 = new javax.swing.JLabel();
        lbNomeArtista_4 = new javax.swing.JLabel();
        lbAnoLancamento_2 = new javax.swing.JLabel();
        lbAnoLancamento_1 = new javax.swing.JLabel();
        btnAlbum_4 = new javax.swing.JButton();
        lbNomeAlbum_3 = new javax.swing.JLabel();
        btnAlbum_5 = new javax.swing.JButton();
        lbAnoLancamento_4 = new javax.swing.JLabel();
        lbNomeArtista_6 = new javax.swing.JLabel();
        lbAnoLancamento_3 = new javax.swing.JLabel();
        lbNomeAlbum_2 = new javax.swing.JLabel();
        lbAnoLancamento_5 = new javax.swing.JLabel();
        lbNomeAlbum_5 = new javax.swing.JLabel();
        lbNomeArtista_2 = new javax.swing.JLabel();
        lbNomeAlbum_6 = new javax.swing.JLabel();
        btnAlbum_1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        lbPagina = new javax.swing.JLabel();
        btnProxima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbBemVindo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbBemVindo.setText("Bem vindo");

        lbNomePessoaLogada.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbNomePessoaLogada.setText("Nome");

        btnFotoPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFotoPerfil.setFocusable(false);
        btnFotoPerfil.setMargin(null);
        btnFotoPerfil.setMaximumSize(new java.awt.Dimension(80, 80));
        btnFotoPerfil.setMinimumSize(new java.awt.Dimension(80, 80));
        btnFotoPerfil.setPreferredSize(new java.awt.Dimension(80, 80));

        lbTituloAlbunsRecentes.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbTituloAlbunsRecentes.setText("Álbuns mais recentes");

        lbAnoLancamento_6.setText("lbAnoLancamento_6");

        lbNomeArtista_5.setText("lbNomeArtista_5");

        lbNomeArtista_3.setText("lbNomeArtista_3");

        btnAlbum_2.setAlignmentY(0.0F);
        btnAlbum_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_2.setFocusable(false);
        btnAlbum_2.setIconTextGap(0);
        btnAlbum_2.setMargin(null);
        btnAlbum_2.setMaximumSize(new java.awt.Dimension(125, 125));
        btnAlbum_2.setMinimumSize(new java.awt.Dimension(125, 125));
        btnAlbum_2.setPreferredSize(new java.awt.Dimension(125, 125));

        btnAlbum_6.setAlignmentY(0.0F);
        btnAlbum_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_6.setFocusable(false);
        btnAlbum_6.setIconTextGap(0);
        btnAlbum_6.setMargin(null);
        btnAlbum_6.setMaximumSize(new java.awt.Dimension(125, 125));
        btnAlbum_6.setMinimumSize(new java.awt.Dimension(125, 125));
        btnAlbum_6.setPreferredSize(new java.awt.Dimension(125, 125));

        lbNomeAlbum_4.setText("lbNomeAlbum_4");

        lbNomeAlbum_1.setText("lbNomeAlbum_1");

        btnAlbum_3.setAlignmentY(0.0F);
        btnAlbum_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_3.setFocusable(false);
        btnAlbum_3.setIconTextGap(0);
        btnAlbum_3.setMargin(null);
        btnAlbum_3.setMaximumSize(new java.awt.Dimension(125, 125));
        btnAlbum_3.setMinimumSize(new java.awt.Dimension(125, 125));
        btnAlbum_3.setPreferredSize(new java.awt.Dimension(125, 125));

        lbNomeArtista_1.setText("lbNomeArtista_1");

        lbNomeArtista_4.setText("lbNomeArtista_4");

        lbAnoLancamento_2.setText("lbAnoLancamento_2");

        lbAnoLancamento_1.setText("lbAnoLancamento_1");

        btnAlbum_4.setAlignmentY(0.0F);
        btnAlbum_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_4.setFocusable(false);
        btnAlbum_4.setIconTextGap(0);
        btnAlbum_4.setMargin(null);
        btnAlbum_4.setMaximumSize(new java.awt.Dimension(125, 125));
        btnAlbum_4.setMinimumSize(new java.awt.Dimension(125, 125));
        btnAlbum_4.setPreferredSize(new java.awt.Dimension(125, 125));

        lbNomeAlbum_3.setText("lbNomeAlbum_3");

        btnAlbum_5.setAlignmentY(0.0F);
        btnAlbum_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_5.setFocusable(false);
        btnAlbum_5.setIconTextGap(0);
        btnAlbum_5.setMargin(null);
        btnAlbum_5.setMaximumSize(new java.awt.Dimension(125, 125));
        btnAlbum_5.setMinimumSize(new java.awt.Dimension(125, 125));
        btnAlbum_5.setPreferredSize(new java.awt.Dimension(125, 125));

        lbAnoLancamento_4.setText("lbAnoLancamento_4");

        lbNomeArtista_6.setText("lbNomeArtista_6");

        lbAnoLancamento_3.setText("lbAnoLancamento_3");

        lbNomeAlbum_2.setText("lbNomeAlbum_2");

        lbAnoLancamento_5.setText("lbAnoLancamento_5");

        lbNomeAlbum_5.setText("lbNomeAlbum_5");

        lbNomeArtista_2.setText("lbNomeArtista_2");

        lbNomeAlbum_6.setText("lbNomeAlbum_6");

        btnAlbum_1.setAlignmentY(0.0F);
        btnAlbum_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_1.setFocusable(false);
        btnAlbum_1.setIconTextGap(0);
        btnAlbum_1.setMargin(null);
        btnAlbum_1.setMaximumSize(new java.awt.Dimension(125, 125));
        btnAlbum_1.setMinimumSize(new java.awt.Dimension(125, 125));
        btnAlbum_1.setPreferredSize(new java.awt.Dimension(125, 125));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeArtista_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNomeAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNomeArtista_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAnoLancamento_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbAnoLancamento_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeArtista_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNomeAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNomeArtista_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAnoLancamento_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbAnoLancamento_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlbum_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeAlbum_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNomeArtista_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbNomeArtista_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNomeAlbum_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlbum_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAnoLancamento_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbAnoLancamento_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAlbum_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeAlbum_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeArtista_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAnoLancamento_2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAlbum_1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeAlbum_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeArtista_1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAnoLancamento_1)
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAlbum_5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAlbum_4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbNomeAlbum_4)
                                            .addComponent(lbNomeAlbum_5)
                                            .addComponent(lbNomeAlbum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnAlbum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNomeArtista_5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbNomeArtista_4)
                                        .addComponent(lbNomeArtista_6)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAnoLancamento_4)
                            .addComponent(lbAnoLancamento_5)
                            .addComponent(lbAnoLancamento_6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAlbum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeArtista_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);

        lbPagina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPagina.setText("---");

        btnProxima.setText("Próxima");
        btnProxima.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProxima))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lbPagina)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPagina)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNomePessoaLogada, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbTituloAlbunsRecentes, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBemVindo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomePessoaLogada)))
                .addGap(33, 33, 33)
                .addComponent(lbTituloAlbunsRecentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlbum_1;
    private javax.swing.JButton btnAlbum_2;
    private javax.swing.JButton btnAlbum_3;
    private javax.swing.JButton btnAlbum_4;
    private javax.swing.JButton btnAlbum_5;
    private javax.swing.JButton btnAlbum_6;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFotoPerfil;
    private javax.swing.JButton btnProxima;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbAnoLancamento_1;
    private javax.swing.JLabel lbAnoLancamento_2;
    private javax.swing.JLabel lbAnoLancamento_3;
    private javax.swing.JLabel lbAnoLancamento_4;
    private javax.swing.JLabel lbAnoLancamento_5;
    private javax.swing.JLabel lbAnoLancamento_6;
    private javax.swing.JLabel lbBemVindo;
    private javax.swing.JLabel lbNomeAlbum_1;
    private javax.swing.JLabel lbNomeAlbum_2;
    private javax.swing.JLabel lbNomeAlbum_3;
    private javax.swing.JLabel lbNomeAlbum_4;
    private javax.swing.JLabel lbNomeAlbum_5;
    private javax.swing.JLabel lbNomeAlbum_6;
    private javax.swing.JLabel lbNomeArtista_1;
    private javax.swing.JLabel lbNomeArtista_2;
    private javax.swing.JLabel lbNomeArtista_3;
    private javax.swing.JLabel lbNomeArtista_4;
    private javax.swing.JLabel lbNomeArtista_5;
    private javax.swing.JLabel lbNomeArtista_6;
    private javax.swing.JLabel lbNomePessoaLogada;
    private javax.swing.JLabel lbPagina;
    private javax.swing.JLabel lbTituloAlbunsRecentes;
    // End of variables declaration//GEN-END:variables
}
