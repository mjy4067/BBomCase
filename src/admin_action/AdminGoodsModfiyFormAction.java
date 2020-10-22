package admin_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.AdminService;
import vo.ActionForward;
import vo.GoodsBean;

public class AdminGoodsModfiyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService adminGoodsModifyFormService = new AdminService();
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
				
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 아님');");
			out.println("history.back();");
			out.println("</script>");
		} else {
		
		int goo_id = Integer.parseInt(request.getParameter("goo_id"));
		GoodsBean modify = adminGoodsModifyFormService.goodsModify(goo_id);
		request.setAttribute("modify", modify);
		request.setAttribute("pagefile", "/admin/goodsModify.jsp");
		forward = new ActionForward("index.jsp", false);
		}
		return forward;
	}

}
