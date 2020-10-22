package order_action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.OrderService;
import vo.ActionForward;
import vo.OrderBean;
import vo.OrderViewBean;

public class OrderViewAction implements Action {
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
			forward = new ActionForward();
			
			int ord_id = Integer.parseInt(request.getParameter("ord_id"));
			
			OrderService orderService = new OrderService();
			OrderBean order = orderService.selectOrder(ord_id);
			
			ArrayList<OrderViewBean> orderList = orderService.orderGoodsList(ord_id);
			
			if(request.getParameter("upage") != null) {
				request.setAttribute("upage", request.getParameter("upage"));
				request.setAttribute("std", request.getParameter("std"));
				request.setAttribute("keyword", request.getParameter("keyword"));
			}
			if(request.getParameter("state") != null) request.setAttribute("state", request.getParameter("state"));
			String page = request.getParameter("page");

			request.setAttribute("page", page);
			request.setAttribute("order", order);
			request.setAttribute("orderList", orderList);
			
			request.setAttribute("pagefile", "/admin/orderView.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
	
		return forward;
	}
}
