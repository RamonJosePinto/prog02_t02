/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exception.AlbumSemFaixaException;
import java.util.ArrayList;
import java.util.List;
import model.Album;
import model.Artista;
import repository.AlbumRepositorio;

/**
 *
 * @author Usuario
 */
public class AlbumDAO implements AlbumRepositorio {

    private static List<Album> albuns = new ArrayList();

    @Override
    public List<Album> getListaAlbuns() {
        return albuns;
    }

    @Override
    public Album getAlbumId(int id) {
        for (Album a : albuns) {
            if (a.getIdAlbum() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Album> getAlbunsArtista(int idArtista) {
        List<Album> albunsArtista = new ArrayList();
        for (Album a : albuns) {
            if (a.getArtista().getIdPessoa() == idArtista) {
                albunsArtista.add(a);
            }
        }
        return albunsArtista;
    }

    @Override
    public void salvarAlbum(Album album) throws AlbumSemFaixaException {
        if (album.getFaixas().size() != 0) {
            albuns.add(album);
        }else{
            throw new AlbumSemFaixaException("Para cadastrar um album é preciso cadastrar pelo menos uma musica no mesmo");
        }
    }

    @Override
    public void carregarAlbums() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        albuns.add(new Album("Hybrid Theory", 2000, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("Meteora", 2003, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("Minutes To Midnight", 2007, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("A Thousand Suns", 2010, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("LIVING THINGS", 2012, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("The Hunting Party", 2014, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("One More Light", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 1", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 2", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 3", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 4", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 5", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 6", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 7", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 8", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 9", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 10", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 11", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 12", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 13", 2017, (Artista) pessoaDAO.getPessoaId(1)));
        albuns.add(new Album("TESTE 14", 2017, (Artista) pessoaDAO.getPessoaId(1)));
    }

    @Override
    public Album getAlbumNome(String nome) {
        for (Album a : albuns) {
            if (a.getTitulo().equals(nome)) {
                return a;
            }
        }
        return null;
    }
}
