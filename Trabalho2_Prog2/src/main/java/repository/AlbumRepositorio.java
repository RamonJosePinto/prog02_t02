/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Album;

/**
 *
 * @author Usuario
 */
public interface AlbumRepositorio {

    public Album getAlbumId(int id);

    public Album getAlbumNome(String nome);

    public List<Album> getListaAlbuns();

    public List<Album> getAlbunsArtista(int idArtista);

    public void salvarAlbum(Album album);

    public void carregarAlbums();
}
