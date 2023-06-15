/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Review;
import model.Reviewer;
import repository.ReviewRepositorio;

/**
 *
 * @author Usuario
 */
public class ReviewDAO implements ReviewRepositorio {

    private static List<Review> reviews = new ArrayList();

    @Override
    public List<Review> getListaReviews() {
        return reviews;
    }

    @Override
    public List<Review> getReviewsReviewer(int idReviewer) {
        List<Review> reviewsReviewer = new ArrayList();

        for (Review r : reviews) {
            if (r.getReviewer().getIdPessoa() == idReviewer) {
                reviewsReviewer.add(r);
            }
        }

        return reviewsReviewer;
    }
//
//    @Override
//    public List<Review> getReviewsArtista(int idArtista) {
//        List<Review> reviewsArtista = new ArrayList();
//        for (Album album : albuns) {
//            if (album.getArtista().getIdPessoa() == idArtista) {
//                albunsArtista.add(album);
//            }
//        }
//        return albunsArtista;
//    }

    @Override
    public List<Review> getReviewsAlbum(int idAlbum) {
        List<Review> reviewsAlbum = new ArrayList();
        for (Review r : reviews) {
            if (r.getAlbum().getIdAlbum() == idAlbum) {
                reviewsAlbum.add(r);
            }
        }
        return reviewsAlbum;
    }

    @Override
    public void carregarReviews() {
        AlbumDAO daoAlbum = new AlbumDAO();
        PessoaDAO daoPessoa = new PessoaDAO();
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(1), 80, "Gostei do HT."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(1), 90, "Gostei muito, bastante divertido."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(2), 81, "Amei o Meteora."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(3), 70, "O mais meio-termo. Ainda assim bom."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(4), 73, "Ambicioso demais."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(5), 65, "Bem animado."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(6), 64, "Um retorno às origens."));
        reviews.add(new Review((Reviewer) daoPessoa.getPessoaId(7), daoAlbum.getAlbumId(7), 90, "F Chester :("));
    }

    @Override
    public String apresentarReviewAlbum(List<Review> review) {
        if (review.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Review r : review) {
                sb.append(r.apresentarReview()).append("\n\n-------------//-------------\n\n");
            }
            return sb.toString();
        } else {
            return "Sem reviews cadastradas";
        }
    }

    @Override
    public void salvarReview(Review review) {
        reviews.add(review);
    }
}
