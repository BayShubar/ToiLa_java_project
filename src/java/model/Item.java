package model;

import java.io.Serializable;

public abstract class Item implements Serializable{
    private int id;
    
    public Item(){
    }
    
    public Item(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
}
