/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Album;
import model.Faixa;
import repository.FaixaRepositorio;

/**
 *
 * @author Usuario
 */
public class FaixaDAO implements FaixaRepositorio {

    private static List<Faixa> faixas = new ArrayList();

    @Override
    public Faixa getFaixaId(int id) {
        for (Faixa f : faixas) {
            if (f.getIdFaixa() == id) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Faixa getFaixaAlbum(Album album) {
        for (Faixa f : faixas) {
            if (f.getAlbum() == album) {
                return f;
            }
        }
        return null;
    }

    @Override
    public List<Faixa> getListaFaixas() {
        return faixas;
    }

    @Override
    public void salvarFaixa(Faixa faixa) {
        faixas.add(faixa);
    }

    @Override
    public void carregarFaixa() {
        AlbumDAO albdao = new AlbumDAO();
        faixas.add(new Faixa("Bohemian Rhapsody", albdao.getAlbumId(1), 355, 1));
        faixas.add(new Faixa("Stairway to Heaven", albdao.getAlbumId(3), 482, 1));
        faixas.add(new Faixa("Imagine", albdao.getAlbumId(1), 185, 2));
        faixas.add(new Faixa("Hey Jude", albdao.getAlbumId(5), 422, 1));
        faixas.add(new Faixa("Smells Like Teen Spirit", albdao.getAlbumId(3), 301, 2));
        faixas.add(new Faixa("Hotel California", albdao.getAlbumId(1), 391, 3));
        faixas.add(new Faixa("Purple Haze", albdao.getAlbumId(1), 176, 4));
        faixas.add(new Faixa("Sweet Child o' Mine", albdao.getAlbumId(5), 356, 2));
        faixas.add(new Faixa("Losing My Religion", albdao.getAlbumId(4), 296, 1));
        faixas.add(new Faixa("Wonderwall", albdao.getAlbumId(6), 258, 1));

        for (Album alb : albdao.getListaAlbuns()) {
            for (Faixa faixa : faixas) {
                if (faixa.getAlbum().equals(alb)) {
                    alb.setFaixas(faixa);
                }
            }
        }

    }

}
