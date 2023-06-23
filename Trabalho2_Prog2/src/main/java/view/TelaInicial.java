/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

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
        btnAlbum_1 = new javax.swing.JButton();
        btnAlbum_2 = new javax.swing.JButton();
        btnAlbum_3 = new javax.swing.JButton();
        lbNomeAlbum_1 = new javax.swing.JLabel();
        lbNomeAlbum_2 = new javax.swing.JLabel();
        lbNomeAlbum_3 = new javax.swing.JLabel();
        lbNomeArtista_1 = new javax.swing.JLabel();
        lbNomeArtista_2 = new javax.swing.JLabel();
        lbNomeArtista_3 = new javax.swing.JLabel();
        lbAnoLancamento_1 = new javax.swing.JLabel();
        lbAnoLancamento_2 = new javax.swing.JLabel();
        lbAnoLancamento_3 = new javax.swing.JLabel();
        lbNomeAlbum_5 = new javax.swing.JLabel();
        lbNomeAlbum_6 = new javax.swing.JLabel();
        lbNomeArtista_4 = new javax.swing.JLabel();
        lbNomeArtista_5 = new javax.swing.JLabel();
        lbNomeArtista_6 = new javax.swing.JLabel();
        lbAnoLancamento_4 = new javax.swing.JLabel();
        lbAnoLancamento_5 = new javax.swing.JLabel();
        lbAnoLancamento_6 = new javax.swing.JLabel();
        btnAlbum_4 = new javax.swing.JButton();
        btnAlbum_5 = new javax.swing.JButton();
        btnAlbum_6 = new javax.swing.JButton();
        lbNomeAlbum_4 = new javax.swing.JLabel();
        btnProxima = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        lbPagina = new javax.swing.JLabel();

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

        btnAlbum_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_1.setFocusable(false);
        btnAlbum_1.setMargin(null);
        btnAlbum_1.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_1.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_1.setPreferredSize(new java.awt.Dimension(80, 80));

        btnAlbum_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_2.setFocusable(false);
        btnAlbum_2.setMargin(null);
        btnAlbum_2.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_2.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_2.setPreferredSize(new java.awt.Dimension(80, 80));

        btnAlbum_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_3.setFocusable(false);
        btnAlbum_3.setMargin(null);
        btnAlbum_3.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_3.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_3.setPreferredSize(new java.awt.Dimension(80, 80));

        lbNomeAlbum_1.setText("lbNomeAlbum_1");

        lbNomeAlbum_2.setText("lbNomeAlbum_2");

        lbNomeAlbum_3.setText("lbNomeAlbum_3");

        lbNomeArtista_1.setText("lbNomeArtista_1");

        lbNomeArtista_2.setText("lbNomeArtista_2");

        lbNomeArtista_3.setText("lbNomeArtista_3");

        lbAnoLancamento_1.setText("lbAnoLancamento_1");

        lbAnoLancamento_2.setText("lbAnoLancamento_2");

        lbAnoLancamento_3.setText("lbAnoLancamento_3");

        lbNomeAlbum_5.setText("lbNomeAlbum_5");

        lbNomeAlbum_6.setText("lbNomeAlbum_6");

        lbNomeArtista_4.setText("lbNomeArtista_4");

        lbNomeArtista_5.setText("lbNomeArtista_5");

        lbNomeArtista_6.setText("lbNomeArtista_6");

        lbAnoLancamento_4.setText("lbAnoLancamento_4");

        lbAnoLancamento_5.setText("lbAnoLancamento_5");

        lbAnoLancamento_6.setText("lbAnoLancamento_6");

        btnAlbum_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_4.setFocusable(false);
        btnAlbum_4.setMargin(null);
        btnAlbum_4.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_4.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_4.setPreferredSize(new java.awt.Dimension(80, 80));

        btnAlbum_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_5.setFocusable(false);
        btnAlbum_5.setMargin(null);
        btnAlbum_5.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_5.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_5.setPreferredSize(new java.awt.Dimension(80, 80));

        btnAlbum_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_6.setFocusable(false);
        btnAlbum_6.setMargin(null);
        btnAlbum_6.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_6.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_6.setPreferredSize(new java.awt.Dimension(80, 80));

        lbNomeAlbum_4.setText("lbNomeAlbum_4");

        btnProxima.setText("Próxima");
        btnProxima.setEnabled(false);

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);

        lbPagina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPagina.setText("---");

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
                                .addComponent(btnFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNomePessoaLogada, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeArtista_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAnoLancamento_4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeArtista_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAnoLancamento_1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeArtista_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAnoLancamento_5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeArtista_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAnoLancamento_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbNomeArtista_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAlbum_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAnoLancamento_6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbNomeArtista_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAlbum_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAnoLancamento_3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProxima))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(lbPagina)))
                .addGap(31, 31, 31))
            .addComponent(lbTituloAlbunsRecentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBemVindo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomePessoaLogada)))
                .addGap(32, 32, 32)
                .addComponent(lbTituloAlbunsRecentes)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlbum_1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeArtista_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_1)
                        .addGap(67, 67, 67)
                        .addComponent(btnAlbum_4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeArtista_4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlbum_2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeArtista_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_2)
                        .addGap(67, 67, 67)
                        .addComponent(btnAlbum_5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeArtista_5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlbum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeArtista_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_3)
                        .addGap(67, 67, 67)
                        .addComponent(btnAlbum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbNomeArtista_6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAnoLancamento_6))
                            .addComponent(lbNomeAlbum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPagina)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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
