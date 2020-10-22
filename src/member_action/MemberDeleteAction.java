package member_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;

import svc.MemberService;
import vo.ActionForward;

public class MemberDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		ActionForward forward = null;
		HttpSession session=request.getSession();
		
		String id = (String)session.getAttribute("id");
		String deleteId = request.getParameter("id");
		
		MemberService memberService = new MemberService();
		boolean deleteResult = memberService.delete(deleteId);
	
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아님')");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else {
			if(deleteResult) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("memberListAction.me");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패')");
				out.println("location.href='memberLogin.me';");
				out.println("</script>");
			}
		}
		
		return forward;
	}
	
}
