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
public class Particule {
    private Position pos;
    private Direction dir;
    private int poids;
    private boolean active;
    private boolean move;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public Particule(Position pos, Direction dir, int poids) {
        this.pos = pos;
        this.dir = dir;
        this.poids = poids;
        this.active = true;
        this.move = true;
    }
    
    public Particule (int poids){
        this.pos = null;
        this.dir = null;
        this.poids = poids;
        this.active = false;
        this.move = false;
    }

    @Override
    public String toString() {
        return "Particule{" + "pos=" + pos + ", dir=" + dir + ", poids=" + poids + ", active=" + active + ", move=" + move + '}';
    }
    
   
}
