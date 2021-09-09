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
public class FiltroRedundancia implements Filtro {
    @Override
    public Blueprint filtrado(Blueprint bp) {
        List<Point> p = bp.getPoints(); 
        List<Point> pNew = new ArrayList<Point>();
        
        for(int i = 0 ; i < p.size() - 1; i ++ ){
            if(!(p.get(i).getX() == p.get(i+1).getX()&& p.get(i).getY() == p.get(i+1).getY()))  {
                pNew.add(p.get(i)); 
            } 
        }
        pNew.add(p.get(p.size()-1));  
        bp.setPoints(pNew); 
        return bp; 
    }
}
