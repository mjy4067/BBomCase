package board_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

public class BoardQnaList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		BoardService boardService = new BoardService();
		int listCount = boardService.getQnaListCount();
		articleList = boardService.getQnaArticleList(page,limit);
		int maxPage = (int)((double)listCount/limit+0.95);
		int startPage = (((int)((double)page/10+0.9))-1)*10+1;
		int endPage = startPage+10-1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		request.setAttribute("pagefile", "/board/QnaList.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
