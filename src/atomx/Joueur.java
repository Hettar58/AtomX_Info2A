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
    
   public void Lancer(){
       boolean continuer = false;
       char bord;
       int poids;
       do{
            System.out.println("Entrez le bord sur lequel vous voulez que la particules soit lancer");
            bord = Lire.c();
            System.out.println("Entrez le poids de la particule sachant que vous avez "+credit+ " crédits restants");
            poids = Lire.i();
            if ((bord == 'H' || bord == 'B' || bord == 'G' || bord == 'D') && poids <= credit){
                continuer = true;
            }
       }while(continuer == false);
       
       Position pos = new Position(0, 0);
       
       System.out.println("Entrez le numero de la case d'ou partira la particule");
       int case_ = Lire.i();
       
       if (bord == 'H'){
           pos.setY(0);
           pos.setX(case_);
       }
       if (bord == 'B'){
           pos.setY(Jeu.jeuCourant.getTaille());
           pos.setX(case_);
       }
       if (bord == 'G'){
           pos.setX(0);
           pos.setY(case_);
       }
       if (bord == 'D'){
           pos.setX(Jeu.jeuCourant.getTaille());
           pos.setY(case_);
       }
   }
}
