package board_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.NotifyBean;

public class NotifyViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		int no_id = Integer.parseInt(request.getParameter("no_id"));
		String page = request.getParameter("page");
		
		BoardService boardService = new BoardService();
		
		NotifyBean notify = boardService.notifySelect(no_id);
		
		if(id != null && id.equals("admin")) {
			
		} else {
			boardService.notifyHitsCount(no_id);
		}
		
		
		request.setAttribute("notify", notify);
		request.setAttribute("page", page);
		
		forward = new ActionForward();
		request.setAttribute("pagefile", "/board/notifyView.jsp");
		forward.setRedirect(false);
		forward.setPath("index.jsp");
		
		return forward;
		
		
	}
	
}
