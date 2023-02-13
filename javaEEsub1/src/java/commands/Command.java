/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.Serializable;

public abstract class Command implements Serializable {
    public enum Type {
        CREATE_PLACE,
        CREATE_CLIENT,
        ADD_MONEY,
        CHANGE_CITY_ADRESS, 
        GET_ALL_CITIES,
        GET_ALL_CLIENTS,
        CREATE_CATEGORY,
        CREATE_ARTICLE,
        CHANGE_PRICE,
        SET_DISCOUNT,
        ADD_TO_BAG,
        GET_USER_ID,
        REMOVE_FROM_BAG,
        GET_CATEGORIES,
        GET_SELLING_ARTICLES,
        GET_BAG_ARTICLES,
        BUY_ARTICLES,
        GET_CLIENT_INFO,
        GET_USER_ORDERS,
        GET_ALL_ORDERS,
        GET_ALL_TRANSACTIONS
    };
    public enum DestQueue {
        S1,
        S2,
        S3
    };
    
    protected static int ID = 0;
    protected int id = ++ID;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Command{" + "id=" + id + '}';
    }
    
    abstract public DestQueue getDestination();
    abstract public Type getType();
}