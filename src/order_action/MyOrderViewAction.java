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

public class MyOrderViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
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
		} else {
			forward = new ActionForward();
			
			int ord_id = Integer.parseInt(request.getParameter("ord_id"));
			OrderService orderService = new OrderService();
			OrderBean order = orderService.selectOrder(ord_id);
			
			ArrayList<OrderViewBean> orderList = orderService.orderGoodsList(ord_id);
			String page = request.getParameter("page");
			
			request.setAttribute("page", page);
			request.setAttribute("order", order);
			request.setAttribute("orderList", orderList);
			
			request.setAttribute("pagefile", "/order/myOrderView.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
		return forward;
	}
}
