package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.NotifyBean;

public class NotifyModifyFormAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me?turn=ok';");
			out.println("</script>");
		} else if (!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			BoardService boardService = new BoardService();
			
			int no_id = Integer.parseInt(request.getParameter("no_id"));
			String page = request.getParameter("page");
			
			NotifyBean notify = boardService.notifySelect(no_id);
		
			request.setAttribute("page", page);
			request.setAttribute("notify", notify);
			
			forward = new ActionForward();
			request.setAttribute("pagefile", "/board/notifyModifyForm.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
			
		}
		return forward;
	}
}
