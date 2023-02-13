/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class MultipleObjectResponse implements Serializable{
    List<Serializable> objects = new ArrayList<>();

    public MultipleObjectResponse() {
    }

    public List<Serializable> getObjects() {
        return objects;
    }

    public void setObjects(List<Serializable> objects) {
        this.objects = objects;
    }

    
}
