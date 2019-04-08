/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;

/**
 *
 * @author yann
 */
abstract class Obstacle {
    protected int poids;
    protected Particule p;
    protected String nom;
    
    public Obstacle(int pMax){
        this.poids  = (int)(1 + (pMax-1) * Math.random());
    }

    abstract void action(Particule p);

    @Override
    public String toString() {
        return "Obstacle{" + "poids=" + poids + ", p=" + p + ", nom=" + nom + '}';
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Particule getP() {
        return p;
    }

    public void setP(Particule p) {
        this.p = p;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
