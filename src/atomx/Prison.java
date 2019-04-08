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
public class Prison extends Obstacle{
    public Prison(int pMax){
        super(pMax);
        this.nom = "P";
        this.p = null;
    }
    
    @Override
    public void action(Particule p_in){
        if (p_in.getPoids() >= this.poids){
            p_in.setMove(false);
            if (this.p != null){
                this.p.setMove(true);
            }
            this.p = p_in;
        }
    }

    @Override
    public String toString() {
        return "Prison{" +super.toString()+ '}';
    }
    
}
