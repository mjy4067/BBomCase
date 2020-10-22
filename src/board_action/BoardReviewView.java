package board_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReviewView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService boardService = new BoardService();
		int review_id = Integer.parseInt(request.getParameter("review_id"));
		BoardBean Review = boardService.ReviewView(review_id);
		request.setAttribute("Review", Review);
		request.setAttribute("pagefile", "/board/ReviewView.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
