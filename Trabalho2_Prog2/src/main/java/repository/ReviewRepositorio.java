/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Review;

/**
 *
 * @author Usuario
 */
public interface ReviewRepositorio {

    public List<Review> getListaReviews();

    public List<Review> getReviewsReviewer(int idReviewer);

    public List<Review> getReviewsAlbum(int idAlbum);

    public void carregarReviews();

    public String apresentarReviewAlbum(List<Review> reviews);

    public void salvarReview(Review review);
}
