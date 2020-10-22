package dao;
import static db.JdbcUtil.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import vo.BoardBean;
import vo.GoodsBean;
import vo.GoodsViewBean;
import vo.StockBean;

public class GoodsDAO {
	Connection con;
	private static GoodsDAO goodsDAO;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static GoodsDAO getInstance() {
		if(goodsDAO == null) {
			goodsDAO = new GoodsDAO();
		}
		return goodsDAO;
	}

	// 상품 리스트 기종으로 찾기
	public ArrayList<GoodsBean> selectGoodsList(String model){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsBean> goodsList = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods where goo_model like ? group by goo_name");
			pstmt.setString(1, model);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goodsList = new ArrayList<GoodsBean>();
				
				do {
					goodsList.add(new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"),
							      rs.getInt("goo_price"), rs.getString("goo_model"),rs.getString("goo_color"),
							      rs.getString("goo_content"), rs.getString("goo_image"),
							      rs.getString("goo_date"), rs.getString("goo_category")));
				} while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("selectGoodsList 오류" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return goodsList;
	}
	
	// 상품 리스트 분류로 찾기
	public ArrayList<GoodsBean> selectCategoryGoodsList(String category){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsBean> categoryList = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods where goo_category=? group by goo_name");
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				categoryList = new ArrayList<GoodsBean>();
				
				do {
					categoryList.add(new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"),
							      rs.getInt("goo_price"), rs.getString("goo_model"),rs.getString("goo_color"),
							      rs.getString("goo_content"), rs.getString("goo_image"),
							      rs.getString("goo_date"),rs.getString("goo_category")));
				} while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("selectGoodsList 오류" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return categoryList;
	}
	
	// 상품 리스트 찾기
	public ArrayList<GoodsBean> selectGoodsList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsBean> adminGoodsList = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods group by goo_name order by goo_id");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adminGoodsList = new ArrayList<GoodsBean>();
				
