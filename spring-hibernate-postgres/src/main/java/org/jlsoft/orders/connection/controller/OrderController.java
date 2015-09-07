package org.jlsoft.orders.connection.controller;

import java.math.BigDecimal;
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

	@RequestMapping("/orders")
	public String listOrders(Map<String, Object> map) {
		 Date dateOfLastOrder = orderService.getDateOfLastOrder();
		 String valueOfLastOrders = new String(" ");
		 valueOfLastOrders = orderService.getSumOfOrdersValuesOnLastDay(dateOfLastOrder);
		 String countOfLastOrders = orderService.getCountOfOrdersOnLastDay(dateOfLastOrder) ; 
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
		 map.put("valueOfLastOrders", valueOfLastOrders);
		 map.put("countOfLastOrders", countOfLastOrders);
		return "orders";
	}
	
	// RequestMapping("/count-day-sum")
	@RequestMapping("/days")
	public String countDaySum(Map<String, Object> map) {
		 // Date dateOfLastOrder = orderService.getDateOfLastOrder();
	     List<Object[]> objectList = orderService.listCountDaySum();
		 map.put("objectList", objectList);
		 //return "count-day-sum";
		 return "days";
	}

	@RequestMapping("/months")
	public String countMonthSum(Map<String, Object> map) {
		 // Date dateOfLastOrder = orderService.getDateOfLastOrder();
	     List<Object[]> objectList = orderService.listCountMonthSum();
		 map.put("objectList", objectList);
		 return "months";
	}

	
}
