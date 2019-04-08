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
public class Deviateur extends Obstacle{
    public Deviateur(int pMax){
        super(pMax);
        this.nom = "D";
        this.p = null;
    }
    
    @Override
    public void action(Particule p){
        int rotations = (int)(1+(2 * Math.random()));
        p.setDir(p.getDir().getRotation(rotations));
    }

    @Override
    public String toString() {
        return "Deviateur{" + '}';
    }
}
