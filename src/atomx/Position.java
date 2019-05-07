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
    private boolean move;
    
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
        this.move = true;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
    
    @Override
    public String toString() {
        return "Position{" + "x=" + x + ", y=" + y +", move="+move+'}';
    }
    
    public Position getSuivante(Direction d, int taille){
        if (move == true){
            return new Position(x + d.getX(), y + d.getY());
        }
        else{
            return this;
        }
    }
    
    public boolean isBord(int taille){
        if (x == 0 || x == taille || y == 0 || y == taille){
            return true;
        }
        else{
            return false;
        }
    }
     
    public boolean isDedans(int taille){
        if (x > 0 && x < taille && y > 0 && y < taille){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Direction getDir(int taille){
       if (isBord(taille) == true){
           Direction dir = new Direction(0,0);
           if (x == 0){
               dir.setX(1);
               dir.setY(0);
           }
           if (x == taille){
               dir.setX(-1);
               dir.setY(0);
           }
           
           if(y == 0){
               dir.setY(1);
               dir.setX(0);
           }
           if(y == taille){
               dir.setY(-1);
               dir.setX(0);
           }
           
           return dir;
       }
       else{
           return null; 
       }
    }
}
