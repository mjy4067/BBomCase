package board_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.NotifyBean;
import vo.PageInfo;

public class NotifyListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		
		ArrayList<NotifyBean> notifyList = new ArrayList<NotifyBean>();
		
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		int listCount = 10;
		
		if(request.getParameter("page")!=null&&!request.getParameter("page").equals("")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardService boardService = new BoardService();
		
		listCount = boardService.notifySelectCount();
		notifyList = boardService.notifySelectList(page);
		
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = (((int) ((double)page / limitPage + 0.9))- 1) * limitPage + 1;
		int endPage = startPage + limitPage - 1;
	
		if(endPage > maxPage) endPage = maxPage;
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(page);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("notifyList", notifyList);
		
		forward = new ActionForward();
		request.setAttribute("pagefile", "/board/notifyList.jsp");
		forward.setRedirect(false);
		forward.setPath("index.jsp");
	
		return forward;
		

		
	}

}
