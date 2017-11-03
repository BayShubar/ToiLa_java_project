
package Profile_model;

import Service_model.Services;
import User_model.*;
import java.util.ArrayList;
import Service_model.Service;
import model.Item;
import model.Items;

public class Profiles extends Items {
    
    public Profiles(){
        super("profiles");
    }

    @Override
    public ArrayList getItems() throws NoSuchFieldException {
        String request = "select * from profiles";
        return columCollector(request);
    }

    @Override
    public Item getItem(int id) throws NoSuchFieldException {
       String request = "SELECT * FROM public.profiles where id ="+id;
       ArrayList<Profile> profiles = columCollector(request);
        if(profiles.size() == 0)
          throw new NoSuchFieldException("Inside get Item of Profles class "
                                 + "no profile whit id="+Integer.toString(id));
        else    
         return profiles.get(0);
    }
    
     public Item getItemByUser(int id) throws NoSuchFieldException {
       String request = "SELECT * FROM public.profiles where users_id ="+id;
       ArrayList<Profile> profiles = columCollector(request);
        if(profiles.size() == 0)
          throw new NoSuchFieldException("Inside get Item of Profiles class "
                                 + "no profile  whit user_id="+Integer.toString(id));
        else    
         return profiles.get(0);
    }
    

    @Override
    public void setItem(Item item) {
        Profile profile = (Profile)item;
        profile.setId(this.nextId());
        
       String sql = "INSERT INTO profiles(id, users_id, services_id, price, city, description)" +
            " VALUES("+profile.getId()+
                ","+profile.getUser().getId()+
                ","+profile.getService().getId()+
                ",'"+profile.getPrice()+
                "','"+profile.getCity()+
                "','"+profile.getDescription()+
            "');";
        this.db.setData(sql);
    }
    
    
    
        @Override
    public void deleteItem(int id) throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(Item item) throws NoSuchFieldException {
        Profile profile = (Profile)item;
        profile.setId(this.nextId());
        
        
        String sql = "UPDATE public.profiles" +
        "SET services_id=2, price='1000000', city='Germany', description='Несмотря на то, что Spring не обеспечивал ' " +
        "WHERE users_id=10;";
//       String sql = "UPDATE public.profiles" +
//	"SET services_id="+profile.getService().getId()+", price='"+profile.getPrice()+"', city='"+profile.getCity()+"', description='"+profile.getDescription()+"'" +
//	"WHERE users_id = "+profile.getUser().getId()+";";
       
        this.db.setData(sql);
    }
    
    
    
    
    /**
     * thois method will check if a user have profile 
     * whether user have profile return true
     * otherwise return false
     * @param id
     * @return boolean 
     */
    public boolean isExist(int id) throws NoSuchFieldException{
       String request = "SELECT * FROM public.profiles where users_id ="+id;
       ArrayList<Profile> profiles = columCollector(request);
        if(profiles.size() == 0)
          return false;
        else    
          return true;
    }

    
        /**
     * This method return requested Item with all properties
     */
    private ArrayList<Profile> columCollector(String request) throws NoSuchFieldException{
        ArrayList<Profile> profiles = new ArrayList();
        
            ArrayList<String> id = this.db.getData(request, "id");
            ArrayList<String> users_id = this.db.getData(request, "users_id");
            ArrayList<String> services_id = this.db.getData(request, "services_id");
            ArrayList<String> price = this.db.getData(request, "price");
            ArrayList<String> city = this.db.getData(request, "city");
            ArrayList<String> description = this.db.getData(request, "description");
        
        for(int i=0; i<id.size(); i++){
            profiles.add(new Profile(
                    Integer.parseInt(id.get(i)),
                    getProfileUser( Integer.parseInt(users_id.get(i))),
                    getProfileService(Integer.parseInt(services_id.get(i))),                   
                    price.get(i),
                    city.get(i),
                    description.get(i)
            ));
        }
          
        return profiles;       
    }
    
    
    private User getProfileUser(int id) throws NoSuchFieldException{
        Users users = new Users();
        User user = users.getItem(id);
        if(user == null)
            throw new 	NoSuchFieldException("From getProfileuser method, here "
                        + " no such user with id = "+Integer.toString(id));
        else    
         return user;
    }
    
    
    
    private Service getProfileService(int id) throws NoSuchFieldException{
        Services services = new Services();
        Service service = services.getItem(id);
        if(service == null)
            throw new 	NoSuchFieldException("From getProfileService method, here "
                        + " no such user with id = "+Integer.toString(id));
        else    
         return service;
    }
    
}
