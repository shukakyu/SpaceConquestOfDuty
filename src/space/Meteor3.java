/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class Meteor3 extends Meteor{

    public Meteor3(Game g, int x, int y) {
        super(g, "meteor3", x, y);
    }

    @Override
    public void effect(Objet objet) {
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

    @Override
    public void move(long l) {
        this.move(-8,0);
    }
    
}
