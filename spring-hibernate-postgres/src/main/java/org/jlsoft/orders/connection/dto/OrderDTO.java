package org.jlsoft.orders.connection.dto;

import java.math.BigDecimal;

// Order Data Transfer Object : from controller to JSP view 
public class OrderDTO {

	private String 		orderNumber;
	private String 		clientName;
	private String 		agentName;
	private BigDecimal 	orderValue;
	private String 		comId;
	private String      clientMainName;
	
	public String getClientMainName() {
		return clientMainName;
	}
	public void setClientMainName(String clientMainName) {
		this.clientMainName = clientMainName;
	}
	
	public OrderDTO(String orderNumber, String clientName, String agentName,
			BigDecimal orderValue, String comId) {
		super();
		this.orderNumber = orderNumber;
		this.clientName = clientName;
		this.agentName = agentName;
		this.orderValue = orderValue;
		this.comId = comId;
	}
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public BigDecimal getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(BigDecimal orderValue) {
		this.orderValue = orderValue;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderNumber=" + orderNumber + ", clientName="
				+ clientName + ", agentName=" + agentName + ", orderValue="
				+ orderValue + ", comId=" + comId + "]";
	}
}
