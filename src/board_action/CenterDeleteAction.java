package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;

public class CenterDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else {
			BoardService boardService = new BoardService();
			
			int cc_id = Integer.parseInt(request.getParameter("cc_id"));
			
			boolean centerDeleteRsult = boardService.centerDelete(cc_id);
			
			if(!centerDeleteRsult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패')");
				out.println("history.back();");
				out.println("</script>");
			} else {
				String page = request.getParameter("page");
				String path = "./centerListAction.bo?no_id="+cc_id+"&page="+page;
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제성공');");
				out.println("location.href=encodeURI('"+path+"');");
				out.println("</script>");
			}
		}
		
		return forward;
	}
}
