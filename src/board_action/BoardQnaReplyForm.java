package board_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardQnaReplyForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService boardService = new BoardService();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 아님');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		int qna_id = Integer.parseInt(request.getParameter("qna_id"));
		BoardBean Qna = boardService.QnaView(qna_id);
		request.setAttribute("Qna", Qna);
		request.setAttribute("pagefile", "/board/QnaReplyForm.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}

