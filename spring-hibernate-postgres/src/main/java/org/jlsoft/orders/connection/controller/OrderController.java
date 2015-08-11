package org.jlsoft.orders.connection.controller;

import java.util.Map;

import org.jlsoft.orders.connection.service.OrderService;

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
		map.put("ordersList", orderService.listOrders());

		return "contact";
	}
}
