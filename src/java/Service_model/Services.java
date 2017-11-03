package Service_model;

import java.util.ArrayList;
import model.Item;
import model.Items;

/**
 *
 * @author Yerke
 */
public class Services extends Items{
    public Services(){
        super("services");
    }

    @Override
    public ArrayList<Service> getItems() throws NoSuchFieldException {
        String request = "select * from services";
        return columCollector(request);
    }

    @Override
    public Service getItem(int id) throws NoSuchFieldException {
        String request = "SELECT * FROM public.services where id ="+id;
        ArrayList<Service> services = columCollector(request);
        if(services.size()==0)
            throw new NoSuchFieldException("in GetItem of service "
                    + "class no service with id = "+Integer.toString(id));
        else        
            return services.get(0);
    }

    @Override
    public void setItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * This method return requested Items with all properties
     */
    private ArrayList<Service> columCollector(String request){
        ArrayList<Service> services = new ArrayList();
        
            ArrayList<String> id = this.db.getData(request, "id");
            ArrayList<String> type = this.db.getData(request, "type");
        
        for(int i=0; i<id.size(); i++){
            services.add(new Service(
                    Integer.parseInt(id.get(i)),
                    type.get(i)
            ));
        }  
        return services;       
    }
    
    
    
}
