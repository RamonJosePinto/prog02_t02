/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import controller.ControladorTelaInicial;
import controller.ControladorTelaLogin;
import dao.AlbumDAO;
import dao.FaixaDAO;
import dao.PessoaDAO;
import dao.ReviewDAO;
import view.TelaInicial;
import view.TelaLogin;

/**
 *
 * @author Usuario
 */
public class App {

    public static void main(String[] args) {

        PessoaDAO pessoaDAO = new PessoaDAO();
        AlbumDAO albumDAO = new AlbumDAO();
        ReviewDAO reviewDAO = new ReviewDAO();
        FaixaDAO faixaDAO = new FaixaDAO();

        pessoaDAO.carregarPessoas();
        albumDAO.carregarAlbums();
        reviewDAO.carregarReviews();
        faixaDAO.carregarFaixa();

        ControladorTelaLogin controladorTelaLogin = new ControladorTelaLogin(new TelaLogin());
        controladorTelaLogin.exibirTela();
    }
}
