package member_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;

import svc.MemberService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward = null;
		HttpSession session=request.getSession();
		MemberBean member=new MemberBean();
		
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_pass(request.getParameter("mem_pass"));
		
		MemberService memberService = new MemberService();
		boolean loginResult = memberService.login(member);
		
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getMem_id());
			forward.setRedirect(true);
			if(member.getMem_id().equals("admin")) {
				forward.setRedirect(true);
				forward.setPath("goodsMainAction.go");
			} else {
				forward.setRedirect(true);
				forward.setPath("goodsMainAction.go");
			}	
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("location.href='./memberLogin.me';");
			out.println("</script>");
		}
		
		return forward;
	}
}

