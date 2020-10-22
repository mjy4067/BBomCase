package board_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.CenterBean;
import vo.PageInfo;

public class CenterListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ArrayList<CenterBean> centerList = new ArrayList<CenterBean>();
		
		String std = null;
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		int listCount = 10;
		
		if(request.getParameter("page")!=null&&!request.getParameter("page").equals("")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardService boardService = new BoardService();
		
		if(request.getParameter("std")!=null) {
			std = request.getParameter("std");
			request.setAttribute("std", std);
			
			if(std.equals("reply")) {
				listCount = boardService.centerReplyListCount("customercenter");
				centerList = boardService.centerSelectList("reply", page);
			} else if(std.equals("my")) {
				listCount = boardService.myArticleListCount("customercenter", id);
				centerList = boardService.centerSelectList(id, page);
			}
				 
		} else {
			listCount = boardService.selectListCount("customercenter");
			centerList = boardService.centerSelectList("not", page);
		}
		
		forward = new ActionForward();

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
		
		request.setAttribute("id", id);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("centerList", centerList);
		
		request.setAttribute("pagefile", "/board/centerList.jsp");
		forward.setRedirect(false);
		forward.setPath("index.jsp");
		
		return forward;
	}
	
}
