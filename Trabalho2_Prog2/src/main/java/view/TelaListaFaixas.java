/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class TelaListaFaixas extends javax.swing.JFrame {

    /**
     * Creates new form TelaListaFaixas
     */
    public TelaListaFaixas() {
        initComponents();
    }
    
    public JButton getBotaoFazerReview(){
        return btnFazerReview;
    }
    
    public void setNomeAlbum(String nome){
        lbNomeAlbum.setText(nome);
    }
    public void setNomeArtista(String nome){
         lbArtistaNome.setText(nome);
    }
    public void setFaixasArea(String text){
        txtFaixasArea.setText(text);
    }
    public void setScoreAlbum(String text){
         lbScore.setText(text);
    }
    public void setValorAlbum(String text){
         lbReviewsValor.setText(text);
    }
    public void adicionarAcaoBotaoVoltar(ActionListener acao){
        btnVoltar.addActionListener(acao);
    }
    public void adicionarAcaoBotaoVerReviews(ActionListener acao){
        btnVerReviews1.addActionListener(acao);
    }
    public void adicionarAcaoBotaoFazerReviews(ActionListener acao){
        btnFazerReview.addActionListener(acao);
    }
     public void exibirTela(){
        setVisible(true);
    }
      public void fecharTela(){
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

        btnFotoPerfil1 = new javax.swing.JButton();
        lbNomeAlbum = new javax.swing.JLabel();
        lbArtistaNome = new javax.swing.JLabel();
        lbScore = new javax.swing.JLabel();
        lbScoreValor = new javax.swing.JLabel();
        lbReviewsLabel = new javax.swing.JLabel();
        lbReviewsValor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFaixasArea = new javax.swing.JTextArea();
        btnVoltar = new javax.swing.JButton();
        btnFazerReview = new javax.swing.JButton();
        btnVerReviews1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFotoPerfil1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFotoPerfil1.setFocusable(false);
        btnFotoPerfil1.setMaximumSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil1.setMinimumSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil1.setPreferredSize(new java.awt.Dimension(115, 115));
        btnFotoPerfil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoPerfil1ActionPerformed(evt);
            }
        });

        lbNomeAlbum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNomeAlbum.setText("Nome alb");

        lbArtistaNome.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbArtistaNome.setText("Nome art");

        lbScore.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbScore.setText("Score");

        lbScoreValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbScoreValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbScoreValor.setText("Score");

        lbReviewsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReviewsLabel.setText("Reviews");

        lbReviewsValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReviewsValor.setText("Reviews");

        txtFaixasArea.setColumns(20);
        txtFaixasArea.setRows(5);
        jScrollPane1.setViewportView(txtFaixasArea);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnFazerReview.setText("Fazer Review");
        btnFazerReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazerReviewActionPerformed(evt);
            }
        });

        btnVerReviews1.setText("Outras Reviews");
        btnVerReviews1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReviews1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFotoPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNomeAlbum)
                                    .addComponent(lbArtistaNome))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbReviewsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbReviewsValor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbScoreValor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbScore)))
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerReviews1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btnFazerReview, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnFotoPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lbNomeAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbArtistaNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbScoreValor)
                            .addComponent(lbScore))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbReviewsLabel)
                            .addComponent(lbReviewsValor))))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerReviews1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFazerReview, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotoPerfil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoPerfil1ActionPerformed

    }//GEN-LAST:event_btnFotoPerfil1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
//        this.setVisible(false);
//        janelaAnterior.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnFazerReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazerReviewActionPerformed
//        TelaCadastroReview telaCadastroReview = new TelaCadastroReview(alb, this);
//        telaCadastroReview.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_btnFazerReviewActionPerformed

    private void btnVerReviews1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReviews1ActionPerformed
//        TelaReviews telaReviews = new TelaReviews(alb, this);
//        telaReviews.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_btnVerReviews1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListaFaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListaFaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListaFaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListaFaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListaFaixas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFazerReview;
    private javax.swing.JButton btnFotoPerfil1;
    private javax.swing.JButton btnVerReviews1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbArtistaNome;
    private javax.swing.JLabel lbNomeAlbum;
    private javax.swing.JLabel lbReviewsLabel;
    private javax.swing.JLabel lbReviewsValor;
    private javax.swing.JLabel lbScore;
    private javax.swing.JLabel lbScoreValor;
    private javax.swing.JTextArea txtFaixasArea;
    // End of variables declaration//GEN-END:variables
}
