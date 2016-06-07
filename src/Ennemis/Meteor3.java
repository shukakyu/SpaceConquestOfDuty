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
public class Meteor3 extends Meteor{
    int dirX;
    int dirY;

    public Meteor3(Game g, int x, int y, int _dirX, int _dirY) {
        super(g, "meteor3", x, y);
        this.dirX = _dirX;
        this.dirY = _dirY;
    }

    @Override
    public void effect(Objet objet) {
        if(this.collision(objet)){
            if(objet.isFriend()){
                Meteor2 m1 = new Meteor2(this.game(), this.getMiddleX(),this.getMiddleY(),-10,-10);
                Meteor2 m2 = new Meteor2(this.game(), this.getMiddleX(),this.getMiddleY(),-10,10);
                this.game().add(m1);
                this.game().add(m2);
            }
        }
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
        this.move(this.dirX,this.dirY);
    }
    
}
