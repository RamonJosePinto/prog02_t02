/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Reviewer;
import repository.ReviewerRepositorio;

/**
 *
 * @author Usuario
 */
public class ReviewerDAO implements ReviewerRepositorio{
    
    public static List<Reviewer> reviewers = new ArrayList();
    
    @Override
    public List<Reviewer> getReviewer() {
        return reviewers;
    }

    @Override
    public void salvarReviewer(Reviewer r) {
        reviewers.add(r);
    }
}
