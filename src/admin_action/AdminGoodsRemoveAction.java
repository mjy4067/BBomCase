package admin_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.AdminService;
import vo.ActionForward;

public class AdminGoodsRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService adminGoodsRemoveService = new AdminService();
		
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
		}
		
		boolean deleteResult = false;
		if(request.getParameter("goo_id") == null) {
			String[] kindArray = request.getParameterValues("remove");
			deleteResult = adminGoodsRemoveService.goodsRemove(kindArray);
		} else if(request.getParameter("goo_id") != null){
			int goo_id = Integer.parseInt(request.getParameter("goo_id"));
			deleteResult = adminGoodsRemoveService.goodsRemove(goo_id);
		}
		
		if(deleteResult) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 성공');");
			out.println("location.href='adminGoodsListAction.ad';");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("alert('재고량이 없는 상품만 삭제 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		ActionForward forward = null;
		return forward;
	}

}
