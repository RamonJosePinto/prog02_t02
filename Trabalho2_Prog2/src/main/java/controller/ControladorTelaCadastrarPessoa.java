/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PessoaDAO;
import javax.swing.JOptionPane;
import model.Artista;
import model.Pessoa;
import model.Reviewer;
import view.TelaCadastrarPessoa;
import view.TelaInicial;
import view.TelaLogin;

/**
 *
 * @author Usuario
 */
public class ControladorTelaCadastrarPessoa {
    private TelaCadastrarPessoa telaCadastrarPessoa;
    private Pessoa pessoa;

    public ControladorTelaCadastrarPessoa(TelaCadastrarPessoa telaCadastrarPessoa, Pessoa pessoa) {
        this.telaCadastrarPessoa = telaCadastrarPessoa;
        this.pessoa = pessoa;

        inicializarBotoes();
    }

    public void inicializarBotoes() {
        telaCadastrarPessoa.adicionarAcaoBotaoCadastrarPessoa(acao -> {
            acaoCadastrarPessoa();
        });
        telaCadastrarPessoa.adicionarAcaoBotaoCancelar(acao -> {
            acaoCancelar();
        });
    }

    public void acaoCancelar() {
        ControladorTelaLogin controladorTelaLogin = new ControladorTelaLogin(new TelaLogin());
        controladorTelaLogin.exibirTela();
        telaCadastrarPessoa.fecharTela();
    }

    public void acaoCadastrarPessoa() {
        if (telaCadastrarPessoa.getNomePessoa().isEmpty() || telaCadastrarPessoa.getEmailPessoa().isEmpty() || telaCadastrarPessoa.getSenhaPessoa().isEmpty() || telaCadastrarPessoa.getUsuarioPessoa().isEmpty() || telaCadastrarPessoa.getTipoUsuario() == null) {
            telaCadastrarPessoa.exibirMensagem("Há informações não preenchidas, favor preencher todos os campos para realizar o cadastro");
        } else {
            String nome = telaCadastrarPessoa.getNomePessoa();
            String email = telaCadastrarPessoa.getEmailPessoa();
            String usuario = telaCadastrarPessoa.getUsuarioPessoa();
            String senha = telaCadastrarPessoa.getSenhaPessoa();

            Pessoa novaPessoa = telaCadastrarPessoa.getRadioArtista().isSelected() ? new Artista(usuario, email, senha, nome) : new Reviewer(usuario, email, senha, nome);

            PessoaDAO pDao = new PessoaDAO();

            boolean jaCadastrado = false;
            for (Pessoa p : pDao.getListaPessoas()) {
                if (p.getEmail().equals(email)) {
                    JOptionPane.showMessageDialog(null, "Já existe um usuário com essas credenciais.");
                    jaCadastrado = true;
                    break;
                }
            }

            if (jaCadastrado == false) {
                pDao.salvarPessoa(novaPessoa);

                System.out.println(pDao.getListaPessoas());

                System.out.println(novaPessoa.toString());

                if (Pessoa.login(email, senha) == null) {
                    telaCadastrarPessoa.exibirMensagem("Erro ao logar pessoa.");
                } else {
                    telaCadastrarPessoa.exibirMensagem("Cadastro realizado com sucesso!");
                    ControladorTelaInicial controladorTelaInicial = new ControladorTelaInicial(new TelaInicial());
                    controladorTelaInicial.exibirTela();
                    telaCadastrarPessoa.fecharTela();
                }
            }
        }
    }

    public void exibirTela() {
        telaCadastrarPessoa.exibirTela();
    }

}
