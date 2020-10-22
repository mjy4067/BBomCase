package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;
import vo.CenterBean;
import vo.NotifyBean;

public class BoardService {

	public int getQnaListCount() throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectQnaListCount();
		close(con);
		return listCount;
	}
	
	public ArrayList<BoardBean> getQnaArticleList(int page, int limit) throws Exception{
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectQnaArticleList(page, limit);
		close(con);
		return articleList;
	}
	
	public boolean registQna(BoardBean board) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = boardDAO.insertQna(board);
		
		if(insertCount > 0) {
			commit(con);
			isRegistSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}
	
	public BoardBean QnaView(int qna_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCountQna(qna_id);
		BoardBean Qna = boardDAO.selectQna(qna_id);
		
		if(updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return Qna;
	}
	
	public boolean removeQna(int qna_id, String id) {
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.removeQna(qna_id, id);
		
		if(deleteCount > 0) {
			commit(con);
			isRemoveSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
	
	public BoardBean getQna(int qna_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		BoardBean Qna = boardDAO.selectQna(qna_id);
		
		close(con);
		return Qna;
	}
	
	public boolean updateQna(int qna_id, String qna_reply) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean updateSuccess = boardDAO.updateQna(qna_id, qna_reply);
		
		if(updateSuccess) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return updateSuccess;
	}
	
	public int getReviewListCount() throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectReviewListCount();
		close(con);
		return listCount;
	}
	
	public ArrayList<BoardBean> getReviewArticleList(int page, int limit) throws Exception{
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectReviewArticleList(page, limit);
		close(con);
		return articleList;
	}
	
	public boolean registReview(BoardBean board) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = boardDAO.insertReview(board);
		
		if(insertCount > 0) {
			commit(con);
			isRegistSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isRegistSuccess;
	}
	
	public BoardBean ReviewView(int review_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCountReview(review_id);
		BoardBean Qna = boardDAO.selectReview(review_id);
		
		if(updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return Qna;
	}
	
	public boolean removeReview(int rev_id, String id) {
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.removeReview(rev_id, id);
		
		if(deleteCount > 0) {
			commit(con);
			isRemoveSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
	
	public boolean notifyWrite(NotifyBean notify) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean notifyWriteResult = false;
		int insertCount = boardDAO.notifyWrite(notify);
		
		if(insertCount>0) {
			commit(con);
			notifyWriteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return notifyWriteResult;
	}
	
	public boolean centerWrite(CenterBean center) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean centerWriteResult = false;
		int insertCount = boardDAO.centerWrite(center);
		
		if(insertCount>0) {
			commit(con);
			centerWriteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return centerWriteResult;
	}
	
	public int notifySelectCount() {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int listCount = boardDAO.notifySelectCount();
		
		close(con);
		return listCount;
	}
	
	public ArrayList<NotifyBean> notifySelectList(int page) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<NotifyBean> list = boardDAO.notifySelectList(page);
		
		close(con);
		return list;
	}
	
	public int notifyNum(String notifyName) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int notifyNum = boardDAO.notifyNum(notifyName);
		
		close(con);
		return notifyNum;
	}
	
	public int centerNum() {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int centerNum = boardDAO.centerNum();
		
		close(con);
		return centerNum;
	}
	
	public NotifyBean notifySelect(int no_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		NotifyBean notify = boardDAO.notifySelect(no_id);
		
		close(con);
		return notify;
	}
	
	public CenterBean centerSelect(int cc_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		CenterBean center = boardDAO.centerSelect(cc_id);
		
		close(con);
		return center;
	}
	
	public int notifyHitsCount (int no_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int hitsCount = boardDAO.notifyHitsCount(no_id);
		
		if(hitsCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return hitsCount;
	}
	
	public boolean notifyDelete(int no_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean notifyDeleteResult = false;
		int deleteCount = boardDAO.notifyDelete(no_id);
		
		if(deleteCount > 0) {
			commit(con);
			notifyDeleteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return notifyDeleteResult;
	}
	
	public boolean centerDelete(int cc_id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean centerDeleteResult = false;
		int deleteCount = boardDAO.centerDelete(cc_id);
		
		if(deleteCount > 0) {
			commit(con);
			centerDeleteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return centerDeleteResult ;
	}
	
	public boolean notifyModify(NotifyBean notify) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean notifyModifyResult = false;
		int modifyCount = boardDAO.notifyModify(notify);
		
		if(modifyCount > 0) {
			commit(con);
			notifyModifyResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return notifyModifyResult;
	}
	
	public int centerReplyListCount(String center) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int listCount = boardDAO.centerReplyListCount(center);
		
		close(con);
		return listCount;
	}
	
	public ArrayList<CenterBean> centerSelectList(String type, int page){
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<CenterBean> articleList = boardDAO.centerSelectList(type, page);
		
		close(con);
		return articleList;
	}
	
	public int myArticleListCount(String board, String id) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int listCount = boardDAO.myArticleListCount(board, id);
		
		close(con);
		return listCount;
	}
	
	public int selectListCount(String board) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int listCount = boardDAO.selectListCount(board);
		
		close(con);
		return listCount;
	}
	
	public CenterBean selectCenterReply(int re_lev) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		CenterBean center = boardDAO.selectCenterReply(re_lev);
		
		close(con);
		return center;
	}
	
	public boolean centerReply(CenterBean center) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean centerReplyResult = false;
		int insertCount = boardDAO.centerReply(center);
		
		if(insertCount > 0) {
			commit(con);
			centerReplyResult = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return centerReplyResult;
	}
}
