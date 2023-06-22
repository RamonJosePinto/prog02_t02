/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import exception.CampoVazioCadastroFaixaException;
import java.util.List;
import model.Album;
import model.Faixa;

/**
 *
 * @author Usuario
 */
public interface FaixaRepositorio {

    public Faixa getFaixaId(int id);

    public Faixa getFaixaAlbum(Album album);

    public List<Faixa> getListaFaixas();

    public void salvarFaixa(Faixa faixa) throws CampoVazioCadastroFaixaException;

    public void carregarFaixa();
}
