package member_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;
import svc.MemberService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberMyModifyAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		ActionForward forward = null;
		MemberBean member = new MemberBean();
		
		String tel = request.getParameter("telArea")+"-"+request.getParameter("mem_tel1")+"-"+request.getParameter("mem_tel2") ;
		String email = request.getParameter("mem_email")+"@"+ request.getParameter("emailArea");
		
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_pass(request.getParameter("mem_pass"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_tel(tel);
		member.setMem_birth(request.getParameter("mem_birth"));
		member.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
		member.setAddr1(request.getParameter("addr1"));
		member.setAddr2(request.getParameter("addr2"));
		member.setMem_date(request.getParameter("mem_date"));
		member.setMem_grade(request.getParameter("mem_grade"));
		member.setMem_email(email);
		
		MemberService memberService = new MemberService();
		boolean modifyResult = memberService.modify(member);
		
		if(modifyResult) {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정되었습니다.');");
			out.println("location.href='./memberMyPageAction.me';");
			out.println("</script>");
		} else {
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패.');");
				out.println("history.back();");
				out.println("</script>");
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return forward;
	}
}
