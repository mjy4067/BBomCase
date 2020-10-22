package member_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.MemberService;
import vo.ActionForward;

public class MemberIdFindAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward = null;
		
		String name = request.getParameter("mem_name");
		String tel =  request.getParameter("telArea")+"-"+request.getParameter("mem_tel1")+"-"+request.getParameter("mem_tel2");
		String email = request.getParameter("mem_email")+"@"+request.getParameter("emailArea");
		
		MemberService memberService = new MemberService();
		String idFindResult = memberService.idFind(name, tel, email);
	
		if(idFindResult != null) {
			forward = new ActionForward();
			request.setAttribute("idFindResult", idFindResult);
			request.setAttribute("name", name);
			forward.setRedirect(false);
			forward.setPath("/member/idFindResult.jsp");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('입력하신 회원은 없습니다. 다시 입력해주세요')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}
}
