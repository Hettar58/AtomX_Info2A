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
    private Joueur j;
    private Obstacle[][] plateau;
<<<<<<< HEAD
    private static Jeu jeuCourant;
    private Particule p;
    
=======
    public static Jeu jeuCourant;
<<<<<<< Updated upstream
    private Particule p;
=======
>>>>>>> Stashed changes
>>>>>>> master

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

    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public Obstacle[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Obstacle[][] plateau) {
        this.setPlateau(plateau);
    }

    public static Jeu getJeuCourant() {
        return jeuCourant;
    }

    public static void setJeuCourant(Jeu jeuCourant) {
        Jeu.jeuCourant = jeuCourant;
    }
    
<<<<<<< Updated upstream
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
        this.plateau = new Obstacle[taille][taille];
        jeuCourant = this;
        initJoueur();
        initJeu();
        visuPlateau();
        
    }

    @Override
    public String toString() {
        return "Jeu{" + "taille=" + getTaille() + ", nbObstacles=" + getNbObstacles() + ", poidsMax=" + getPoidsMax() + ", creditInit=" + getCreditInit() + ", joueur=" + j + ", plateau=" + getPlateau() + ", p=" + getP() + '}';
    }
    
    public void visuPlateau(){
        for (int i =0; i < taille; i ++){
            for (int j = 0; j < taille; j++){
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public Obstacle getCase(int x, int y){
        if (x >= 0 && x < getTaille() && y >= 0 && y < getTaille()){
            if (getPlateau()[x][y] != null){
                return getPlateau()[x][y];
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
        getPlateau()[x][y]=null;
    }
    
    public void initJeu(){
        setNbObstacles((int) (1 + (getTaille() - 1) * Math.random()));
        
        int i = 0;
        while (i < getNbObstacles()){
            Obstacle o = null;
            
            int type = (int)(1+(100-1) * Math.random());
            int pMax = (int)(1+(poidsMax - 1) * Math.random());
            int x = (int)(getTaille() * Math.random());
            int y = (int)(getTaille() * Math.random());
            
            if (type < 33){
                o = new Prison(pMax);
            }
            if (type > 33 && type < 66){
                o = new Deviateur(pMax);
            }
            if (type > 66){
                o = new Teleporteur(pMax);
            }
            
            getPlateau()[x][y] = o;
            i++;
        }
    }
    
    public void initJoueur(){
        String pseudo;
        System.out.println("Entrez votre pseudo");
        pseudo = Lire.S();
        setJ(new Joueur(getCreditInit(), pseudo));
    }
=======
    
>>>>>>> Stashed changes
}
