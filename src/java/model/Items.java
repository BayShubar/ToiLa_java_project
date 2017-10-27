package model;

import database.DBUtil;
import java.util.ArrayList;

public abstract class Items {
    protected String table;
    protected DBUtil db;
    
    public Items(String table){
        this.table = table;
        db = new DBUtil();
    }
    
    
    public abstract ArrayList  getItems();
    public abstract Item getItem(int id);
    public abstract void setItem(Item item);
    
    
    // service Methods     
    
    
    /**
    * this service method which return next id 
    * which should be assignd to next row
    * return NEXT ID if data base is not empty
    * return 1 if EMPTY
    */
    protected int nextId(){
        String request = "select * from "+this.table;
        ArrayList<String> data = this.db.getData(request, "id");
        if(data.size()==0)
            return 1;
        else
            return Integer.parseInt( data.get(data.size()-1) )+1;
    }
    
    
    /**
     * 
     */
}
