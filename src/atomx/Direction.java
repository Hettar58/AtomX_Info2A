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
public class Direction {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Direction{" + "x=" + x + ", y=" + y + '}';
    }
    
    public Direction getRotation(int tours){
        boolean decX = x == 1 ? true : false;
        boolean decY = y == 1 ? true : false;
        for(int i = 0; i < tours; i++){
            switch(x){
                case 1:
                    decX = true;
                    x = 0;
                    break;
                case 0:
                    if (decX == true){
                        x = -1;
                    }else{
                        x = 1;
                    }
                    break;
                case -1:
                    x = 0;
                    decX = false;
                    break;
            }
            
            switch(y){
                case 1:
                    decY = true;
                    y = 0;
                    break;
                case 0:
                    if (decY == true){
                        y = -1;
                    }else{
                        y = 1;
                    }
                    break;
                case -1:
                    y = 0;
                    decY = false;
                    break;
            }
        }
        return new Direction(x, y);
    }
}
