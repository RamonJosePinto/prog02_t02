/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Faixa;
import model.Review;

/**
 *
 * @author 10068610920
 */
public class ReviewTableModel extends AbstractTableModel {

    public ReviewTableModel(List<Review> reviews) {
        this.reviews = reviews;
    }

    private List<Review> reviews;
    private final String[] nomeColunas = {"Nome", "Nota", "Descrição"};
    private final int COLUNA_NOME = 0;
    private final int COLUNA_NOTA = 1;
    private final int COLUNA_DESCRICAO = 2;

    @Override
    public int getRowCount() {
        return reviews.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Review review = this.reviews.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_NOME:
                valor = review.getReviewer().getNome();
                break;
            case COLUNA_NOTA:
                valor = Integer.toString(review.getNota());
                break;
            case COLUNA_DESCRICAO:
                valor = review.getDescricao();
                break;
        }
        return valor;
    }

}
