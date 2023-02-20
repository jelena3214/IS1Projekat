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
public class ChangeAdressCityBody implements Serializable{
    private String adresa, grad;
    private String username;

    public ChangeAdressCityBody(String adresa, String grad, String username) {
        this.adresa = adresa;
        this.grad = grad;
        this.username = username;
    }

    public ChangeAdressCityBody() {
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
