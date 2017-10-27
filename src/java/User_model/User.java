package User_model;

import model.Item;

public class User extends Item{
    private String tellnumber;
    private String name;
    private String surname;
    private String role;
    private String password;
    
    public User(int id, String tellnumber, String name, String surname, String role, String password){
        super(id);
        this.tellnumber = tellnumber;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.password = password;
    }
    
    public User(int id){
        super(id);
    }
    
    public boolean checker(String num, String pass){
        if(num.equals(this.tellnumber) && pass.equals(this.password))
            return true;
        return false;
    }
    
    /**
     * All nessasary getters and setters
     * @return 
     */
    public String getTellnumber(){
        return this.tellnumber;
    }
    public void setTellnumber(String tellnumber){
        this.tellnumber = tellnumber;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public String getRole(){
        return this.role;
    }
    public void setRole(String role){
        this.role = role;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
