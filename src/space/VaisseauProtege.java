/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author bapt
 */
public class VaisseauProtege extends VaisseauJoueur implements KeyListener{
    
    public VaisseauProtege(Game g, String sprite) {
        super(g, sprite);
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Vaisseau protege");
    }
    
}