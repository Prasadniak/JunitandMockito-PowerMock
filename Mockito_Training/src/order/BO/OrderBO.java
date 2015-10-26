package order.BO;

import order.BO.Exception.BOException;
import order.dto.Order;

public interface OrderBO {
	
	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id)throws BOException;

}
