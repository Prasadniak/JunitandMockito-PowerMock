package order.BO;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import order.BO.Exception.BOException;
import order.dao.OrderDAO;
import order.dto.Order;

public class OrderBOImplementationTest {

	private static final int ORDER_ID = 12775;
	@Mock
	OrderDAO dao;
	private OrderBOImplementation bo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImplementation();
		bo.setDao(dao);
	}

	@Test
	public void placeOrder_OrderCreates() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao, atLeast(1)).create(order);

	}

	@Test
	public void placeOrder_NotCreatesOrder() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);

	}

	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(any(Order.class))).thenThrow(SQLException.class);
		boolean result = bo.placeOrder(order);

	}

	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException  {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean res = bo.cancelOrder(123);
		
		assertTrue(res);
		
		verify(dao).read(123);
		verify(dao).update(order);
		
	}

	@Test(expected=BOException.class)
	public void cancelOrder_Throw_BOException() throws BOException, SQLException {
		Order order = new Order();
		when(dao.read(1234)).thenThrow(SQLException.class);
		when(dao.update(order)).thenReturn(1);
		bo.cancelOrder(1234);		

	}

	@Test(expected = BOException.class)
	public void cancelOrder_ShouldThrowABOExceptionOnRead() throws SQLException, BOException {
		when(dao.read(anyInt())).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);

	}

	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_A_BOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		bo.cancelOrder(ORDER_ID);

	}

	@Test
	public void deleteOrder_Deletes_The_Order() throws SQLException, BOException {
		when(dao.delete(ORDER_ID)).thenReturn(1);
		boolean result = bo.deleteOrder(ORDER_ID);
		assertTrue(result);
		verify(dao).delete(ORDER_ID);

	}

	
	@Test
	public void deleteOrder_Throws_Exception() throws SQLException, BOException {
		// Using the Matcher from the Mockito Doc Pages
		when(dao.delete(anyInt())).thenReturn(0);
		boolean result = bo.deleteOrder(ORDER_ID);
		assertFalse(result);
		// using Verification from Mockito Objects
		verify(dao,times(1)).delete(ORDER_ID);

	}

}
