package org.jlsoft.orders.connection.service;

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

}