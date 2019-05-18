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
            p_in.getPos().setMove(false);
            if (this.p != null){
                this.p.getPos().setMove(true);
                Jeu.getJeuCourant().setP(this.p);
                if(Jeu.getJeuCourant().isDebug()){
                    System.out.println("Prison");
                    System.out.println("Changement de particule active");
                }
            }
            this.p = p_in;
        }
    }

    @Override
    public String toString() {
        return "Prison{" +super.toString()+ '}';
    }
    
}
