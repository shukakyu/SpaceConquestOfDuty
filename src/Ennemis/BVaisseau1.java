/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class BVaisseau1 extends BadVaisseau{

    public BVaisseau1(Game g, int x, int y) {
        super(g, "bV1", x, y);
    }

    @Override
    public String toString() {
        return "BV1";
    }
    
    
}
