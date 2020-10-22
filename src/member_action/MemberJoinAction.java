package member_action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.MemberService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		MemberBean member = new MemberBean();
		
		Date mem_date = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String tel = request.getParameter("telArea") + "-" + request.getParameter("mem_tel1") + "-" + request.getParameter("mem_tel2") ;
		String email = request.getParameter("mem_email") + "@" + request.getParameter("emailArea");
		String grade = "B";
		
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_pass(request.getParameter("mem_pass"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_tel(tel);
		member.setMem_birth(request.getParameter("mem_birth"));
		member.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
		member.setAddr1(request.getParameter("addr1"));
		member.setAddr2(request.getParameter("addr2"));
		member.setMem_date(date.format(mem_date));
		member.setMem_grade(grade);
		member.setMem_email(email);
		
		MemberService memberService = new MemberService();
		boolean joinResult = memberService.join(member);
		
		if(joinResult == false) {
			response.setCharacterEncoding("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('회원가입 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.me");
		}
	
		return forward;
	}
}
