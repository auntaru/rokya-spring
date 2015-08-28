package org.jlsoft.orders.connection.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jlsoft.orders.connection.service.OrderService;
import org.jlsoft.orders.connection.model.ComenziVExt;
import org.jlsoft.orders.connection.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/index")
	public String listOrders(Map<String, Object> map) {
		// map.put("contact", new Contact());
		
		 Date dateOfLastOrder = orderService.getDateOfLastOrder();
	     List<ComenziVExt> orders = orderService.listOrders();
	     List<OrderDTO> ordersDTO = new ArrayList<OrderDTO>();
	     for (ComenziVExt order: orders) {
	    	 // Create new data transfer object
	    	 OrderDTO dto = new OrderDTO();
	    	 dto.setAgentName(order.getNumereLucru().getDenumire());
	    	 dto.setClientName(orderService.getClientHqNameByCui( order.getTerti().getCui()) + " - " + order.getTerti().getDenumire() );
	    	 dto.setOrderNumber(order.getNrdoc());
	    	 dto.setOrderValue(order.getValoare());
	    	 dto.setComId(order.getComId());
	    	 ordersDTO.add(dto);
	     }
		 map.put("ordersList", ordersDTO);
		 map.put("dateOfLastOrder", dateOfLastOrder);
		
		//return "contact";
		return "orders";
	}
}
