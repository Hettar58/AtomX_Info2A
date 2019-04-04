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
    
    public Obstacle(int p){
        this.poids = p;
    }

    abstract void action(Particule p);

    @Override
    public String toString() {
        return "Obstacle{" + "poids=" + poids + ", p=" + p + ", nom=" + nom + '}';
    }
}
