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
public class Joueur {
    private double credit;
    private String pseudo;

    public double getCredit() {
        return credit;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Joueur(double credit, String pseudo) {
        this.credit = credit;
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "Joueur{" + "credit=" + credit + ", pseudo=" + pseudo + '}';
    }
    
    
}
