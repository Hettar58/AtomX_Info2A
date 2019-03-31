/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;

import java.util.ArrayList;

/**
 *
 * @author yann
 */
public class Jeu {
    private int taille;
    private int nbObstacles;
    private int poidsMax;
    private double creditInit;
    private ArrayList<Joueur> joueurs;
    private Obstacle[][] plateau;
    private static Jeu jeuCourant;
}
