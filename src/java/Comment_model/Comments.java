package Comment_model;

import Profile_model.Profile;
import Profile_model.Profiles;
import User_model.User;
import User_model.Users;
import java.util.ArrayList;
import model.Item;
import model.Items;

/**
 *
 * @author Yerke
 */
public class Comments extends Items{
    
    public Comments(){
        super("comments");
    }

    @Override
    public ArrayList getItems() throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList getItemsByProfile(int profile_id) throws NoSuchFieldException {
        String request = "SELECT * FROM public.comments where profile_id="+ profile_id +";";
        ArrayList<Comment> comments = columCollector(request);
        return comments;
    }

    @Override
    public Item getItem(int id) throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setItem(Item item) {
                Comment c = (Comment)item;
        c.setId(this.nextId());
        
        String sql = "INSERT INTO public.comments( " +
            "id, profile_id, user_id, content) " +
            " VALUES ("+c.getId()+", "+ c.getToProfile().getId() +", " + c.getFromUser().getId() + ", '"+c.getContent()+"');";

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
     * This method return requested Item with all properties
     */
    private ArrayList<Comment> columCollector(String request) throws NoSuchFieldException{
        ArrayList<Comment> comments = new ArrayList();
        
            ArrayList<String> id = this.db.getData(request, "id");
            ArrayList<String> profile_id   = this.db.getData(request, "profile_id");
            ArrayList<String> user_id = this.db.getData(request, "user_id");
            ArrayList<String> content = this.db.getData(request, "content");
            
        for(int i=0; i<id.size(); i++){
            comments.add(new Comment(
                    Integer.parseInt(id.get(i)),
                    getProfile(profile_id.get(i)),
                    getUser(user_id.get(i)),
                    content.get(i)
            ));
        }
          
        return comments;       
    }
    
    
    private Profile getProfile(String id_string) throws NoSuchFieldException{
        int id = Integer.parseInt(id_string);
        Profiles profiles = new Profiles();
        Profile profile = (Profile) profiles.getItem(id);
        if(profile == null)
            throw new 	NoSuchFieldException("From getProfileuser method, here "
                        + " no such user with id = "+Integer.toString(id));
        else    
         return profile;
    }
    
    private User getUser(String id_string) throws NoSuchFieldException{
        int id = Integer.parseInt(id_string);
        Users users = new Users();
        User user = users.getItem(id);
        if(user == null)
            throw new 	NoSuchFieldException("From getProfileuser method, here "
                        + " no such user with id = "+Integer.toString(id));
        else    
         return user;
    }
    
}
