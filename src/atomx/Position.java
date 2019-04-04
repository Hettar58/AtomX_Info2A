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
public class Position {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y + '}';
    }
    
    public Position getSuivante(Direction d){
        return new Position(x + d.getX(), y + d.getY());
    }
    
    public boolean isBord(int taille){
        if (x == 0 || x == taille){
            if (y == 0 || y == taille){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public boolean isDedans(int taille){
        if (x != 0 && x != taille){
            if (y != 0 && y != taille){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public Direction getDir(){
       
    }
}
