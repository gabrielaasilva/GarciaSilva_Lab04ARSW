/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jgarc
 * @author agsilva
 */
public class FiltroSubmuestreo implements Filtro {
    @Override
    public Blueprint filtrado(Blueprint bp) {
        List<Point> p = bp.getPoints(); 
        List<Point> pNew = new ArrayList<Point>();   
        for(int i = 0 ; i < p.size(); i ++ ){
            if( i % 2 != 0 ){
                pNew.add(p.get(i)); 
            }
        }
        bp.setPoints(pNew); 
        return bp; 
    }
}
