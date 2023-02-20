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
public class CreateCityBody implements Serializable{
    private String name;
    private int num;
    
    public CreateCityBody() {
    }
    
    public CreateCityBody(String s, int a) {
        name = s;
        num = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CreateCityBody{" + "name=" + name + ", num=" + num + '}';
    }
    
    
    
}
