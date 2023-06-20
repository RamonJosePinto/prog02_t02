/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class TelaPerfil extends javax.swing.JFrame {

    /**
     * Creates new form TelaPerfil
     */
    public TelaPerfil() {
        initComponents();
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

        btnFotoPerfil2 = new javax.swing.JButton();
        lbUsernamePerfil = new javax.swing.JLabel();
        lbNomePerfil = new javax.swing.JLabel();
        lbScoreLabel = new javax.swing.JLabel();
        lbReviewsLabel = new javax.swing.JLabel();
        lbScoreValor = new javax.swing.JLabel();
        lbReviewsValor = new javax.swing.JLabel();
        lbNomeAlbum_2 = new javax.swing.JLabel();
        lbNomeAlbum_3 = new javax.swing.JLabel();
        lbScore_1 = new javax.swing.JLabel();
        lbScore_2 = new javax.swing.JLabel();
        lbScore_3 = new javax.swing.JLabel();
        lbAnoLancamento_1 = new javax.swing.JLabel();
        lbAnoLancamento_2 = new javax.swing.JLabel();
        lbAnoLancamento_3 = new javax.swing.JLabel();
        btnAlbum_1 = new javax.swing.JButton();
        btnAlbum_2 = new javax.swing.JButton();
        btnAlbum_3 = new javax.swing.JButton();
        lbNomeAlbum_1 = new javax.swing.JLabel();
        lbNomeAlbum_4 = new javax.swing.JLabel();
        btnProxima = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        lbNomeAlbum_5 = new javax.swing.JLabel();
        lbNomeAlbum_6 = new javax.swing.JLabel();
        lbScore_4 = new javax.swing.JLabel();
        lbScore_5 = new javax.swing.JLabel();
        lbScore_6 = new javax.swing.JLabel();
        lbAnoLancamento_4 = new javax.swing.JLabel();
        lbAnoLancamento_5 = new javax.swing.JLabel();
        lbAnoLancamento_6 = new javax.swing.JLabel();
        btnAlbum_4 = new javax.swing.JButton();
        btnAlbum_5 = new javax.swing.JButton();
        btnAlbum_6 = new javax.swing.JButton();
        btnAdicionarAlbum = new javax.swing.JButton();
        lbPagina = new javax.swing.JLabel();
        lbExibindo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        cbOrdenacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFotoPerfil2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFotoPerfil2.setFocusable(false);
        btnFotoPerfil2.setMaximumSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil2.setMinimumSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil2.setPreferredSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoPerfil2ActionPerformed(evt);
            }
        });

        lbUsernamePerfil.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbUsernamePerfil.setText("@");

        lbNomePerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNomePerfil.setText("Nome");

        lbScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbScoreLabel.setText("Score");

        lbReviewsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReviewsLabel.setText("Reviews");

        lbScoreValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbScoreValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbScoreValor.setText("Score");

        lbReviewsValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReviewsValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbReviewsValor.setText("Reviews");

        lbNomeAlbum_2.setText("lbNomeAlbum_2");

        lbNomeAlbum_3.setText("lbNomeAlbum_3");

        lbScore_1.setText("lbScore_1");
        lbScore_1.setToolTipText("");

        lbScore_2.setText("lbScore_2");

        lbScore_3.setText("lbScore_3");

        lbAnoLancamento_1.setText("lbAnoLancamento_1");

        lbAnoLancamento_2.setText("lbAnoLancamento_2");

        lbAnoLancamento_3.setText("lbAnoLancamento_3");

        btnAlbum_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_1.setFocusable(false);
        btnAlbum_1.setMargin(null);
        btnAlbum_1.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_1.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_1.setName("btnAlbum_1"); // NOI18N
        btnAlbum_1.setPreferredSize(new java.awt.Dimension(115, 115));
        btnAlbum_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbum_1ActionPerformed(evt);
            }
        });

        btnAlbum_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_2.setFocusable(false);
        btnAlbum_2.setMargin(null);
        btnAlbum_2.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_2.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_2.setName("btnAlbum_2"); // NOI18N
        btnAlbum_2.setPreferredSize(new java.awt.Dimension(115, 115));
        btnAlbum_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbum_2ActionPerformed(evt);
            }
        });

        btnAlbum_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_3.setFocusable(false);
        btnAlbum_3.setMargin(null);
        btnAlbum_3.setMaximumSize(new java.awt.Dimension(80, 80));
        btnAlbum_3.setMinimumSize(new java.awt.Dimension(80, 80));
        btnAlbum_3.setName("btnAlbum_3"); // NOI18N
        btnAlbum_3.setPreferredSize(new java.awt.Dimension(115, 115));
        btnAlbum_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbum_3ActionPerformed(evt);
            }
        });

        lbNomeAlbum_1.setText("lbNomeAlbum_1");

        lbNomeAlbum_4.setText("lbNomeAlbum_4");

        btnProxima.setText("Próxima");
        btnProxima.setEnabled(false);
        btnProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        lbNomeAlbum_5.setText("lbNomeAlbum_5");

        lbNomeAlbum_6.setText("lbNomeAlbum_6");

        lbScore_4.setText("lbScore_4");

        lbScore_5.setText("lbScore_5");

        lbScore_6.setText("lbScore_6");

        lbAnoLancamento_4.setText("lbAnoLancamento_4");

        lbAnoLancamento_5.setText("lbAnoLancamento_5");

        lbAnoLancamento_6.setText("lbAnoLancamento_6");

        btnAlbum_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_4.setFocusable(false);
        btnAlbum_4.setMargin(null);
        btnAlbum_4.setMaximumSize(new java.awt.Dimension(115, 115));
        btnAlbum_4.setMinimumSize(new java.awt.Dimension(115, 115));
        btnAlbum_4.setName("btnAlbum_4"); // NOI18N
        btnAlbum_4.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlbum_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbum_4ActionPerformed(evt);
            }
        });

        btnAlbum_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_5.setFocusable(false);
        btnAlbum_5.setMargin(null);
        btnAlbum_5.setMaximumSize(new java.awt.Dimension(115, 115));
        btnAlbum_5.setMinimumSize(new java.awt.Dimension(115, 115));
        btnAlbum_5.setName("btnAlbum_5"); // NOI18N
        btnAlbum_5.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlbum_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbum_5ActionPerformed(evt);
            }
        });

        btnAlbum_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAlbum_6.setFocusable(false);
        btnAlbum_6.setMargin(null);
        btnAlbum_6.setMaximumSize(new java.awt.Dimension(115, 115));
        btnAlbum_6.setMinimumSize(new java.awt.Dimension(115, 115));
        btnAlbum_6.setName("btnAlbum_6"); // NOI18N
        btnAlbum_6.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlbum_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlbum_6ActionPerformed(evt);
            }
        });

        btnAdicionarAlbum.setText("+ Adicionar Álbum");
        btnAdicionarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAlbumActionPerformed(evt);
            }
        });

        lbPagina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPagina.setText("---");

        lbExibindo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbExibindo.setText("<EXIBINDO AGORA>");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        cbOrdenacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbReviewsValor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbScoreValor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbExibindo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFotoPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbReviewsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNomePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbUsernamePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbNomeAlbum_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbScore_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbAnoLancamento_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnAlbum_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbScore_4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbAnoLancamento_4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbScore_5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbAnoLancamento_5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbNomeAlbum_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbScore_2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbAnoLancamento_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbScore_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeAlbum_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAlbum_6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbAnoLancamento_6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbAnoLancamento_3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lbScore_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAlbum_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbNomeAlbum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnAnterior)
                        .addGap(0, 0, 0)
                        .addComponent(lbPagina))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnProxima)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionarAlbum)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lbNomePerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUsernamePerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbScoreLabel)
                            .addComponent(lbScoreValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbReviewsLabel)
                            .addComponent(lbReviewsValor)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnFotoPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbExibindo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAlbum_1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNomeAlbum_1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbScore_1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbAnoLancamento_1)
                            .addGap(31, 31, 31)
                            .addComponent(btnAlbum_4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNomeAlbum_4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbScore_4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbAnoLancamento_4))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAlbum_2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNomeAlbum_2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbScore_2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbAnoLancamento_2)
                            .addGap(31, 31, 31)
                            .addComponent(btnAlbum_5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbNomeAlbum_5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbScore_5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbAnoLancamento_5)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlbum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbScore_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_3)
                        .addGap(31, 31, 31)
                        .addComponent(btnAlbum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNomeAlbum_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbScore_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnoLancamento_6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarAlbum)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPagina)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotoPerfil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoPerfil2ActionPerformed

    }//GEN-LAST:event_btnFotoPerfil2ActionPerformed

    private void btnAlbum_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbum_1ActionPerformed

    }//GEN-LAST:event_btnAlbum_1ActionPerformed

    private void btnAlbum_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbum_2ActionPerformed

    }//GEN-LAST:event_btnAlbum_2ActionPerformed

    private void btnAlbum_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbum_3ActionPerformed

    }//GEN-LAST:event_btnAlbum_3ActionPerformed

    private void btnProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaActionPerformed

    }//GEN-LAST:event_btnProximaActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed

    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnAlbum_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbum_4ActionPerformed

    }//GEN-LAST:event_btnAlbum_4ActionPerformed

    private void btnAlbum_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbum_5ActionPerformed

    }//GEN-LAST:event_btnAlbum_5ActionPerformed

    private void btnAlbum_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlbum_6ActionPerformed

    }//GEN-LAST:event_btnAlbum_6ActionPerformed

    private void btnAdicionarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAlbumActionPerformed

    }//GEN-LAST:event_btnAdicionarAlbumActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void cbOrdenacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenacaoActionPerformed

    }//GEN-LAST:event_cbOrdenacaoActionPerformed

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
    private javax.swing.JButton btnFotoPerfil1;
    private javax.swing.JButton btnFotoPerfil2;
    private javax.swing.JButton btnProxima;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbOrdenacao;
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
