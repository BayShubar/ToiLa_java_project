package Orders_model;

import java.util.ArrayList;
import model.Item;
import model.Items;

/**
 *
 * @author Yerke
 */
public class Orders extends Items{
    
    public Orders(){
        super("orders");
    }
    
    
    @Override
    public ArrayList getItems() throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getItem(int id) throws NoSuchFieldException {
       String request = "SELECT * FROM public.orders where id ="+id;
       ArrayList<Order> orders = columCollector(request);
        if(orders.size() == 0)
          throw new NoSuchFieldException("Inside get Item of orders class "
                                 + "no profile whit id="+Integer.toString(id));
        else    
         return orders.get(0);
    }

    @Override
    public void setItem(Item item) {
         Order order = (Order)item;
         order.setId(this.nextId());
         
              String request = "INSERT INTO public.orders(id, client, executor, date, message, status)"+
                      "VALUES ("+order.getId()+","+order.getClient().getId()+","+order.getExecutor().getId()+", '"+order.getDate()+"', '"+order.getMessage()+"', 'false');";
         
          this.db.setData(request);
         
    }

    @Override
    public void deleteItem(int id) throws NoSuchFieldException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(Item item) throws NoSuchFieldException {

    }
    
    
    /**
     * The amount of orders done by User
     * @return 
     */
    public int getOrdersNumber(int id){
        String request = "SELECT * FROM public.orders where executor = "+id+";";
        int num = this.itemsNum(request);
        return num;
    }
    
    /**
     * This method return array of Order where executor id defined
     * and method used to output offers list for executor 
     * @param executorId
     * @return
     * @throws NoSuchFieldException 
     */
    public ArrayList<Order> getOffers(int executorId) throws NoSuchFieldException{
        ArrayList<Order> orders = new ArrayList();
        String request = "SELECT * FROM public.orders where executor="+ executorId +";";  
        orders = this.columCollector(request);
        return orders;
    }
    
    /**
     * This method return array of Order where client id defined
     * and it used to output clients orders
     * @param clientId
     * @return  array of Order
     * @throws NoSuchFieldException 
     */
    public ArrayList<Order> getOrders(int clientId) throws NoSuchFieldException{
        ArrayList<Order> orders = new ArrayList();
        String request = "SELECT * FROM public.orders where client="+ clientId +";";  
        orders = this.columCollector(request);
        return orders;
    } 
    
    
    public void setStatus(String id){
       String sql = "UPDATE public.orders SET status='true' WHERE id="+id+";";
       this.db.setData(sql);
    }
    
    // SERVICE METHODS
        
        private ArrayList<Order> columCollector(String request) throws NoSuchFieldException{
             ArrayList<Order> orders = new ArrayList();

                 ArrayList<String> id = this.db.getData(request, "id");
                 ArrayList<String>  client = this.db.getData(request, "client");
                 ArrayList<String>  executor = this.db.getData(request, "executor");
                 ArrayList<String>  date = this.db.getData(request, "date");
                 ArrayList<String>  message = this.db.getData(request, "message");
                 ArrayList<String>  status = this.db.getData(request, "status");
                 
             for(int i=0; i<id.size(); i++){
                 orders.add(new Order(
                         Integer.parseInt(id.get(i)),
                         Integer.parseInt(client.get(i)),
                         Integer.parseInt(executor.get(i)),
                         date.get(i),
                         message.get(i),
                         status.get(i)
                 ));
             }

             return orders;       
         }
       
    
    
    
    
}
