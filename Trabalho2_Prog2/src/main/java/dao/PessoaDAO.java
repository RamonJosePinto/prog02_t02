/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import model.Artista;
import model.Pessoa;
import model.Pessoa.TipoPessoa;
import model.Reviewer;
import repository.PessoaRepositorio;

/**
 *
 * @author Usuario
 */
public class PessoaDAO implements PessoaRepositorio {

    //   private static Set<Pessoa> pessoas = new HashSet();
    private static void createTable() {
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS PESSOA"
                + "   (id            SERIAL NOT NULL,"
                + "   username            VARCHAR(255),"
                + "   email           VARCHAR(255),"
                + "   senha            VARCHAR(255),"
                + "   nome           VARCHAR(255),"
                + "   tipo_pessoa    VARCHAR(10),"
                + "   PRIMARY KEY(id))"; // Parêntese de fechamento adicionado

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void PessoaDAO() {
    }

    @Override
    public Set<Pessoa> getListaPessoas() {
        createTable();
        Set<Pessoa> pessoas = new HashSet<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM PESSOA";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String username = resultado.getString("username");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                String nome = resultado.getString("nome");
                String tipoPessoaStr = resultado.getString("tipo_pessoa");
                TipoPessoa tipoPessoa = TipoPessoa.valueOf(tipoPessoaStr);

                Pessoa pessoa = null;

                if (tipoPessoa == TipoPessoa.ARTISTA) {
                    pessoa = new Artista(id, username, email, senha, nome);
                } else if (tipoPessoa == TipoPessoa.REVIEWER) {
                    pessoa = new Reviewer(id, username, email, senha, nome);
                }

                pessoa.setIdPessoa(id);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return pessoas;
    }

    @Override
    public Pessoa getPessoaId(int id) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM PESSOA WHERE id = ?";
        PreparedStatement pstmt;
        ResultSet resultado;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            resultado = pstmt.executeQuery();

            if (resultado.next()) {
                int idDB = resultado.getInt("id");
                String username = resultado.getString("username");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                String nome = resultado.getString("nome");
                String tipoPessoaStr = resultado.getString("tipo_pessoa");
                TipoPessoa tipoPessoa = TipoPessoa.valueOf(tipoPessoaStr);

                Pessoa pessoa = null;

                if (tipoPessoa == TipoPessoa.ARTISTA) {
                    pessoa = new Artista(id, username, email, senha, nome);
                } else if (tipoPessoa == TipoPessoa.REVIEWER) {
                    pessoa = new Reviewer(id, username, email, senha, nome);
                }

                pessoa.setIdPessoa(idDB);

                return pessoa;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Pessoa getPessoaEmail(String email) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM PESSOA WHERE email = ?";
        PreparedStatement pstmt;
        ResultSet resultado;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            resultado = pstmt.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
                String username = resultado.getString("username");
                String emailDB = resultado.getString("email");
                String senha = resultado.getString("senha");
                String nome = resultado.getString("nome");
                String tipoPessoaStr = resultado.getString("tipo_pessoa");
                TipoPessoa tipoPessoa = TipoPessoa.valueOf(tipoPessoaStr);

                Pessoa pessoa = null;

                if (tipoPessoa == TipoPessoa.ARTISTA) {
                    pessoa = new Artista(id, username, email, senha, nome);
                } else if (tipoPessoa == TipoPessoa.REVIEWER) {
                    pessoa = new Reviewer(id, username, email, senha, nome);
                }

                pessoa.setIdPessoa(id);

                return pessoa;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void carregarPessoas() {
        Pessoa p1 = new Artista(1, "art", "art", "123", "Linkin Park");
        Pessoa p2 = new Artista(2, "joao123", "joao123@email.com", "12345", "João Silva");
        Pessoa p3 = new Artista(3, "maria456", "maria456@email.com", "67890", "Maria Souza");
        Pessoa p4 = new Artista(4, "pedro789", "pedro789@email.com", "24680", "Pedro Ferreira");
        Pessoa p5 = new Artista(5, "ana456", "ana456@email.com", "13579", "Ana Clara");
        Pessoa p6 = new Artista(6, "carlos123", "carlos123@email.com", "98765", "Carlos Santos");
        Pessoa p7 = new Reviewer(7, "ycholinho", "a", "a", "yCholinho");

        Pessoa p8 = new Reviewer(8, "john123", "john123@email.com", "12345", "John Silva");
        Pessoa p9 = new Reviewer(9, "mary456", "mary456@email.com", "67890", "Mary Souza");
        Pessoa p10 = new Reviewer(10, "peter789", "peter789@email.com", "24680", "Peter Ferreira");
        Pessoa p11 = new Reviewer(11, "anna456", "anna456@email.com", "13579", "Anna Clara");
        Pessoa p12 = new Reviewer(12, "carl123", "carl123@email.com", "98765", "Carl Santos");

        salvarPessoasCarregadas(p1);
        salvarPessoasCarregadas(p2);
        salvarPessoasCarregadas(p3);
        salvarPessoasCarregadas(p4);
        salvarPessoasCarregadas(p5);
        salvarPessoasCarregadas(p6);
        salvarPessoasCarregadas(p7);
        salvarPessoasCarregadas(p8);
        salvarPessoasCarregadas(p9);
        salvarPessoasCarregadas(p10);
        salvarPessoasCarregadas(p11);
        salvarPessoasCarregadas(p12);
    }

    public void salvarPessoasCarregadas(Pessoa pessoa) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO PESSOA (id, username, email, senha, nome, tipo_pessoa) "
                + "SELECT ?, ?, ?, ?, ?, ? "
                + "WHERE NOT EXISTS (SELECT 1 FROM PESSOA WHERE id = ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, pessoa.getIdPessoa());
            pstmt.setString(2, pessoa.getUsername());
            pstmt.setString(3, pessoa.getEmail());
            pstmt.setString(4, pessoa.getSenha());
            pstmt.setString(5, pessoa.getNome());
            pstmt.setString(6, pessoa.getTipoPessoa().toString());
            pstmt.setInt(7, pessoa.getIdPessoa());

            pstmt.execute();

            System.out.println("Pessoa gravada com sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public boolean salvarPessoa(Pessoa pessoa) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO PESSOA (username ,email ,senha, nome, tipo_pessoa) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, pessoa.getUsername());
            pstmt.setString(2, pessoa.getEmail());
            pstmt.setString(3, pessoa.getSenha());
            pstmt.setString(4, pessoa.getNome());
            pstmt.setString(5, pessoa.getTipoPessoa().toString());

            pstmt.execute();

            System.out.println("Pessoa gravada com sucesso!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                pessoa.setIdPessoa(id);
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
