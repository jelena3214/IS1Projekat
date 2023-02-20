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
public class AddClientMoneyBody implements Serializable{
    private int novac;
    private String username;

    public AddClientMoneyBody(int novac, String username) {
        this.novac = novac;
        this.username = username;
    }

    public AddClientMoneyBody() {
    }

    public int getNovac() {
        return novac;
    }

    public void setNovac(int novac) {
        this.novac = novac;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
