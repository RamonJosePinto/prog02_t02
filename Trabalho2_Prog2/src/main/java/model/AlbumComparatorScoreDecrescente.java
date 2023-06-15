/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author guilh
 */
public class AlbumComparatorScoreDecrescente implements Comparator<Album>{
    
    @Override
    public int compare(Album a1, Album a2) {
        int score1 = a1.calcularScore();
        int score2 = a2.calcularScore();
        
        if (score1 > score2)
            return -1;
        
        if (score1 < score2)
            return  1;
        
        return 0;
    }
}
