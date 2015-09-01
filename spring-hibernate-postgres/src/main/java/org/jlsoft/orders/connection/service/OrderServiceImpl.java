package org.jlsoft.orders.connection.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jlsoft.orders.connection.model.ComenziVExt;
import org.jlsoft.orders.connection.dao.OrderDAO;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Transactional
	public List<ComenziVExt> listOrders() {

		return orderDAO.listOrders();
		
	}

	@Transactional
	public String getClientHqNameByCui(String cui){
		
		return orderDAO.getClientHqNameByCui(cui);
		
	}

	@Transactional
	public Date getDateOfLastOrder() {
		// TODO Auto-generated method stub
		return orderDAO.getDateOfLastOrder();
	}

	@Transactional
	public String getSumOfOrdersValuesOnLastDay(Date dateOfLastOrder){
		return orderDAO.getSumOfOrdersValuesOnLastDay(dateOfLastOrder);
	}

	@Transactional
	public String getCountOfOrdersOnLastDay(Date dateOfLastOrder)
	{
		return orderDAO.getCountOfOrdersOnLastDay(dateOfLastOrder);
	}
	
}
