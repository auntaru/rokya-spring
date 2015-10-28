package org.jlsoft.orders.connection.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jlsoft.orders.connection.service.OrderService;
import org.jlsoft.orders.connection.model.ComenziVExt;
import org.jlsoft.orders.connection.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



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
	
	// @RequestMapping(value = "/rest/orders" , method = GET , headers="Accept=*/*",  produces="application/json")
	// public @ResponseBody List<ComenziVExt> listLastOrders() {
	@RequestMapping(value = "/rest/orders" , method = GET )
	public @ResponseBody List<ComenziVExt> listLastOrders() {
		return orderService.listOrders();
	}

	 @RequestMapping(value = "/test" , method = GET , headers="Accept=*/*",  produces="application/json")
	 public @ResponseBody Object testlistOrders() {
	        return orderService.listOrders();
	        
	 }

	 @RequestMapping(value = "/test2" , method=RequestMethod.GET , headers="Accept=application/json")
	 public @ResponseBody List<ComenziVExt> test2Orders() {
	        return orderService.listOrders();
	 }
	 
	 
	// RequestMapping("/count-day-sum")
	// @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	@RequestMapping("/days")
	public String countDaySum(Map<String, Object> map) {
		 // Date dateOfLastOrder = orderService.getDateOfLastOrder();
	     List<Object[]> objectList = orderService.listCountDaySum();
		 map.put("objectList", objectList);
		 //return "count-day-sum";
		 return "days";
	}

	@RequestMapping(value="/days/{id}" , method=RequestMethod.GET)
	public String countDaySumByMonth(@PathVariable Integer id , Map<String, Object> map ) {
	     List<Object[]> objectList = orderService.listCountDaySumByMonth(id);
		 map.put("objectList", objectList);
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
