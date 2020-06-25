/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistant;

/**
 *
 * @author tuan2
 */
public class Pair {
    private int idX;
    private int idY;

    public Pair(int idX, int idY) {
        this.idX = idX;
        this.idY = idY;
    }

    public int getIdX() {
        return idX;
    }

    public void setIdX(int idX) {
        this.idX = idX;
    }

    public int getIdY() {
        return idY;
    }

    public void setIdY(int idY) {
        this.idY = idY;
    }
    @Override
    public int hashCode() {
            final int prime = 9997;
            int result = 1;
            result = this.idX * prime + this.idY;
            return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        Pair other = (Pair) obj;
        if (this.idX != other.idX)
                return false;
        if (this.idY != other.idY)
                return false;
        return true;
    }
    public String toString(){
        return this.idX + " " + this.idY;
    }
    
}
