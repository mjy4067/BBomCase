package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GoodsDAO;
import dao.OrderDAO;
import vo.GoodsBean;

import vo.OrderBean;
import vo.OrderGoodsBean;
import vo.OrderViewBean;
import vo.StockBean;

public class OrderService {
	
	public GoodsBean orderGoods(String name, String color) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean goods = goodsDAO.selectGoods(name, color);
		
		close(con);
		return goods;
	}
	
	public boolean order (OrderBean order, ArrayList<OrderGoodsBean> orderGoods, ArrayList<StockBean> orderStock) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		boolean orderResult = false;
		int orderCount1 = orderDAO.insertOrders(order);
		int orderCount2 = orderDAO.insertOrderGoods(orderGoods);
		int orderCount3 = orderDAO.orderStock(orderStock);

		
		if(orderCount1 > 0 && orderCount2 > 0 && orderCount3 > 0) {
			commit(con);
			orderResult = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return orderResult;
	}
	
	public boolean orderGoods(ArrayList<OrderGoodsBean> orderGoods) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		boolean orderResult = false;
		int orderCount = orderDAO.insertOrderGoods(orderGoods);
		
		if(orderCount > 0) {
			orderResult = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return orderResult;
	}
	
	public boolean orderStock(ArrayList<StockBean> orderStock) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		boolean orderResult = false;
		int insertCount = orderDAO.orderStock(orderStock);
		
		if(insertCount > 0) {
			orderResult = true;
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return orderResult;
	}
	
	public int selectOrdId() {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int ord_id = orderDAO.selectOrdId();
		
		close(con);
		return ord_id;
	}
	
	public int selectStoId() {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int sto_id = orderDAO.selectStoId();
		
		close(con);
		return sto_id;
	}
	
	public ArrayList<OrderBean> memOrderList(String mem_id, int page, int limit) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		ArrayList<OrderBean> orderList = orderDAO.memOrderList(mem_id, page, limit);
		
		close(con);
		return orderList;
	}
	
	public int listCountMemOrder(String mem_id){
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int listCount = orderDAO.listCountMemOrder(mem_id);
		
		close(con);
		return listCount;
	}
	
	public OrderBean selectOrder(int ord_id) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		OrderBean order = orderDAO.selectOrder(ord_id);
		
		close(con);
		return order;
	}
	
	public ArrayList<OrderViewBean> orderGoodsList(int ord_id){
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		ArrayList<OrderViewBean> orderList = orderDAO.orderGoodsList(ord_id);
		
		close(con);
		return orderList;
	}
	
	public int listCountOrder() {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int listCount = orderDAO.listCountOrder();
		
		close(con);
		return listCount;
	}
	
	public ArrayList<OrderBean> selectOrderList(int page){
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		ArrayList<OrderBean> orderList = orderDAO.selectOrderList(page);
		
		close(con);
		return orderList;
	}
	
	public int listCountOrderState(String state) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int listCount = orderDAO.listCountOrderState(state);
		
		close(con);
		return listCount;
	}
	
	public ArrayList<OrderBean> selectOrderStateList(int page, String state){
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		ArrayList<OrderBean> orderList = orderDAO.selectOrderStateList(page, state);
		
		close(con);
		return orderList;
	}
	
	public int orderStateChange(int ord_id, String ord_state) {
		Connection con = getConnection();
		OrderDAO orderDAO = OrderDAO.getInstance();
		orderDAO.setConnection(con);
		int updateCount = orderDAO.orderStateChange(ord_id, ord_state);
		
		if(updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return updateCount;
	}
	

	
	
	
	
	
	
	
	
	

}