				do {
					adminGoodsList.add(new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"),
							      rs.getInt("goo_price"), rs.getString("goo_model"),rs.getString("goo_color"),
							      rs.getString("goo_content"), rs.getString("goo_image"),
							      rs.getString("goo_date"),rs.getString("goo_category")));
				} while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("selectGoodsList 오류" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return adminGoodsList;
	}
	
	// 상품명과 색깔을 가져와 어떤 상품인지 찾기
	public GoodsBean selectGoods(String name, String color) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsBean goods = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods where goo_name=? and goo_color=?");
			pstmt.setString(1, name);
			pstmt.setString(2, color);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods = new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"), rs.getInt("goo_price"),
						  rs.getString("goo_model"), rs.getString("goo_color"),rs.getString("goo_content"),
						  rs.getString("goo_image"), rs.getString("goo_date"),rs.getString("goo_category"));
			}
		} catch(SQLException e) {
			System.out.println("selectGoods 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return goods;
	}
	
	// 상품번호에 맞는 상품 맞기
	public GoodsBean selectGoods(int goo_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsBean goods = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods where goo_id=?");
			pstmt.setInt(1, goo_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods = new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"), rs.getInt("goo_price"),
						  rs.getString("goo_model"), rs.getString("goo_color"),rs.getString("goo_content"),
						  rs.getString("goo_image"), rs.getString("goo_date"),rs.getString("goo_category"));
			}
		} catch(SQLException e) {
			System.out.println("selectGoods 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return goods;
	}
	
	// 상품 이름에 맞는 상품 찾기
	public GoodsBean selectGoods(String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsBean goods = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods where goo_name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goods = new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"), rs.getInt("goo_price"),
						  rs.getString("goo_model"), rs.getString("goo_color"),rs.getString("goo_content"),
						  rs.getString("goo_image"), rs.getString("goo_date"),rs.getString("goo_category"));
			}
		} catch(SQLException e) {
			System.out.println("selectGoods 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return goods;
	}
	
	public ArrayList<GoodsBean> selectGoodsColor(String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsBean> goods = null;
		
		try {
			pstmt = con.prepareStatement("select * from goods where goo_name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				goods = new ArrayList<GoodsBean>();
				do {
				goods.add(new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"), rs.getInt("goo_price"),
						  rs.getString("goo_model"), rs.getString("goo_color"),rs.getString("goo_content"),
						  rs.getString("goo_image"), rs.getString("goo_date"),rs.getString("goo_category")));
				} while(rs.next());
			}
		} catch(SQLException e) {
			System.out.println("selectGoods 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return goods;
	}
	
	// 상품 등록하기
	public int insertGoods(GoodsBean goods) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "insert into goods(goo_name, goo_price, goo_model, goo_color, goo_content, goo_image, goo_date, goo_category)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goods.getGoo_name());
			pstmt.setInt(2, goods.getGoo_price());
			pstmt.setString(3, goods.getGoo_model());
			pstmt.setString(4, goods.getGoo_color());
			pstmt.setString(5, goods.getGoo_content());
			pstmt.setString(6, goods.getGoo_image());
			pstmt.setString(7, goods.getGoo_date());
			pstmt.setString(8, goods.getGoo_category());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertGoods 오류" + e);
		} finally{
			close(pstmt);
		}
		return insertCount;
		
	}
	
	// 재고 등록하기
	public int insertGoodsStock(StockBean stock, GoodsBean goods) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "select goo_id from goods where goo_name=? and goo_color=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goods.getGoo_name());
			pstmt.setString(2, goods.getGoo_color());
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				pstmt = con.prepareStatement("insert into stock(goo_id, sto_import, sto_export, sto_qty, sto_date)"
						+ " values(?, ?, ?, ?, ?)");
				pstmt.setInt(1, rs.getInt(1));
				pstmt.setString(2, stock.getSto_import());
				pstmt.setString(3, stock.getSto_export());
				pstmt.setInt(4, stock.getSto_qty());
				pstmt.setString(5, stock.getSto_date());
				insertCount = pstmt.executeUpdate();
			}
			} catch (SQLException e) {
				System.out.println("insertGoodsStock 오류" + e);
			} finally {
				close(pstmt);
		}
		return insertCount;
	}
	
	// 상품 삭제하기(선택삭제)
	
	public int deleteGoods(String[] kindArray) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int deleteCount = 0;
		int deleteAllCount = 0;
		int[] a = new int[kindArray.length];
		
		for(int i=0; i<kindArray.length; i++) {
			a[i] = Integer.parseInt(kindArray[i]);
		}
		
		try {
			
			for(int j=0; j<kindArray.length; j++) {
				pstmt1 = con.prepareStatement("delete from stock where goo_id=?");
				pstmt1.setInt(1, a[j]);
				deleteCount = pstmt1.executeUpdate();
				if(deleteCount > 0) {
					for(int k=0; k<kindArray.length; k++) {
						pstmt2 = con.prepareStatement("delete from goods where goo_id=?");
						pstmt2.setInt(2, a[k]);
						deleteAllCount = pstmt2.executeUpdate();
					}
				}
			}
		} catch(SQLException e) {
			System.out.println("deleteGoods 오류" + e);
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		return deleteAllCount;
	}
	
	// 상품 삭제하기(상품번호)
	public int deleteGoods(int goo_id) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		int deleteCount = 0;
		int deleteAllCount = 0;
				
		try {	
				pstmt1 = con.prepareStatement("select sum(sto_qty) sto_qty from stock where goo_id=?");
				pstmt1.setInt(1, goo_id);
				rs = pstmt1.executeQuery();
				
				if(rs.next()) {
				if(rs.getInt(1) == 0) {
				pstmt2 = con.prepareStatement("delete from stock where goo_id=?");
				pstmt2.setInt(1, goo_id);
				deleteCount = pstmt2.executeUpdate();
				}
				
				if(deleteCount > 0) {
					pstmt3 = con.prepareStatement("delete from goods where goo_id=?");
					pstmt3.setInt(1, goo_id);
					deleteAllCount = pstmt3.executeUpdate();
				}
				}
		} catch(SQLException e) {
			System.out.println("deleteGoods 오류" + e);
		} finally {
			close(rs);
			close(pstmt1);
			close(pstmt2);
			close(pstmt3);
		}
		return deleteAllCount;
	}
	
	public int modifyGoods(GoodsBean goods) {
		PreparedStatement pstmt = null;
		int modifyCount = 0;
	
		try {
			pstmt = con.prepareStatement("update goods set goo_name=?, goo_price=?, goo_model=?,"
					+ "goo_color=?, goo_content=?, goo_image=?, goo_category=? where goo_id=?");
			pstmt.setString(1, goods.getGoo_name());
			pstmt.setInt(2, goods.getGoo_price());
			pstmt.setString(3, goods.getGoo_model());
			pstmt.setString(4, goods.getGoo_color());
			pstmt.setString(5, goods.getGoo_content());
			pstmt.setString(6, goods.getGoo_image());
			pstmt.setString(7, goods.getGoo_category());
			pstmt.setInt(8, goods.getGoo_id());
			modifyCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("modifyGoods 오류" + e);
		} finally {
			close(pstmt);
		}
		 return modifyCount;
	}
	
	public ArrayList<GoodsViewBean> selectGoodsStock(int page, int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsViewBean> goodsStockList = null;
		int startrow = (page-1) * 10;

		try {
			pstmt = con.prepareStatement("select g.goo_id, goo_image, goo_name, goo_category, goo_model, goo_color,"
					+ " goo_price, sum(sto_qty), sto_date from goods g left join stock s on g.goo_id = s.goo_id group by g.goo_id limit ?,10");
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				goodsStockList = new ArrayList<GoodsViewBean>();
				do {
					goodsStockList.add(new GoodsViewBean(rs.getInt("goo_id"), rs.getString("goo_image"),
							rs.getString("goo_name"), rs.getString("goo_category"),rs.getString("goo_model"),
							rs.getString("goo_color"), rs.getInt("sum(sto_qty)"), rs.getString("sto_date")));
				} while(rs.next());
			}
		} catch(SQLException e) {
			System.out.println("selectGoodsStock 오류" + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return goodsStockList;
	}
	
	public int goodsStockImport(StockBean stock) {
		PreparedStatement pstmt = null;
		int importResult = 0;
		try {
			pstmt = con.prepareStatement("insert into stock(goo_id, sto_import, sto_export, sto_qty, sto_date)"
					+ " values(?,?,null,?,?)");
			pstmt.setInt(1, stock.getGoo_id());
			pstmt.setString(2, stock.getSto_import());
			pstmt.setInt(3, stock.getSto_qty());
			pstmt.setString(4, stock.getSto_date());
			importResult = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("goodsStockImport 오류" + e);
		} finally {
			close(pstmt);
		}
		return importResult;
	}
	
	public int goodsStockExport(StockBean stock) {
		PreparedStatement pstmt = null;
		int importResult = 0;
		try {
			pstmt = con.prepareStatement("insert into stock(goo_id, sto_import, sto_export, sto_qty, sto_date)"
					+ " values(?,null,?,?,?)");
			pstmt.setInt(1, stock.getGoo_id());
			pstmt.setString(2, stock.getSto_export());
			pstmt.setInt(3, -stock.getSto_qty());
			pstmt.setString(4, stock.getSto_date());
			importResult = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("goodsStockExport 오류" + e);
		} finally {
			close(pstmt);
		}
		return importResult;
	}
	
	// 상품 리스트 개수 가져오기
	public int selectGoodsListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from goods");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getListCount 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	// 상품 리스트 담기
	public ArrayList<GoodsBean> selectGoodsArticleList(int page, int limit)	{
		ArrayList<GoodsBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement("select * from goods limit ?,10");
			pstmt.setInt(1,startrow);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<GoodsBean>();
				do {
					articleList.add(new GoodsBean(rs.getInt("goo_id"), rs.getString("goo_name"),
							rs.getInt("goo_price"),rs.getString("goo_model"),rs.getString("goo_color"),
							rs.getString("goo_content"),rs.getString("goo_image"),rs.getString("goo_date"),rs.getString("goo_category")));	
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getBoardList 에러" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	public ArrayList<GoodsBean> selectGoodsRank(){
		ArrayList<GoodsBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select g.goo_id, goo_name, goo_price, goo_image, sum(ord_qty), goo_category, goo_model from"
					+ " goods g inner join order_goods o on g.goo_id = o.goo_id group by goo_name order by sum(ord_qty) desc");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<GoodsBean>();
				do {
					articleList.add(new GoodsBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
				} while(rs.next());
			}
		} catch(Exception e) {
			System.out.println("selectGoodsRank 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return articleList;
	}
	
	public ArrayList<GoodsBean> selectGoodsNew(){
		ArrayList<GoodsBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select goo_id, goo_name, goo_price, goo_image, goo_date, goo_category, goo_model from"
					+ " goods group by goo_name order by goo_date desc, goo_id desc");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<GoodsBean>();
				do {
					articleList.add(new GoodsBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

				} while(rs.next());
			}
		} catch(Exception e) {
			System.out.println("selectGoodsNew 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return articleList;
	}
}
