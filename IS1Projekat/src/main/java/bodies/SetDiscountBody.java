/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodies;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class SetDiscountBody implements Serializable{
    private int popust, idart;

    public SetDiscountBody(int popust, int idart) {
        this.popust = popust;
        this.idart = idart;
    }

    public SetDiscountBody() {
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getIdart() {
        return idart;
    }

    public void setIdart(int idart) {
        this.idart = idart;
    }
    
}
