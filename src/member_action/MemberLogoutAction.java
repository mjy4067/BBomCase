package member_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class MemberLogoutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward = null;
		forward = new ActionForward();
		HttpSession session = request.getSession();
		
		session.removeAttribute("id");
		forward.setRedirect(true);
		forward.setPath("goodsMainAction.go");
		
		return forward;
	}
}
