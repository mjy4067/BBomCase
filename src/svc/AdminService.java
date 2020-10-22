package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GoodsDAO;
import vo.GoodsBean;
import vo.StockBean;

public class AdminService {

	public ArrayList<GoodsBean> getGoodsList(){
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection();
		goodsDAO.setConnection(con);
		ArrayList<GoodsBean> adminGoodsList = goodsDAO.selectGoodsList();
		close(con);
		return adminGoodsList;
	}
	
	public int getListCount() throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		listCount = goodsDAO.selectGoodsListCount();
		close(con);
		return listCount;
	}
	
	public ArrayList<GoodsBean> getArticleList(int page, int limit) throws Exception{
		ArrayList<GoodsBean> articleList = null;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		articleList = goodsDAO.selectGoodsArticleList(page, limit);
		close(con);
		return articleList;
	}
	
	public GoodsBean goodsModify(int goo_id) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		GoodsBean Modify = goodsDAO.selectGoods(goo_id);
		
		close(con);
		return Modify;
	}
	
	public boolean goodsModify(GoodsBean goods) {
		boolean modifyResult = false;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		int modifyCount = goodsDAO.modifyGoods(goods);
		if(modifyCount > 0) {
			commit(con);
			modifyResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return modifyResult;
	}
	
	public boolean goodsRemove(String[] kindArray) {
		boolean deleteResult = false;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		int deleteCount = goodsDAO.deleteGoods(kindArray);
		if(deleteCount > 0) {
			commit(con);
			deleteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}
	
	public boolean goodsRemove(int goo_id) {
		boolean deleteResult = false;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		int deleteCount = goodsDAO.deleteGoods(goo_id);
		if(deleteCount > 0) {
			commit(con);
			deleteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}
	
	public int goodsStockExport(StockBean stock) {
		int exportResult = 0;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		exportResult = goodsDAO.goodsStockExport(stock);
		
		if(exportResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return exportResult;
	}
	
	public int goodsStockImport(StockBean stock) {
		int importResult = 0;
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);
		importResult = goodsDAO.goodsStockImport(stock);
		
		if(importResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return importResult;
	}
	
}
