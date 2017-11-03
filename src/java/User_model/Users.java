package User_model;

import database.DBUtil;
import java.util.ArrayList;
import model.Item;
import model.Items;

public class Users extends Items{
    
    public Users(){
        super("users");
    }

    @Override
    public ArrayList<User> getItems() {    
      String request = "select * from users";
      return columCollector(request);
    }

    @Override
    //  NOT FINISHED YET
    public User getItem(int id) throws NoSuchFieldException{
       String request = "SELECT * FROM public.users where id ="+id;
       ArrayList<User> users = columCollector(request);
        if(users.size() == 0)
          throw new NoSuchFieldException("Inside get Item of Users class "
                                 + "no user whit id="+Integer.toString(id));
        else    
         return users.get(0);
       
    }

    @Override
    public void setItem(Item item) {
        User user = (User)item;
        user.setId(this.nextId());
        
       String sql = "INSERT INTO users(id, tellnumber, name, surname, role, password)" +
            " VALUES("+user.getId()+
                ",'"+ user.getTellnumber() +
                "','"+ user.getName() +
                "','"+user.getSurname()+
                "','"+user.getRole()+
                "','"+user.getPassword()+"');";
        
        this.db.setData(sql);
    }
    
    
        @Override
    public void deleteItem(int id) throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(Item item) throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * 
     * @param num tellNumber 
     * tellNumber should be unique
     * @return if exist given tellNumber return true 
     * otherwise return false
     */
    public boolean sameTellNumber(String num){
        ArrayList<String> tellnumber = this.db.getData("select * from users", "tellnumber");
           for(int i=0; i<tellnumber.size(); i++){
               if( tellnumber.get(i).equals(num))
                   return true;
           }
        return false;       
    }
    /**
     * 
     * @param num tellNumber
     * @param pass Passport
     * @return true if user exist or return false if not exist
     */
    public boolean auth(String num, String pass){
        ArrayList<User> users = this.getItems();
        for(int i = 0; i<users.size(); i++)
            if(users.get(i).checker(num, pass))
                return true;
        return false;
    }
    
    /**
     * 
     * @param num this is a tellNumber of user which is unique
     * and after Authentication or after the registatrtion 
     * you can get user profile by unique tellNumber
     * @return User object
     */
    public User getUserByTellNumber(String num){
        ArrayList<User> users = this.getItems();
        for(int i = 0; i<users.size(); i++)
            if(users.get(i).getTellnumber().equals(num))
                return users.get(i);
        return null;  //this error no shuch user
    }
    
    
    // Below all service Methods
        
    
    
    /**
     * This method return requested users with all properties
     */
    private ArrayList<User> columCollector(String request){
        ArrayList<User> users = new ArrayList();
        
            ArrayList<String> id = this.db.getData(request, "id");
            ArrayList<String> tellnumber = this.db.getData(request, "tellnumber");
            ArrayList<String> name = this.db.getData(request, "name");
            ArrayList<String> surname = this.db.getData(request, "surname");
            ArrayList<String> role = this.db.getData(request, "role");
            ArrayList<String> password = this.db.getData(request, "password");
        
        for(int i=0; i<id.size(); i++){
            users.add(new User(
                    Integer.parseInt(id.get(i)),
                    tellnumber.get(i),
                    name.get(i),
                    surname.get(i),
                    role.get(i),
                    password.get(i)
            ));
        }
          
        return users;       
    }
    
    
    
}
