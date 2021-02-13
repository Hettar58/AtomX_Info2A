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
public class Jeu {
    private int taille;
    private int nbObstacles;
    private int poidsMax;
    private double creditInit;
    private Joueur j;
    private Obstacle[][] plateau;
    private boolean debug;

    private static Jeu jeuCourant;
    private Particule p;

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getNbObstacles() {
        return nbObstacles;
    }

    public void setNbObstacles(int nbObstacles) {
        this.nbObstacles = nbObstacles;
    }

    public int getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(int poidsMax) {
        this.poidsMax = poidsMax;
    }

    public double getCreditInit() {
        return creditInit;
    }

    public void setCreditInit(double creditInit) {
        this.creditInit = creditInit;
    }

    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public Obstacle[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Obstacle[][] plateau) {
        this.setPlateau(plateau);
    }

    public static Jeu getJeuCourant() {
        return jeuCourant;
    }

    public static void setJeuCourant(Jeu jeuCourant) {
        Jeu.jeuCourant = jeuCourant;
    }
    

    public Particule getP() {
        return p;
    }
    
    public void setP(Particule p) {
        this.p = p;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public Jeu(int taille,  int nbObstacles,  int poidsMax,  double creditInit, boolean debug) {
        this.taille = taille;
        this.nbObstacles = nbObstacles;
        this.poidsMax = poidsMax;
        this.creditInit = creditInit;
        this.plateau = new Obstacle[taille][taille];
        jeuCourant = this;
        initJoueur();
        this.debug = debug;
        if (debug == false){
            initJeu();
        }
        else{
            plateau[1][1] = new Deviateur(1);
            plateau[1][0] = new Prison(1);
            plateau[0][1] = new Teleporteur(1);
            visuPlateau();
            System.out.println();
        }
        
        Tour();
    }

    @Override
    public String toString() {
        return "Jeu{" + "taille=" + getTaille() + ", nbObstacles=" + getNbObstacles() + ", poidsMax=" + getPoidsMax() + ", creditInit=" + getCreditInit() + ", joueur=" + j + ", plateau=" + getPlateau() + ", p=" + getP() + '}';
    }
    
    public void visuPlateau(){
        for (int i =0; i < taille; i ++){
            for (int j = 0; j < taille; j++){
                System.out.print(plateau[j][i] + "_("+j+" "+i+") ");
            }
            System.out.println();
        }
    }
    
    public Obstacle getCase(int x, int y){
        if (x >= 0 && x < getTaille() && y >= 0 && y < getTaille()){
            if (getPlateau()[x][y] != null){
                return getPlateau()[x][y];
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    
    public void removeCase(int x, int y){
        getPlateau()[x][y]=null;
    }
    
    public void initJeu(){
        setNbObstacles((int) (1 + (getTaille() - 1) * Math.random()));
        
        int i = 0;
        while (i < getNbObstacles()){
            Obstacle o = null;
            
            int type = (int)(1+(100-1) * Math.random());
            int pMax = (int)(1+(poidsMax - 1) * Math.random());
            int x = (int)(getTaille() * Math.random());
            int y = (int)(getTaille() * Math.random());
            
            if (type < 33){
                o = new Prison(pMax);
            }
            if (type > 33 && type < 66){
                o = new Deviateur(pMax);
            }
            if (type > 66){
                o = new Teleporteur(pMax);
            }
            
            getPlateau()[x][y] = o;
            i++;
        }
    }
    
    public void initJoueur(){
        String pseudo;
        System.out.print("Entrez votre pseudo: ");
        pseudo = Lire.S();
        setJ(new Joueur(getCreditInit(), pseudo));
    }
    
    public void Tour(){
        int poids;
        do{
            System.out.print("Entrez le poids de la particule sachant que vous avez "+j.getCredit()+ " crédits restants: ");
            poids = Lire.i();
        }while(!(j.getCredit() >= poids));
        
        Position pos = j.Lancer();
        p = new Particule(pos, pos.getDir(taille), poids);
        j.setCredit(j.getCredit() - poids);
        if (debug == true){
            System.out.println(p.getPos().toString());
            System.out.println(p.getDir().toString());
            System.out.println();
        }
        
        do{
            
            if (getCase(p.getPos().getX(), p.getPos().getY()) != null){
                if (debug == true){System.out.println("Contact !");}
                getCase(p.getPos().getX(), p.getPos().getY()).action(p);
            }
            
            p.setPos(p.getPos().getSuivante(p.getDir(), taille));
            
            if (debug == true){System.out.println(p.getPos().toString());}
            
        }while (p.getPos().isDedans(taille) && p.getPos().isMove() && p.isActive());
        
        p.setActive(false);
        
        if (p.getPos().isMove()){
            System.out.println("La particule est sortie en X="+p.getPos().getX()+", Y="+p.getPos().getY());
            j.setCredit(j.getCredit()+p.getPoids());
            p = null;
        }
        else{
            System.out.println("La particule n'est pas sortie");
        }
        
        j.Hypothese();
        if (j.getCredit() > 0 && checkWin() == false){
            Tour();
        }
        else{
            if (j.getCredit() <= 0){
                System.out.println("Vous avez perdu !");
            }
            
        }
    }
    
    public boolean checkWin(){
        boolean win = true;
        for (int i = 0; i < taille; i++){
            for (int j = 0; j < taille; j++){
                if (plateau[i][j] != null){
                    win = false;
                }
            }
        }
        return win;
    }
}
