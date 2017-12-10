package Orders_model;

import User_model.User;
import User_model.Users;
import model.Item;

/**
 *
 * @author Yerke
 */
public class Order extends Item{
    private User client;
    private User executor;
    private String date;
    private String message;
    private String status;
    
    public Order(int id){
        super(id);
    }
    
    public Order(int id, int client, int executor, String date, String message, String status) throws NoSuchFieldException{
        super(id);
        this.client = getOrderUser(client);
        this.executor = getOrderUser(executor);
        this.date = date;
        this.message = message;
        this.status = status;
    }
    
    public Order(int id, int client, int executor, String date, String message) throws NoSuchFieldException{
        super(id);
        this.client = getOrderUser(client);
        this.executor = getOrderUser(executor);
        this.date = date;
        this.message = message;
        this.status = "false";
    }
    
    
    
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    //service functions 
    /**
     * This method used to get user based on the id from database 
     * to fill User model
     * @param id
     * @return
     * @throws NoSuchFieldException 
     */
    private User getOrderUser(int id) throws NoSuchFieldException{
        Users users = new Users();
        User user = users.getItem(id);
        if(user == null)
            throw new 	NoSuchFieldException("From getOrderUser method, here "
                        + " no such user with id = "+Integer.toString(id));
        else    
         return user;
    }
    
}
