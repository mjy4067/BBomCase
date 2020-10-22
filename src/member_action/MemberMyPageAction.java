package member_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.MemberService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberMyPageAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		MemberService memberService = new MemberService();
		MemberBean memberInfoResult = memberService.memberInfo(id);
		
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			request.setAttribute("memberInfoResult", memberInfoResult);
			request.setAttribute("pagefile", "/member/MyPage.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
		
		return forward;
	}

}
