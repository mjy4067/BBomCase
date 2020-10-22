package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.BoardBean;
import vo.CenterBean;
import vo.NotifyBean;

import static db.JdbcUtil.*;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private static BoardDAO boardDAO;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// Qna 개수 가져오기
	public int selectQnaListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from qna");
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
	
	// Qna 리스트 가져오기
	public ArrayList<BoardBean> selectQnaArticleList(int page, int limit)	{
		ArrayList<BoardBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement("select qna_id, g.goo_id, goo_name, mem_id, qna_title, qna_content,"
					                   + " qna_image, qna_date, qna_hits, qna_secret, qna_reply from qna q left join goods g on g.goo_id = q.goo_id order by qna_id limit ?,10");
			pstmt.setInt(1,startrow);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				articleList = new ArrayList<BoardBean>();
			do {
				articleList.add(new BoardBean(rs.getInt("qna_id"),rs.getInt("goo_id"),
						rs.getString("mem_id"),rs.getString("qna_title"),
						rs.getString("qna_content"),rs.getString("qna_image"),rs.getString("qna_date"),
						rs.getInt("qna_hits"),rs.getInt("qna_secret"),rs.getString("qna_reply")));
			}
			while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getBoardList 에러" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	// Qna 등록하기
	public int insertQna(BoardBean board) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "insert into qna(goo_id, mem_id, qna_title, qna_content, qna_image, "
					+ "qna_date, qna_hits, qna_secret, qna_reply) values(?, ?, ?, ?, ?, ?, 0, ?, null)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getGoo_id());
			pstmt.setString(2, board.getMem_id());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getImage());
			pstmt.setString(6, board.getDate());
			pstmt.setInt(7, board.getSecret());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertQna 오류" + e);
		} finally{
			close(pstmt);
		}
		return insertCount;
	} 
	
	// 문의 리스트 가져오기
	public BoardBean selectQna(int qna_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean Qna = null;
		
		try {
			pstmt = con.prepareStatement("select * from qna where qna_id=?");
			pstmt.setInt(1, qna_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Qna = new BoardBean(rs.getInt("qna_id"), rs.getInt("goo_id"), rs.getString("mem_id"), rs.getString("qna_title"),
						  rs.getString("qna_content"), rs.getString("qna_image"),rs.getString("qna_date"),
						  rs.getInt("qna_hits"), rs.getInt("qna_secret"),rs.getString("qna_reply"));
			}
		} catch(SQLException e) {
			System.out.println("selectQna 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return Qna;
	}
	
	// 문의 삭제하기
	public int removeQna(int qna_id, String id) {
		PreparedStatement pstmt = null;
		int removeCount = 0;
		String sql = "delete from qna where qna_id=?";
		String sql2 = "delete from qna where qna_id=? and mem_id=?";

		try {
			if(((id.equals("admin")) && (id != null))) {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, qna_id);
					removeCount = pstmt.executeUpdate();
			} else {
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, qna_id);
				pstmt.setString(2, id);
				removeCount = pstmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println("removeQna 에러 " + e);
		} finally {
			close(pstmt);
		}
	return removeCount;
	}
	
	// 문의 답변 업데이트 
	public boolean updateQna(int qna_id, String qna_reply) {
		PreparedStatement pstmt = null;
		boolean updateSuccess = false;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement("update qna set qna_reply=? where qna_id=?");
			pstmt.setString(1, qna_reply);
			pstmt.setInt(2, qna_id);
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				updateSuccess = true;
			}
		} catch(SQLException e) {
			System.out.println("updateQna 오류 " + e);
		} finally {
			close(pstmt);
		}
		return updateSuccess;
	}
	
	// 조회수 업데이트
	public int updateReadCountQna(int qna_id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update qna set qna_hits=qna_hits+1 where qna_id="+qna_id;
		
		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateReadCount 에러 " + e);
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	} 
	

	// Review 개수 가져오기
	public int selectReviewListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from review");
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
	
	// Review 리스트 가져오기
	public ArrayList<BoardBean> selectReviewArticleList(int page, int limit)	{
		ArrayList<BoardBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement("select rev_id, g.goo_id, goo_name, mem_id, rev_title, rev_content,"
					                   + " rev_image, rev_date, rev_hits from review r left join goods g on g.goo_id = r.goo_id order by rev_id limit ?,10");
			pstmt.setInt(1,startrow);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				articleList = new ArrayList<BoardBean>();
				do {
					articleList.add(new BoardBean(rs.getInt("rev_id"), rs.getInt("goo_id"), rs.getString("goo_name"),
							rs.getString("mem_id"),rs.getString("rev_title"),rs.getString("rev_content"),
							rs.getString("rev_image"), rs.getString("rev_date"),rs.getInt("rev_hits")));
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
	
	// Review 등록하기
	public int insertReview(BoardBean board) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "insert into review(goo_id, mem_id, rev_title, rev_content, rev_image, "
					+ "rev_date, rev_hits) values(?, ?, ?, ?, ?, ?, 0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getGoo_id());
			pstmt.setString(2, board.getMem_id());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getImage());
			pstmt.setString(6, board.getDate());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertReview 오류" + e);
		} finally{
			close(pstmt);
		}
		return insertCount;
	}
	
	// Review 검색 결과 가져오기
	public BoardBean selectReview(int review_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean Review = null;
		
		try {
			pstmt = con.prepareStatement("select rev_id, g.goo_id, goo_name, mem_id, rev_title, rev_content,"
	                   + " rev_image, rev_date, rev_hits from review r inner join goods g on g.goo_id = r.goo_id and rev_id=?");
			pstmt.setInt(1, review_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Review = new BoardBean(rs.getInt("rev_id"),rs.getInt("goo_id"),rs.getString("goo_name"),
						rs.getString("mem_id"),rs.getString("rev_title"),rs.getString("rev_content"),rs.getString("rev_image"),
						rs.getString("rev_date"),rs.getInt("rev_hits"));
			}
		} catch(SQLException e) {
			System.out.println("selectQna 오류 " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return Review;
	}
	
	// 조회수 업데이트
	public int updateReadCountReview(int review_id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update review set rev_hits=rev_hits+1 where rev_id="+review_id;
		
		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateReadCount 에러 " + e);
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	} 
	
	// Review 삭제하기
	public int removeReview(int rev_id, String id) {
		PreparedStatement pstmt = null;
		int removeCount = 0;
		String sql = "delete from review where rev_id=?";
		String sql2 = "delete from review where rev_id=? and mem_id=?";
		
		try {
			if(((id.equals("admin")) && (id != null))) {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rev_id);
				removeCount = pstmt.executeUpdate();
			} else {
				pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, rev_id);
				pstmt.setString(2, id);
				removeCount = pstmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println("removeReview 에러 " + e);
		} finally {
			close(pstmt);
		}
	return removeCount;
	}
	
	public int selectQnaListCount(int goo_id) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from qna where goo_id=?");
			pstmt.setInt(1, goo_id);
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
	
	public int selectReviewListCount(int goo_id) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from review where goo_id=?");
			pstmt.setInt(1, goo_id);
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
	
	public ArrayList<BoardBean> selectQnaList(int page, int goo_id)	{
		ArrayList<BoardBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement("select qna_id, goo_id, substring(mem_id,1,3), qna_title, qna_content, qna_image, qna_date, qna_hits,"
					+ " qna_secret, qna_reply from qna where goo_id =? order by qna_id");
			pstmt.setInt(1, goo_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardBean>();
					do {	
						articleList.add(new BoardBean(rs.getInt(1),rs.getInt(2),
							rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6),rs.getString(7),
							rs.getInt(8),rs.getInt(9),rs.getString(10)));
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
	
	public ArrayList<BoardBean> selectReviewList(int page, int goo_id) {
		ArrayList<BoardBean> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startrow = (page-1) * 10;
		
		try {
			pstmt = con.prepareStatement("select rev_id, g.goo_id, goo_name, substring(mem_id,1,3) mem_id, rev_title, rev_content, rev_image, rev_date, rev_hits"
					+ " from goods g, review r where g.goo_id = r.goo_id and r.goo_id=? order by rev_id");
				pstmt.setInt(1, goo_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardBean>();
				do {
					articleList.add(new BoardBean(rs.getInt("rev_id"),rs.getInt("goo_id"),rs.getString("goo_name"),
							rs.getString("mem_id"),rs.getString("rev_title"),rs.getString("rev_content"),rs.getString("rev_image"),
							rs.getString("rev_date"),rs.getInt("rev_hits")));
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
	
	//공지 리스트 갯수
	public int notifySelectCount() {
		String sql = "select count(*) from notify";
		int listCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	//공지 리스트 정렬
	public ArrayList<NotifyBean> notifySelectList(int page) {
		String sql = "select no_id, no_title, mem_name, no_date, no_hits from notify order by no_id desc limit ?, 10 ";
		ArrayList<NotifyBean> articleList = new ArrayList<NotifyBean>();
		NotifyBean board = null;
		int startrow = (page - 1) * 10;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new NotifyBean(rs.getInt("no_id"), rs.getString("no_title"), rs.getString("mem_name"),
						rs.getString("no_date"), rs.getInt("no_hits"));
				articleList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	//공지 번호 올리는 기능
	public int notifyNum(String notifyName) {
		String sql = "select max(no_id) from " + notifyName;
		int notifyNum = 1;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				notifyNum = rs.getInt(1) + 1;

			else
				notifyNum = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return notifyNum;
	}
	
	
	//공지 글쓰기 입력
	public int notifyWrite(NotifyBean notify) {
		String sql = "insert into notify values(?,?,?,?,?,now(),?)";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notify.getNo_id());
			pstmt.setString(2, notify.getMem_name());
			pstmt.setString(3, notify.getNo_title());
			pstmt.setString(4, notify.getNo_content());
			pstmt.setString(5, notify.getNo_image());
			pstmt.setInt(6, notify.getNo_hits());

			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	//공지 내용 보기 or 수정 폼으로 불러오기
	public NotifyBean notifySelect(int no_id) {
		String sql = "select * from notify where no_id = ?";
		NotifyBean notify = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				notify = new NotifyBean(rs.getInt("no_id"), rs.getString("mem_name"), rs.getString("no_title"),
						rs.getString("no_content"), rs.getString("no_image"), rs.getString("no_date"),
						rs.getInt("no_hits"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return notify;
	}
	
	// 조회수 올리는 기능
		public int notifyHitsCount(int no_id) {
			String sql = "update notify set no_hits = no_hits + 1 where no_id = ?";
			int hitsCount = 0;

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no_id);
				hitsCount = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return hitsCount;
		}
	
	
	// 공지 수정기능
	public int notifyModify(NotifyBean notify) {
		String sql = "update notify set no_title = ?, no_content = ?, no_image = ? where no_id = ?";
		int modifyCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notify.getNo_title());
			pstmt.setString(2, notify.getNo_content());
			pstmt.setString(3, notify.getNo_image());
			pstmt.setInt(4, notify.getNo_id());

			modifyCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modifyCount;
	}
	
	// 공지 삭제 기능
	public int notifyDelete(int no_id) {
		String sql = "delete from notify where no_id = ?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no_id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	
	
	// 고객센터 ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
 	
	// 미답변 리스트
	public int centerReplyListCount(String center) {
		String sql = "select count(*) from " + center + " where re_step = 1 and has_re = 0 ";
		int listCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	//게시판 리스트 정렬
	public ArrayList<CenterBean> centerSelectList(String type, int page) {
		String insert = type.equals("reply") ? " and has_re = 0"
				: (type.equals("not") ? "" : " and mem_id = '" + type + "'");
		String sql = "select cc_id, mem_id, cc_title, cc_date, has_re, re_lev, re_step, cc_secret from customercenter where re_step = 1 "
				+ insert + " order by re_lev desc, re_step asc limit ?, 10";
		ArrayList<CenterBean> articleList = new ArrayList<CenterBean>();
		CenterBean board = null;
		int startrow = (page - 1) * 10;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new CenterBean(rs.getInt("cc_id"), rs.getString("mem_id"), rs.getString("cc_title"),
						rs.getString("cc_date"), rs.getInt("has_re"), rs.getInt("re_lev"), rs.getInt("re_step"),
						rs.getString("cc_secret"));
				articleList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	// 자기 글 리스트
	public int myArticleListCount(String board, String id) {
		String sql = "select count(*) from " + board + " where re_step = 1 and mem_id = ?";
		int listCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	// 게시판  리스트
	public int selectListCount(String board) {
		String sql = "select count(*) from " + board + " where re_step=1";
		int listCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	//고객센터 내용 보기
	public CenterBean centerSelect(int cc_id) {
		String sql = "select * from customercenter where cc_id = ?";
		CenterBean center = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cc_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				center = new CenterBean(rs.getInt("cc_id"), rs.getString("mem_id"), rs.getString("cc_title"),
						rs.getString("cc_content"), rs.getString("cc_image"), rs.getString("cc_date"),
						rs.getInt("has_re"), rs.getInt("re_lev"), rs.getInt("re_step"), rs.getString("cc_secret"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return center;
	}
	
	//고객센터 답변 내용 보기
	public CenterBean selectCenterReply(int re_lev) {
		String sql = "select * from customercenter where re_lev = ? and re_step = 2";
		CenterBean center = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_lev);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				center = new CenterBean(rs.getInt("cc_id"), rs.getString("mem_id"), rs.getString("cc_title"),
						rs.getString("cc_content"), null, rs.getString("cc_date"), rs.getInt(7), re_lev, 2, null);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return center;
	}
	
	//고객센터 번호 올리는 기능
	public int centerNum() {
		String sql = "select max(cc_id) from customercenter";
		int centerNum = 1;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				centerNum = rs.getInt(1) + 1;

			else
				centerNum = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return centerNum;
	}
	
	
	
	//고객센터 글쓰기 
	public int centerWrite(CenterBean center) {
		String sql = "insert into customercenter values (?,?,?,?,?,now(),?,?,?,?)";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, center.getCc_id());
			pstmt.setString(2, center.getMem_id());
			pstmt.setString(3, center.getCc_title());
			pstmt.setString(4, center.getCc_content());
			pstmt.setString(5, center.getCc_image());
			pstmt.setInt(6, center.getHas_re());
			pstmt.setInt(7, center.getRe_lev());
			pstmt.setInt(8, center.getRe_step());
			pstmt.setString(9, center.getCc_secret());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	//답변 입력 기능
	public int centerReply(CenterBean center) {
		String sql =  "";
		int insertCount = 0;
		int re_lev = center.getRe_lev();
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			sql = "update customercenter set has_re = has_re + 1 where re_lev = ?";
			
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setInt(1, re_lev);
			
			int updateCount = pstmt1.executeUpdate();
			
			if(updateCount > 0) {
				commit(con);
			}
			
			sql = "insert into customercenter values(?,?,?,?,?,now(),0,?,?,?)";
			
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, center.getCc_id());
			pstmt2.setString(2, center.getMem_id());
			pstmt2.setString(3, center.getCc_title());
			pstmt2.setString(4, center.getCc_content());
			pstmt2.setString(5, center.getCc_image());
			pstmt2.setInt(6, re_lev);
			pstmt2.setInt(7, 2);
			pstmt2.setString(8, center.getCc_secret());
			
			insertCount = pstmt2.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		return insertCount;
	}
	
	//고객센터 삭제 기능
	public int centerDelete(int cc_id) {
		String sql = "delete from customercenter where cc_id = ?";
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cc_id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}
}