/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Artista;

/**
 *
 * @author Usuario
 */
public interface ArtistaRepositorio {

    public List<Artista> getArtistas();

    public void salvarArtistas(Artista a);
}
