package Profile_model;

import Service_model.Service;
import User_model.User;
import model.Item;

public class Profile extends Item{
    private User user;
    private Service service;
    private String price;
    private String city;
    private String description;
    
    public Profile(){
    }
    
    public Profile(int id){
        super(id);
    }
    
    public Profile(int id, User user,Service service, String price, String city, String description){
        super(id);
        this.user = user;
        this.service= service;
        this.price = price;
        this.city = city;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
