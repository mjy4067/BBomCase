package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;

public class BoardQnaRemove implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qna_id = Integer.parseInt(request.getParameter("qna_id"));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id==null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		}
		
		BoardService boardService = new BoardService();
		boolean isRemoveSuccess = boardService.removeQna(qna_id, id);
		
		ActionForward forward = null;
		if(!isRemoveSuccess) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제성공');");
			out.println("location.href='boardQnaList.bo';");
			out.println("</script>");
		}
		return forward;
	}

}
