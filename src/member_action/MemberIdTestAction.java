package member_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.MemberService;
import vo.ActionForward;

public class MemberIdTestAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		
		String id = request.getParameter("id");
		
		MemberService memberService = new MemberService();
		boolean idTestResult = memberService.idTest(id);
		
		forward = new ActionForward();
		request.setAttribute("idTestresult", idTestResult);
		request.setAttribute("id", id);		
		forward.setRedirect(false);
		forward.setPath("/member/dupliForm.jsp");
		
		return forward;
	}
}
