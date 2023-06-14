/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.TelaInicial;

/**
 *
 * @author Usuario
 */
public class ControladorTelaInicial {
    private TelaInicial telaInicial;
    
    public ControladorTelaInicial(TelaInicial telaInicial){
        this.telaInicial = telaInicial;
        
        //inicializarBotoes();    
    }
    
    public void exibirTela(){
        telaInicial.exibirTela();
    }
}
