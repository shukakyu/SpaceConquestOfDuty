/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATH;

import Vaisseaux.*;
import java.util.ArrayList;
import space.GameInst;

/**
 *
 * @author Baptiste
 */
public final class ATH {

    protected final int LARGEUR_ICONE_VIE = 50;
    protected final int LARGEUR_ICONE_MISSILE = 50;
    protected final int HAUTEUR_ICONE_MISSILE = 50;
    protected final int ESPACEMENT = 10;

    protected final int xHud = 10;
    protected final int yHud = 10;

    protected final ArrayList<Icone> icones = new ArrayList();

    protected final GameInst jeu;

    protected final Vaisseau vaisseau;

    protected int missiles;
    protected int vies;

    public ATH(GameInst g, VaisseauJoueur v) {
        this.jeu = g;
        this.vaisseau = v;
        this.missiles = v.getMissiles();
        this.vies = v.getVie();
        this.initListe();
        this.initATH();
    }

    public void initListe() {
        for (int i = 0; i < 6; i++) {
            this.icones.add(this.iconeNeutre());
        }
    }

    /**
     * Itinialise l'ATH avec 3 icones de vies et 3 icones de missile
     */
    public void initATH() {
        for (int i = 0; i < 3; i++) {
            IconeVie iV = new IconeVie(jeu, this.xHud + (LARGEUR_ICONE_VIE + ESPACEMENT) * i, this.yHud);
            IconeMissile iM = new IconeMissile(jeu, this.xHud + (LARGEUR_ICONE_MISSILE + ESPACEMENT) * i, this.yHud + HAUTEUR_ICONE_MISSILE + ESPACEMENT);
            this.jeu.add(iM);
            this.jeu.add(iV);
            this.icones.set(i, iV); //On stocke les adresses des objets pour pouvoir supprimer les icones du hud
            this.icones.set(i + 3, iM);
        }
    }

    /**
     * Permet de créer une icone vie
     *
     * @return Retourne une icone vide à la position (0,0)
     */
    public Icone iconeNeutre() {
        return new Icone(this.jeu, null, 0, 0);
    }

    public void enleverIconeVie(int qVie) {
        this.jeu.remove(this.icones.get(qVie));
        this.icones.set(qVie, this.iconeNeutre());
    }

    public void enleverIconeMissile(int qMissile) {
        this.jeu.remove(this.icones.get(qMissile + 3));
        this.icones.set(qMissile + 3, this.iconeNeutre());
    }

    public void ajouterVie(int qVie) {
        IconeVie v = new IconeVie(this.jeu, this.xHud + (this.ESPACEMENT + this.LARGEUR_ICONE_VIE) * (qVie-1), this.yHud);
        this.jeu.add(v);
        this.icones.set(qVie-1, v);
    }

    public void ajouterMissile(int qMissile) {
        IconeMissile m = new IconeMissile(this.jeu, this.xHud + (this.ESPACEMENT + this.LARGEUR_ICONE_MISSILE) * (qMissile -1), this.ESPACEMENT + this.HAUTEUR_ICONE_MISSILE + this.yHud);
        this.jeu.add(m);
        this.icones.set(qMissile + 2, m);
    }

    public void majHUD() {
        if (this.vaisseau.getVie() != this.vies) {
            if (this.vaisseau.getVie() < this.vies) {
                this.enleverIconeVie(this.vaisseau.getVie());
            } else if (this.vaisseau.getVie() > this.vies) {
                this.ajouterVie(this.vaisseau.getVie());
            }
            this.vies = this.vaisseau.getVie();
        }

        if (this.vaisseau.getMissiles() != this.missiles) {
            if (this.vaisseau.getMissiles() < this.missiles) {
                this.enleverIconeMissile(this.vaisseau.getMissiles());
            } else if (this.vaisseau.getMissiles() > this.missiles) {
                this.ajouterMissile(this.vaisseau.getMissiles());
            }
            this.missiles = this.vaisseau.getMissiles();
        }
    }
}
