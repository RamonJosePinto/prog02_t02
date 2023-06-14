/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Reviewer;

/**
 *
 * @author Usuario
 */
public interface ReviewerRepositorio {

    public List<Reviewer> getReviewer();

    public void salvarReviewer(Reviewer r);
}
