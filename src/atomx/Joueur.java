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
        System.out.println("");
        System.out.println("Entrez une hypothèse pour un obstacle.");
        while (continuer == true){
            System.out.print("Entrez la position X: ");
            int x = Lire.i();
            System.out.print("Entrez la position Y: ");
            int y = Lire.i();
            System.out.print("Entrez le type d'obstacle: ");
            String type = Lire.S();
            if (Jeu.getJeuCourant().getCase(x, y) != null){
                if (Jeu.getJeuCourant().getCase(x, y).getNom().equals(type)){
                    this.credit += Jeu.getJeuCourant().getCase(x,y).getPoids();
                    Jeu.getJeuCourant().removeCase(x,y);
                    continuer = true;
                    System.out.println("Vous avez trouvé un obstacle ! Vous pouvez retenter votre chance s'il reste des obstacles sur le plateau.");
                }
                else{
                    continuer = false;
                    System.out.println("Votre hypothèse est fausse !");
                }
            }
            else{
                continuer = false;
                System.out.println("Votre hypothèse est fausse !");
            }
            if(Jeu.getJeuCourant().checkWin() == true){
                System.out.println("Vous avez gagné !");
                continuer = false;
            }
        }
        
    }
    
    @Override
    public String toString() {
        return "Joueur{" + "credit=" + credit + ", pseudo=" + pseudo + '}';
    }
    
   public Position Lancer(){
       boolean continuer = false;
       char bord;
       do{
            System.out.print("Entrez le bord sur lequel vous voulez que la particule soit lancée: ");
            bord = Lire.c();
            if ((bord == 'H' || bord == 'B' || bord == 'G' || bord == 'D')){
                continuer = true;
            }
       }while(continuer == false);
       
       Position pos = new Position(0, 0, 0);
       
       System.out.print("Entrez le numero de la case d'ou partira la particule: ");
       int case_ = Lire.i();
       
       if (bord == 'H'){
           pos.setY(0);
           pos.setX(case_);
           pos.setDirection(2);
       }
       if (bord == 'B'){
           pos.setY(Jeu.getJeuCourant().getTaille());
           pos.setX(case_);
           pos.setDirection(1);
       }
       if (bord == 'G'){
           pos.setX(0);
           pos.setY(case_);
           pos.setDirection(4);
       }
       if (bord == 'D'){
           pos.setX(Jeu.getJeuCourant().getTaille());
           pos.setY(case_);
           pos.setDirection(3);
       }
       
       return pos;
   }
}
