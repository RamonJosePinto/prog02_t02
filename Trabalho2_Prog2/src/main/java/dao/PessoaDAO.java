/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import model.Artista;
import model.Pessoa;
import model.Reviewer;
import repository.PessoaRepositorio;

/**
 *
 * @author Usuario
 */
public class PessoaDAO implements PessoaRepositorio{

    private static Set<Pessoa> pessoas = new HashSet();

    public void PessoaDAO() {
    }

    @Override
    public Set<Pessoa> getListaPessoas() {
        return pessoas;
    }

    @Override
    public Pessoa getPessoaId(int id) {
        for (Pessoa p : pessoas) {
            if (p.getIdPessoa() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Pessoa getPessoaEmail(String email) {
        for (Iterator<Pessoa> it = pessoas.iterator(); it.hasNext();) {
            Pessoa usuario = it.next();
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void carregarPessoas() {
        pessoas.add(new Artista("art", "art", "123", "Linkin Park"));
        pessoas.add(new Artista("joao123", "joao123@email.com", "12345", "João Silva"));
        pessoas.add(new Artista("maria456", "maria456@email.com", "67890", "Maria Souza"));
        pessoas.add(new Artista("pedro789", "pedro789@email.com", "24680", "Pedro Ferreira"));
        pessoas.add(new Artista("ana456", "ana456@email.com", "13579", "Ana Clara"));
        pessoas.add(new Artista("carlos123", "carlos123@email.com", "98765", "Carlos Santos"));

        pessoas.add(new Reviewer("ycholinho", "a", "a", "yCholinho"));
        pessoas.add(new Reviewer("john123", "john123@email.com", "12345", "John Silva"));
        pessoas.add(new Reviewer("mary456", "mary456@email.com", "67890", "Mary Souza"));
        pessoas.add(new Reviewer("peter789", "peter789@email.com", "24680", "Peter Ferreira"));
        pessoas.add(new Reviewer("anna456", "anna456@email.com", "13579", "Anna Clara"));
        pessoas.add(new Reviewer("carl123", "carl123@email.com", "98765", "Carl Santos"));
    }

    @Override
    public void salvarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
}
