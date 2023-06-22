/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Faixa;

/**
 *
 * @author Pichau
 */
public class FaixasTableModel extends AbstractTableModel {

    private List<Faixa> faixas;
    private final String[] nomeColunas = {"Nome", "Duração"};
    private final int COLUNA_NOME = 0;
    private final int COLUNA_DURACAO = 1;

    public FaixasTableModel(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    @Override
    public int getRowCount() {
        return faixas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Faixa faixa = this.faixas.get(rowIndex);
        String valor = null;
        switch (columnIndex) {
            case COLUNA_NOME:
                valor = faixa.getNome();
                break;
            case COLUNA_DURACAO:
                valor = Integer.toString(faixa.getDuracao());
                break;
        }
        return valor;
    }

}
