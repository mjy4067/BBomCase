package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import vo.OrderBean;
import vo.OrderGoodsBean;
import vo.OrderViewBean;
import vo.StockBean;

import static db.JdbcUtil.*;

public class OrderDAO {
	
	public static OrderDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private OrderDAO() {
		
	}
	
	public static OrderDAO getInstance() {
		if(instance == null) {
			instance = new OrderDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}

	
	public int insertOrders (OrderBean order) {
		int orderCount = 0;
		String sql = "insert into orders(mem_id, receiver, ord_tel, ord_email, zip_code, addr1, addr2, ord_total, ord_date, ord_state, payment) values (?,?,?,?,?,?,?,?,?,?,?)" ;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, order.getMem_id());
			pstmt.setString(2, order.getReceiver());
			pstmt.setString(3, order.getOrd_tel());
			pstmt.setString(4, order.getOrd_email());
			pstmt.setInt(5, order.getZip_code());
			pstmt.setString(6, order.getAddr1());
			pstmt.setString(7, order.getAddr2());
			pstmt.setInt(8, order.getOrd_total());
			pstmt.setString(9, order.getOrd_date());
			pstmt.setString(10, order.getOrd_state());
			pstmt.setString(11, order.getPayment());
			
			orderCount = pstmt.executeUpdate();
		
		} catch(Exception e) {
			System.out.println("주문 에러 : " + e);
		} finally {
			close(pstmt);
		}
		return orderCount;
	}
	
	public int insertOrderGoods (ArrayList<OrderGoodsBean> orderGoods) {
		int orderCount = 0;
		String sql = "insert into order_goods values(?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			for(int i=0; i<orderGoods.size(); i++) {
				pstmt.setInt(1, orderGoods.get(i).getGoo_id());
				pstmt.setInt(2, orderGoods.get(i).getOrd_id());
				pstmt.setInt(3, orderGoods.get(i).getOrd_qty());
				pstmt.setInt(4, orderGoods.get(i).getOrd_price());
				
				orderCount = pstmt.executeUpdate();
			}
			
		} catch(Exception e) {
			System.out.println(" order_goods 에러 :" + e);
		} finally {
			close(pstmt);
		}
		return orderCount;
	}
	
	public int orderStock(ArrayList<StockBean> orderStock) {
		String sql = "insert into stock (sto_id, goo_id, sto_export, sto_qty, sto_date) values (?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			for(int i=0; i<orderStock.size(); i++) {
				pstmt.setInt(1, orderStock.get(i).getSto_id());
				pstmt.setInt(2, orderStock.get(i).getGoo_id());
				pstmt.setString(3, orderStock.get(i).getSto_export());
				pstmt.setInt(4, orderStock.get(i).getSto_qty());
				pstmt.setString(5, orderStock.get(i).getSto_date());
				
				insertCount = pstmt.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount ;
	}
	

	
	public int selectOrdId() {
		int ord_id = 1;
		String sql = "select max(ord_id) from orders";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) ord_id = rs.getInt(1)+1;
		} catch(Exception e) {
			System.out.println("selectOrdId : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return ord_id;
	}
	
	
	
	
	public int selectStoId() {
		int sto_id = 1;
		String sql = "select max(sto_id) from stock " ;
		
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) sto_id = rs.getInt(1)+1;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return sto_id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<OrderBean> memOrderList (String mem_id, int page, int limit){
		ArrayList<OrderBean> orderList = null;
		String sql = "select ord_id, mem_id, ord_date, ord_state, ord_total from orders where mem_id = '"+mem_id+"' order by ord_id desc limit ?,?";
		int startrow = (page - 1) * limit;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderList = new ArrayList<OrderBean>();
				do {
					orderList.add(new OrderBean(rs.getInt("ord_id"),
							rs.getString("mem_id"),
							rs.getString("ord_date"),
							rs.getString("ord_state"),
							rs.getInt("ord_total")));
				} while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}
	
	public int listCountMemOrder (String mem_id) {
		String sql = "select count(*) from orders where mem_id = '"+mem_id+"' order by ord_date desc ";
		int listCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public OrderBean selectOrder(int ord_id) {
		OrderBean order = null;
		String sql = "select * from orders where ord_id = '"+ord_id+"'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order = new OrderBean(rs.getInt("ord_id"),
						rs.getString("mem_id"), rs.getString("receiver"),
						rs.getString("ord_tel"), rs.getString("ord_email"),
						rs.getInt("zip_code"), rs.getString("addr1"),
						rs.getString("addr2"), rs.getInt("ord_total"),
						rs.getString("ord_date"), rs.getString("ord_state"),
						rs.getNString("payment"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return order;
	}
	
	public ArrayList<OrderViewBean> orderGoodsList(int ord_id){
		ArrayList<OrderViewBean> orderList = null;
		String sql = "select * from order_view where ord_id = '"+ord_id+"'";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				orderList = new ArrayList<OrderViewBean>();
				do {
					orderList.add(new OrderViewBean(rs.getInt("ord_id"),rs.getInt("goo_id"),
											rs.getString("goo_name"), rs.getString("goo_color"),
											rs.getString("goo_model"), rs.getInt("ord_price"),
											rs.getString("goo_image"), rs.getInt("ord_qty")));
				} while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}
	
	//주문 관리자모드 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 주문리스트 번호?
	public int listCountOrder() {
		String sql = "select count(*) from orders order by ord_date desc";
		int listCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) listCount = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	//주문리스트 페이지?
	public ArrayList<OrderBean> selectOrderList(int page){
		String sql = "select ord_id, mem_id, receiver, ord_total, ord_date, ord_state, payment from orders order by ord_id desc limit ?, 10 "; 
		ArrayList<OrderBean> orderList = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				orderList = new ArrayList<OrderBean>();
				do {
					orderList.add(new OrderBean(
								rs.getInt("ord_id"), rs.getString("mem_id"), rs.getString("receiver"),
								rs.getInt("ord_total"), rs.getString("ord_date"), rs.getString("ord_state"),
								rs.getString("payment") ));
				} while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}
	
	// 주문현황으로 분류한 리스트
	public int listCountOrderState(String state) {
		String sql = "select count(*) from orders where ord_state = '"+state+"' ";
		int listCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) listCount = rs.getInt(1);
		
		} catch(Exception e)	{
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	//주문현황으로 분류한 페이지
	public ArrayList<OrderBean> selectOrderStateList(int page, String state){
		String sql ="select ord_id, mem_id, receiver, ord_total, ord_date, ord_state, payment from orders where ord_state = '"+state+"' order by ord_id desc limit ?, 10";
		ArrayList<OrderBean> orderList = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				orderList = new ArrayList<OrderBean>();
				do {
					orderList.add(new OrderBean(
							rs.getInt("ord_id"), rs.getString("mem_id"), rs.getString("receiver"),
							rs.getInt("ord_total"), rs.getString("ord_date"), rs.getString("ord_state"),
							rs.getString("payment") ));
				} while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}
	
	//주문현황 변경 기능
	public int orderStateChange(int ord_id, String ord_state) {
		String sql = "update orders set ord_state = '"+ord_state+"' where ord_id = ?";
		int updateCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ord_id);
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	
	
	

	
	
}