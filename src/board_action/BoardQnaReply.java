package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;

public class BoardQnaReply implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int qna_id = Integer.parseInt(request.getParameter("qna_id"));
		String qna_reply = request.getParameter("qna_reply");

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");

		if(id == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인하세요.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		}
		
		BoardService boardService = new BoardService();
		boolean updateSuccess = boardService.updateQna(qna_id, qna_reply);
		
		if(updateSuccess) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록성공');");
			out.println("location.href='boardQnaList.bo';");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}
}
