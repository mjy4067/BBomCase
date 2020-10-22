package order_action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.OrderService;
import vo.ActionForward;

import vo.OrderBean;
import vo.OrderGoodsBean;
import vo.StockBean;


public class OrderAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("location.href='memberLogin.me?turn=ok';");
			out.println("</script>");
		}
		
		else {
			OrderService orderService = new OrderService();
			
			ArrayList<OrderGoodsBean> orderList = new ArrayList<OrderGoodsBean>();
			
		
			
			String goo_id[] = request.getParameterValues("goo_id");
			String ord_qty[] = request.getParameterValues("ord_qty");
			String ord_price[] = request.getParameterValues("ord_price");
			
			
			int ord_id = orderService.selectOrdId();
			
			for(int i=0; i<goo_id.length; i++) {
				orderList.add(new OrderGoodsBean(
								Integer.parseInt(goo_id[i]), ord_id,
								Integer.parseInt(ord_qty[i]), Integer.parseInt(ord_price[i]) ));
			}

			
			OrderBean order = new OrderBean();
			
			Date ord_date = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String ord_state = "주문완료";
			
			int ord_total = Integer.parseInt(request.getParameter("totalPrice"));
			String ord_tel = request.getParameter("telArea")+"-"+request.getParameter("ord_tel1")+"-"+request.getParameter("ord_tel2") ;
			String ord_email = request.getParameter("ord_email")+"@"+ request.getParameter("emailArea");
			
			order.setOrd_id(ord_id);
			order.setMem_id(request.getParameter("mem_id"));
			order.setReceiver(request.getParameter("receiver"));
			order.setOrd_tel(ord_tel);
			order.setOrd_email(ord_email);
			order.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
			order.setAddr1(request.getParameter("addr1"));
			order.setAddr2(request.getParameter("addr2"));
			order.setOrd_total(ord_total);
			order.setOrd_date(date.format(ord_date));
			order.setOrd_state(ord_state);
			order.setPayment(request.getParameter("payment"));
			
			
		
			ArrayList<StockBean> orderStock = new ArrayList<StockBean>();
			
			
			String sto_export = request.getParameter("mem_id");
			String sto_qty[] = request.getParameterValues("ord_qty");
			int sto_id = orderService.selectStoId();
			
			for(int i=0; i<goo_id.length; i++) {
				orderStock.add(new StockBean(
							sto_id, Integer.parseInt(goo_id[i]),
							sto_export, -Integer.parseInt(sto_qty[i]),
							date.format(ord_date)	));
			}	
			
		
			
			
			
			
			
			
			
			
			
			
			boolean orderResult = orderService.order(order, orderList, orderStock);
			
			if(orderResult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('주문이 완료되었습니다.');");
				out.println("location.href='myOrderList.od';");
				out.println("</script>");
			} else {
				try {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('주문이 실패 했습니다.');");
					out.println("history.back();");
					out.println("</script>");
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return forward;
	}
}
