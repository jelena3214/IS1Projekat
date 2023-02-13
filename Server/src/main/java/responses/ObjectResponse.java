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
public class ObjectResponse implements Serializable{
    private Object obj;

    public ObjectResponse(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    
}
