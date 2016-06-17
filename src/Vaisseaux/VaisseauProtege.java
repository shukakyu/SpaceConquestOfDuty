/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaisseaux;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Baptiste
 */
public class VaisseauProtege extends VaisseauControle {

    public VaisseauProtege(Game g, int x, int y) {
        super(g, "vaisseau_shield", x, y);
        this.vie = super.vie;
    }
    
    public VaisseauProtege(Game g, int x, int y, int missiles) {
        super(g, "vaisseau_shield", x, y);
        this.missiles = missiles;
    }

    @Override
    public String toString() {
        return "VP";
    }

    @Override
    public void effect(Objet o) {
        if (o.isFriend() && !o.toString().equals("VJ")) {
            this.collisionBonus(o);
        } else {
            VaisseauJoueur v = new VaisseauJoueur(this.game(), this.getLeft(), this.getBottom() - 87, this.jeu.getAth().getVies(), this.jeu.getAth().getMissiles());
            this.game().removeKeyListener(this);
            this.game().remove(this);

            this.game().add(v);
            this.game().addKeyListener(v);
        }
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return false;
    }

    @Override
    public void collisionBonus(Objet o) {
        boolean bonus = false;
        switch (o.toString()) {
            case "Mi":
                try {
                    this.ajouterMissile();
                    this.jeu.getAth().majHUD();
                    bonus = true;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "V":
                try {
                    this.ajouterVie();
                    this.jeu.getAth().majHUD();
                    bonus = true;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;

        }
        if (bonus) {
            this.game().remove(o);
        }
    }

}
