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
public class AtomX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int taille = 5;
        int nbObstacles = 5;
        int pMax = 5;
        int credit = 20;
        Jeu j = new Jeu(taille, nbObstacles, pMax, credit);
    }
    
}
