package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.CenterBean;

public class CenterReplyAction implements Action {
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
		} else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			BoardService boardService = new BoardService();
			
			int cc_id = Integer.parseInt(request.getParameter("cc_id"));
			int re_id = boardService.centerNum();
			
			CenterBean parent = boardService.centerSelect(cc_id);
			
			
			CenterBean center = new CenterBean(
					re_id,
					id,
					request.getParameter("cc_title"),
					request.getParameter("cc_content"),
					"",
					null,
					0,
					parent.getRe_lev(),
					2,
					parent.getCc_secret()
					);
			
			
			
			
			
			boolean centerReplyResult = boardService.centerReply(center);
			
			if(centerReplyResult) {
				String path = "./centerViewAction.bo?cc_id=" +cc_id+ "&page="+request.getParameter("page");
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록되었습니다.');");
				out.println("location.href=encodeURI('"+path+"');");
				out.println("</script>");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패');");
				out.println("history.back();");
				out.println("</script>");
			}
					
			
		}
		
		
		
		
		
		
		return forward;
		
		
	}
}
