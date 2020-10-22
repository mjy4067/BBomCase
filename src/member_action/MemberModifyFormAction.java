package member_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.MemberService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModifyFormAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	throws Exception{
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		String modifyId = request.getParameter("id");
		
		MemberService memberService = new MemberService();
		MemberBean memberInfoResult = memberService.memberInfo(modifyId);
		
		if(id==null) {
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
			out.println("alert('권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			
			String tel = memberInfoResult.getMem_tel();
			String tels[] = new String[3];
			tels = tel.split("-");
			String email = memberInfoResult.getMem_email();
			String emails[] = new String[2];
			emails = email.split("@");
			
			request.setAttribute("tel1", tels[0]);
			request.setAttribute("tel2", tels[1]);
			request.setAttribute("tel3", tels[2]);
			request.setAttribute("email1", emails[0]);
			request.setAttribute("email2", emails[1]);
			request.setAttribute("memberInfoResult", memberInfoResult);
			
			request.setAttribute("pagefile", "/admin/memberModifyForm.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
		
		return forward;
	}
}
