/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Set;
import model.Pessoa;

/**
 *
 * @author Usuario
 */
public interface PessoaRepositorio {

    public Set<Pessoa> getListaPessoas();

    public Pessoa getPessoaId(int id);

    public Pessoa getPessoaEmail(String email);

    public void carregarPessoas();

    public boolean salvarPessoa(Pessoa pessoa);

}
