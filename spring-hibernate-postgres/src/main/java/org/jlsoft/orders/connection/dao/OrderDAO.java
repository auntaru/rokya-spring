package org.jlsoft.orders.connection.dao;

import java.util.Date;
import java.util.List;

import org.jlsoft.orders.connection.model.ComenziVExt;

public interface OrderDAO {

	public List<ComenziVExt> listOrders();
	public String getClientHqNameByCui(String cui);
	public Date getDateOfLastOrder();
	public String getSumOfOrdersValuesOnLastDay(Date dateOfLastOrder);
	public String getCountOfOrdersOnLastDay(Date dateOfLastOrder);
	public List<Object[]> listCountDaySum();
	public List<Object[]> listCountMonthSum();
	public List<Object[]> listCountMonthSumOnLatestYear(Date dateOfLastOrder);
	public List<Object[]> listCountMonthSumOnYear(Integer theYear);
	public List<Object[]> listCountDaySumByMonth(Integer theMonth);
	public List<Object[]> listCountDaySumByMonthAndYear(Integer theMonth, Integer theYear);

}
