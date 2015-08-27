package org.jlsoft.orders.connection.dao;

import java.util.List;
import org.jlsoft.orders.connection.model.ComenziVExt;

public interface OrderDAO {

	public List<ComenziVExt> listOrders();
	public String getClientHqNameByCui(String cui);

}
