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
    public Deviateur(int p){
        super(p);
        this.nom = "D";
        this.p = null;
    }
    
    @Override
    public void action(Particule p){
        
    }
    
    @Override
    public String toString() {
        return "Prison{" +super.toString()+ '}';
    }
}
