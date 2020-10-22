package order_action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.OrderService;
import vo.ActionForward;

public class OrderStateAction implements Action  {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me?turn=ok';");
			out.println("</script>");
		}else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			OrderService orderService = new OrderService();
			
			String checks[];
			String ord_id;
			String ord_state;
			int updateCount=0;
			 
			ord_id = request.getParameter("ord_id");
			ord_state = request.getParameter("ord_state");
			
			if(request.getParameterValues("icheck") == null && ord_id == null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('선택된 주문이 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
			} else if(ord_id == null) {
				checks = request.getParameterValues("icheck");
				for(int i=0; i<checks.length; i++) {
					updateCount = orderService.orderStateChange(Integer.parseInt(checks[i]), ord_state);
				}
			} else {
				updateCount = orderService.orderStateChange(Integer.parseInt(ord_id), ord_state);
			}
			
			if(updateCount == 0) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('변경 실패.');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				if(ord_id == null) {
					forward = new ActionForward();
					forward.setRedirect(true);
					forward.setPath("orderList.od");
				} else {
					String path = "orderView.od?ord_id=" + ord_id;
					path = request.getParameter("upage") != null ? path 
					+ "&upage=" + request.getParameter("upage") + "&std=" + request.getParameter("std") 
					+ "&keyword=" + request.getParameter("keyword") : path + "&state=" + request.getParameter("state") 
					+ "&page=" + request.getParameter("page");
					
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("location.href=encodeURI('"+path+"');");
					out.println("</script>");
				}
			}
		}

		return forward;
	}
}
