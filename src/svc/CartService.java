package svc;

import java.util.ArrayList;
import static db.JdbcUtil.*;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GoodsDAO;
import vo.Cart;
import vo.GoodsBean;

public class CartService {
	
	public GoodsBean cartGoods(String name, String color) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean goods = goodsDAO.selectGoods(name, color);
		
		close(con);
		return goods;
	}
	
	public void addCart(HttpServletRequest request, GoodsBean cartGoods) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		
		for(int i=0; i<cartList.size(); i++) {
			if(cartGoods.getGoo_name().equals(cartList.get(i).getName()) &&
				cartGoods.getGoo_color().equals(cartList.get(i).getColor())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setItem_code(String.valueOf(cartGoods.getGoo_id()));
			cart.setImage(cartGoods.getGoo_image());
			cart.setName(cartGoods.getGoo_name());
			cart.setPrice(cartGoods.getGoo_price());
			cart.setQty(1);
			cart.setColor(cartGoods.getGoo_color());
			cartList.add(cart);
		}
		
	}
	
	public ArrayList<Cart> cartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		return cartList;
	}
	
	public void upQty(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++) {
			if(cartList.get(i).getName().equals(name)) {
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
			}
		}
	}
	
	public void downQty(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++) {
			if(cartList.get(i).getName().equals(name)) {
				if(cartList.get(i).getQty() > 1) {
					cartList.get(i).setQty(cartList.get(i).getQty()-1);
				}
			}
		}
	}
	
	public void remove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<kindArray.length; i++) {
			for(int j=0; j<cartList.size(); j++) {
				if(cartList.get(j).getItem_code().equals(kindArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}
	
	public void remove(HttpServletRequest request, String item_code	) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++) {
			if(cartList.get(i).getItem_code().equals(item_code)) {
				cartList.remove(cartList.get(i));
			}
		}
	}
	
	public void allRemove(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		cartList.clear();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
