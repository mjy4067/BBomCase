package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import dao.GoodsDAO;
import vo.BoardBean;
import vo.Cart;
import vo.GoodsBean;
import vo.GoodsViewBean;
import vo.StockBean;

public class GoodsService {
	
	public ArrayList<GoodsBean> goodsList(String model){
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> goodsList = goodsDAO.selectGoodsList(model);
		
		close(con);
		return goodsList;
	}
	
	public ArrayList<GoodsBean> goodsList(){
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> goodsList = goodsDAO.selectGoodsList();
		
		close(con);
		return goodsList;
	}
	
	public ArrayList<GoodsBean> Category(String category){
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> categoryList = goodsDAO.selectCategoryGoodsList(category);
	
		close(con);
		return categoryList;
	}
	
	public GoodsBean GoodsView(String name) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean goods = goodsDAO.selectGoods(name);
		
		close(con);
		return goods;
	}
	
	public ArrayList<GoodsBean> GoodsViewColor(String name) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> goods = goodsDAO.selectGoodsColor(name);
		
		close(con);
		return goods;
	}
	
	
	
	//
	
	public GoodsBean orderGoods(String name, String color) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean goods = goodsDAO.selectGoods(name, color);
		
		close(con);
		return goods;
	}
	
	public GoodsBean orderGoods(int goo_id) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean goods = goodsDAO.selectGoods(goo_id);
		
		close(con);
		return goods;
	}
	
	public GoodsBean getCartGoods(String name, String color) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean goods = goodsDAO.selectGoods(name, color);
		close(con);
		return goods;
	}
	
	public void addCart(HttpServletRequest request, GoodsBean cartGoods, int qty) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		session.setMaxInactiveInterval(60*60);
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		
		for(int i=0; i < cartList.size(); i++) {
			if(cartGoods.getGoo_name().equals(cartList.get(i).getName())&&
				cartGoods.getGoo_color().equals(cartList.get(i).getColor())) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+qty);
				break;
			}
		}
		
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setItem_code(String.valueOf(cartGoods.getGoo_id()));
			cart.setImage(cartGoods.getGoo_image());
			cart.setName(cartGoods.getGoo_name());
			cart.setPrice(cartGoods.getGoo_price());
			cart.setQty(qty);
			cart.setColor(cartGoods.getGoo_color());
			cartList.add(cart);
		}
	}
	
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		return cartList;
	}
	
	public void downCartQty(HttpServletRequest requset, String name, String color) {
		HttpSession session = requset.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++) {
			if(cartList.get(i).getName().equals(name)&&
					cartList.get(i).getColor().equals(color)) {
				if(cartList.get(i).getQty() > 1) {
				cartList.get(i).setQty(cartList.get(i).getQty() - 1);
				}
			}
		}
		
	}
	
	public void upCartQty(HttpServletRequest request, String name, String color) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
				
		for(int i=0; i < cartList.size(); i++) {
			if(cartList.get(i).getName().equals(name)&&
					cartList.get(i).getColor().equals(color)) {
				cartList.get(i).setQty(cartList.get(i).getQty() + 1);
			}
		}
	}
	
	public void cartRemove(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		cartList.clear();
	}
	
	public void cartRemove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		for (int i = 0; i < kindArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if (cartList.get(j).getItem_code().equals(kindArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}

	public void cartRemove(HttpServletRequest request, String item_code) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		for (int j = 0; j < cartList.size(); j++) {
			if (cartList.get(j).getItem_code().equals(item_code)) {
				cartList.remove(cartList.get(j));
			}
		}
	}
	
	public ArrayList<GoodsBean> getGoodsList(String model){
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> goodsList = goodsDAO.selectGoodsList(model);
		close(con);
		return goodsList;
	}
	
	public ArrayList<GoodsBean> getCategoryGoodsList(String category){
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> categoryList = goodsDAO.selectCategoryGoodsList(category);
		close(con);
		return categoryList;
	}
	
	public ArrayList<GoodsBean> goodsRank(){
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> goodsRankList = goodsDAO.selectGoodsRank();
		close(con);
		return goodsRankList;
	}
	
	public ArrayList<GoodsBean> goodsNew(){
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> goodsNewList = goodsDAO.selectGoodsNew();
		close(con);
		return goodsNewList;
	}
	
	public boolean registGoods(GoodsBean goods) {
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = goodsDAO.insertGoods(goods);
		
		if(insertCount > 0) {
			commit(con);
			isRegistSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}
	
	public boolean registGoodsStock(StockBean stock, GoodsBean goods) {
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = goodsDAO.insertGoodsStock(stock, goods);
		
		if(insertCount > 0) {
			commit(con);
			isRegistSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}
	
	public GoodsBean getGoodsView(String name) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		
		GoodsBean goods = goodsDAO.selectGoods(name);
		close(con);
		return goods;
	}
	
	public ArrayList<GoodsBean> getGoodsViewName(String name) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		
		ArrayList<GoodsBean> goods = goodsDAO.selectGoodsColor(name);
		close(con);
		return goods;
	}
	
	public int getQnaListCount(int goo_id) throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectQnaListCount(goo_id);
		close(con);
		return listCount;
	}
	
	public ArrayList<BoardBean> selectQnaList(int page, int goo_id) throws Exception{
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectQnaList(page, goo_id);
		close(con);
		return articleList;
	}
	
	public int getReviewListCount(int goo_id) throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectReviewListCount(goo_id);
		close(con);
		return listCount;
	}
	
	public ArrayList<BoardBean> selectReviewList(int page, int goo_id) throws Exception{
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectReviewList(page, goo_id);
		close(con);
		return articleList;
	}
	
	public ArrayList<GoodsViewBean> getStockList(int page, int limit){
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		ArrayList<GoodsViewBean> goodsStockList = goodsDAO.selectGoodsStock(page, limit);
		return goodsStockList;
	}
}
