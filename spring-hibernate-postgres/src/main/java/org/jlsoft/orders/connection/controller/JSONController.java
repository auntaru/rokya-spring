package org.jlsoft.orders.connection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// import com.mkyong.common.model.Shop;

@Controller
@RequestMapping("/kfc/brands")
public class JSONController {

	private class Shop {

		String name;
		
		String staffName[];
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String[] getStaffName() {
			return staffName;
		}
		public void setStaffName(String[] staffName) {
			this.staffName = staffName;
		}
		public Shop() {
		} 
		
	}
	
	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody
	Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return shop;

	}

}