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
public class AddClientMoneyCommand extends Command{
    private int novac;
    private String username;

    public AddClientMoneyCommand(int novac, String username) {
        this.novac = novac;
        this.username = username;
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
    
    @Override
    public DestQueue getDestination() {
        return Command.DestQueue.S1;
    }

    @Override
    public Type getType() {
        return Command.Type.ADD_MONEY;
    }
    
}
