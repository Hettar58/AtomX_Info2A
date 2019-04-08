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

    public void Hypothese(){
        boolean continuer = true;
        while (continuer == true){
            System.out.println("Entrez la position X");
            int x = Lire.i();
            System.out.println("Entrez la position Y");
            int y = Lire.i();
            System.out.println("Entrez le type d'obstacle");
            String type = Lire.S();
            if (Jeu.getJeuCourant().getCase(x, y) != null){
                if (Jeu.getJeuCourant().getCase(x, y).getNom().equals(type)){
                    this.credit += Jeu.getJeuCourant().getCase(x,y).getPoids();
                    Jeu.getJeuCourant().removeCase(x,y);
                    continuer = true;
                }
                else{
                    continuer = false;
                }
            }
            else{
                continuer = false;
            }
        }
        
    }
    
    @Override
    public String toString() {
        return "Joueur{" + "credit=" + credit + ", pseudo=" + pseudo + '}';
    }
    
    public 
}
