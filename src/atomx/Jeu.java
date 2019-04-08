/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;

import com.sun.istack.internal.NotNull;
import java.util.ArrayList;

/**
 *
 * @author yann
 */
public class Jeu {
    private int taille;
    private int nbObstacles;
    private int poidsMax;
    private double creditInit;
    private ArrayList<Joueur> joueurs;
    private Obstacle[][] plateau;
    public static Jeu jeuCourant;
    private Particule p;

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getNbObstacles() {
        return nbObstacles;
    }

    public void setNbObstacles(int nbObstacles) {
        this.nbObstacles = nbObstacles;
    }

    public int getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(int poidsMax) {
        this.poidsMax = poidsMax;
    }

    public double getCreditInit() {
        return creditInit;
    }

    public void setCreditInit(double creditInit) {
        this.creditInit = creditInit;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Obstacle[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Obstacle[][] plateau) {
        this.plateau = plateau;
    }

    public static Jeu getJeuCourant() {
        return jeuCourant;
    }

    public static void setJeuCourant(Jeu jeuCourant) {
        Jeu.jeuCourant = jeuCourant;
    }
    
    public Particule getP() {
        return p;
    }
    
    public void setP(Particule p) {
        this.p = p;
    }

    public Jeu(@NotNull int taille, @NotNull int nbObstacles, @NotNull int poidsMax, @NotNull double creditInit) {
        this.taille = taille;
        this.nbObstacles = nbObstacles;
        this.poidsMax = poidsMax;
        this.creditInit = creditInit;
        this.joueurs = new ArrayList<Joueur>();
        this.plateau = new Obstacle[taille][taille];
        
    }

    @Override
    public String toString() {
        return "Jeu{" + "taille=" + taille + ", nbObstacles=" + nbObstacles + ", poidsMax=" + poidsMax + ", creditInit=" + creditInit + ", joueurs=" + joueurs + ", plateau=" + plateau + ", p=" + p + '}';
    }
    
    public Obstacle getCase(int x, int y){
        if (x >= 0 && x < taille && y >= 0 && y < taille){
            if (plateau[x][y] != null){
                return plateau[x][y];
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    
    public void removeCase(int x, int y){
        plateau[x][y]=null;
    }
}
