/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import exception.PessoaInexistenteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.TelaCadastrarPessoa;
import view.TelaInicial;
import view.TelaLogin;

/**
 *
 * @author Usuario
 */
public class ControladorTelaLogin {

    private TelaLogin telaLogin;
    private Pessoa pessoa;

    public ControladorTelaLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;

        inicializarBotoes();
    }

    public void exibirTela() {
        telaLogin.exibirTela();
    }

    public void inicializarBotoes() {
        telaLogin.adicionarAcaoBotaoCadastrarPessoa(acao -> {
            acaoCadastrarPessoa();
        });

        telaLogin.adicionarAcaoBotaoValidarLogin(acao -> {
            acaoValidarLogin();
        });
    }

    public void acaoCadastrarPessoa() {
        ControladorCadastrarPessoa controladorTelaCadastrarPessoa = new ControladorCadastrarPessoa(new TelaCadastrarPessoa(), null);
        controladorTelaCadastrarPessoa.exibirTela();
        telaLogin.fecharTela();
    }

    public void acaoValidarLogin() {
        try {
            //Obter nome e senha do usuario
            String email = telaLogin.getEmailUsuario();
            String senha = telaLogin.getSenhaUsuario();

            //Chamada do metodo login de pessoa
            Pessoa p = Pessoa.login(email, senha);
            telaLogin.exibirMensagem("Login feito com sucesso !");
            ControladorTelaInicial controladorTelaInicial = new ControladorTelaInicial(new TelaInicial());
            controladorTelaInicial.exibirTela();
            telaLogin.fecharTela();

        } catch (PessoaInexistenteException ex) {
            telaLogin.exibirMensagem(ex.getMessage());
             telaLogin.limparTela();
        }
    }

}
