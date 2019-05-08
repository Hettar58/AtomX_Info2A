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
    private int direction;
    
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

    public Position(int x, int y, int direction) {
        //direction = 1 ==> vers le haut
        //direction = 2 ==> vers le bas
        //direction = 3 ==> vers la gauche
        //direction = 4 ==> vers la droite
        //direction = 0 ==> point mort
        this.x = x;
        this.y = y;
        this.move = true;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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
            return new Position(x + d.getX(), y + d.getY(), direction);
        }
        else{
            return this;
        }
    }
    
    public boolean isBord(int taille){
        
        if (x == -1 || x == taille || y == -1 || y == taille){
            return true;
        }
        else{
            return false;
        }
    }
     
    public boolean isDedans(int taille){
        if (x >= 0 && x < taille && y >= 0 && y < taille){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Direction getDir(int taille){
        Direction dir = new Direction(0,0);
        if (direction == 1){ //vers le haut
            dir.setX(0);
            dir.setY(-1);
        }
        if (direction == 2){ // vers le bas
            dir.setX(0);
            dir.setY(1);
        }
        if(direction == 3){ // vers la gauche
            dir.setX(-1);
            dir.setY(0);
        }
        if(direction == 4){ // vers la droite
            dir.setX(1);
            dir.setY(0);
        }
        return dir;
    }
}
