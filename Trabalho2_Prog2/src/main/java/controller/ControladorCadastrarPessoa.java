/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PessoaDAO;
import exception.ImagemInexistenteException;
import exception.PessoaInexistenteException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Artista;
import model.Pessoa;
import model.Reviewer;
import util.ManipularImagem;
import view.TelaCadastrarPessoa;
import view.TelaInicial;
import view.TelaLogin;

/**
 *
 * @author Usuario
 */
public class ControladorCadastrarPessoa {

    private TelaCadastrarPessoa telaCadastrarPessoa;
    private Pessoa pessoa;

    public ControladorCadastrarPessoa(TelaCadastrarPessoa telaCadastrarPessoa) {
        this.telaCadastrarPessoa = telaCadastrarPessoa;
        this.pessoa = null;

        inicializarBotoes();
    }

    public void inicializarBotoes() {
        telaCadastrarPessoa.adicionarAcaoBotaoCadastrarPessoa(acao -> acaoCadastrarPessoa());
        telaCadastrarPessoa.adicionarAcaoBotaoCancelar(acao -> acaoCancelar());
        telaCadastrarPessoa.adicionarAcaoBotaoImagemPerfil(acao -> acaoAtualizarImagemPerfil());
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
            String caminoImagemPerfil = telaCadastrarPessoa.getCaminhoImagemPerfil();

            Pessoa novaPessoa = telaCadastrarPessoa.getRadioArtista().isSelected() ? new Artista(usuario, email, senha, nome,caminoImagemPerfil) : new Reviewer(usuario, email, senha, nome,caminoImagemPerfil);

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
                try {
     
                    pDao.salvarPessoa(novaPessoa);

                    System.out.println(pDao.getListaPessoas());
                    System.out.println(novaPessoa.toString());

          
                    Pessoa.login(email, senha);
                 
                    telaCadastrarPessoa.exibirMensagem("Cadastro realizado com sucesso!");
                    ControladorTelaInicial controladorTelaInicial = new ControladorTelaInicial(new TelaInicial());
                    controladorTelaInicial.exibirTela();
                    telaCadastrarPessoa.fecharTela();
                } catch (PessoaInexistenteException ex) {
                    telaCadastrarPessoa.exibirMensagem(ex.getMessage());
                }
            }
        }
    }

    private void inicializarImagemPefil() {
        try {
            telaCadastrarPessoa.atualizarImagemPerfil(ManipularImagem.buscarImagem(telaCadastrarPessoa.getCaminhoImagemPerfil()));
        }  catch (IOException | ImagemInexistenteException ex) {
            telaCadastrarPessoa.exibirMensagem("Não foi possível carregar sua imagem de perfil. Por favor, faça upload novamente.");
        }
    }
    
    private void acaoAtualizarImagemPerfil() {
        File arquivo = telaCadastrarPessoa.subirImagemPerfil();
        
        String arquivoOrigem = arquivo.toPath().toString();
                
        String nomeArquivo = Integer.toString(Pessoa.getGeradorIdPessoa());
  
        try {
            String caminhoImagemPerfil = ManipularImagem.gravarImagemPerfil(arquivoOrigem, nomeArquivo, 135, 135);
            
            if (new PessoaDAO().atualizarImagemPessoa(Pessoa.getGeradorIdPessoa(), caminhoImagemPerfil)) {
                telaCadastrarPessoa.setCaminhoImagemPerfil(caminhoImagemPerfil);
                telaCadastrarPessoa.exibirMensagem("Sua imagem de perfil foi atualizada.");
                inicializarImagemPefil();
            } else {
                telaCadastrarPessoa.exibirMensagem("Não foi possível fazer upload da imagem de perfil.");
            }
        } catch (IOException ex) {
            telaCadastrarPessoa.exibirMensagem("Não foi possível fazer upload da imagem de perfil.");
        }

    }
    
    public void exibirTela() {
        telaCadastrarPessoa.exibirTela();
    }

}
