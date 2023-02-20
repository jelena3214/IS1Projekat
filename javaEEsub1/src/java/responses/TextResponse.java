/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class TextResponse implements Serializable{
    private String mess;
    
    public TextResponse(String mess) {
        this.mess = mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }
    

    @Override
    public String toString() {
        return "" + mess;
    }
    
    
}
