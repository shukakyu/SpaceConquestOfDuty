/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;

/**
 *
 * @author Baptiste
 */
public class Missile extends Bonus{
    
    public Missile(Game g, int x, int y) {
        super(g, "missileObjet", x, y);
    }
    
    @Override
    public String toString(){
        return "Mi";
    }
    
}
