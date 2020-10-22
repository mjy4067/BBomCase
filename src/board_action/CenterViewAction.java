package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.CenterBean;

public class CenterViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		int cc_id = Integer.parseInt(request.getParameter("cc_id"));
		
		BoardService boardService = new BoardService();
		CenterBean center = boardService.centerSelect(cc_id);
		CenterBean centerReply = boardService.selectCenterReply(center.getRe_lev());
		
		forward = new ActionForward();
		
		
		if(center.getCc_secret().equals("hide")) {
			if(center.getMem_id().equals(id) || id.equals("admin")) {
				
				
				
				request.setAttribute("center", center);
				request.setAttribute("centerReply", centerReply);
				
				String page = request.getParameter("page");
				
				request.setAttribute("page", page);
				
				request.setAttribute("pagefile", "/board/centerView.jsp");
				forward.setRedirect(false);
				forward.setPath("index.jsp");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀글입니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
				
		} else {
			request.setAttribute("center", center);
			request.setAttribute("centerReply", centerReply);
			
			String page = request.getParameter("page");
			
			request.setAttribute("page", page);
			
			request.setAttribute("pagefile", "/board/centerView.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
		
		return forward;
	}
}
