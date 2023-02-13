/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

/**
 *
 * @author Lenovo
 */
public class ChangeAdressCityCommand extends Command{
    
    private String adresa, grad;
    private String username;

    public ChangeAdressCityCommand(String adresa, String grad, String username) {
        this.adresa = adresa;
        this.grad = grad;
        this.username = username;
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


    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S1;
    }

    @Override
    public Type getType() {
        return Command.Type.CHANGE_CITY_ADRESS;
    }
    
}
