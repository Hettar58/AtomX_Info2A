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
public class Teleporteur extends Obstacle{
    private Position destination;
    private int initX;
    private int initY;
    
    public Teleporteur(int pMax){
        super(pMax);
        this.nom = "T";
        this.p = null;
        this.initX =(int)(1+(Jeu.getJeuCourant().getTaille()-1) * Math.random());
        this.initY =(int)(1+(Jeu.getJeuCourant().getTaille()-1) * Math.random());
    }
    
    @Override
    public void action(Particule p){
        destination = new Position(initX, initY, p.getPos().getDirection());
        p.setPos(destination);
        if (Jeu.getJeuCourant().isDebug()){
            System.out.println("Teleporation");
            System.out.println("==> "+destination.getX() +", "+ destination.getY());
        }
    }

    @Override
    public String toString() {
        return "Teleporteur{"+super.toString() + "destination=" + destination + '}';
    }
}
