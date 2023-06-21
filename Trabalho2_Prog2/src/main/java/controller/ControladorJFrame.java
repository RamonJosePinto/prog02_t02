/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class ControladorJFrame {
    private JFrame telaAnterior;

    public ControladorJFrame(JFrame telaAnterior) {
        this.telaAnterior = telaAnterior;
    }
    
    public void ExibirTela(){
        telaAnterior.setVisible(true);
    }

}
