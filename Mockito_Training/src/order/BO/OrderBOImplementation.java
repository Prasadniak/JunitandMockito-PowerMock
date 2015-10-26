package order.BO;

import java.sql.SQLException;

import order.BO.Exception.BOException;
import order.dao.OrderDAO;
import order.dto.Order;

public class OrderBOImplementation implements OrderBO {

	private OrderDAO dao;
	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			if(result==0)
			{
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order read = dao.read(id);
			read.setStatus("Order Cancelled");
			int update = dao.update(read);
			if(update==0)
			{
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int delete = dao.delete(id);
			if(delete==0)
			{
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);

		}
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
