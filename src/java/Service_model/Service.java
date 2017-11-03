package Service_model;

import model.Item;

/**
 *
 * @author Yerke
 */
public class Service extends Item{
    private String type;
    
    public Service(int id){
        super(id);
    }
    
    public Service(int id, String type){
        super(id);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
