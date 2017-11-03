package database;

import default_settings.DataBase;
import java.sql.*;
import java.util.ArrayList;
public class DBUtil {
   private Connection conn;
   private String url = "jdbc:postgresql://localhost:5433/"+DataBase.DB_NAME;
   private String user = DataBase.DB_USER;
   private String password = DataBase.DB_PASSWORD;
   
   public DBUtil(){
       this.connect();
   }
   
   
   private void connect(){
       try{
          Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(url, user, password); 
       }catch(ClassNotFoundException e){
       }catch(SQLException e){}
    }
   
   
   
    
    public  ArrayList<String> getData(String sql, String column){
        ArrayList words  = new ArrayList();
            try{
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs =  stm.executeQuery();  
                    while(rs.next()){
                        words.add((String)rs.getString(column));
                    }
            }catch(SQLException e){}
        return words;
    }
    
    
    public void setData(String sql){
        try{
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs =  stm.executeQuery();  
        }catch(SQLException e){}
    }
    
}

