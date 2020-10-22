package board_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardQnaView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService boardService = new BoardService();
		int qna_id = Integer.parseInt(request.getParameter("qna_id"));
		BoardBean Qna = boardService.QnaView(qna_id);
		request.setAttribute("Qna", Qna);
		request.setAttribute("pagefile", "/board/QnaView.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
