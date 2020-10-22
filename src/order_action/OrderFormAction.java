package order_action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.CartService;
import svc.GoodsService;
import svc.MemberService;
import vo.ActionForward;
import vo.Cart;
import vo.GoodsBean;
import vo.MemberBean;
import vo.OrderViewBean;

public class OrderFormAction implements Action {
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
		} else if(request.getParameterValues("remove") == null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('선택상품이 없습니다.')");
			out.println("location.href='goodsCartListAction.go';");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			
			
			CartService cartService = new CartService();
			GoodsService goodsService = new GoodsService();
			
			ArrayList<OrderViewBean> orderList = new ArrayList<OrderViewBean>(); 
			
			
					
			ArrayList<Cart> cartList = cartService.cartList(request);
			GoodsBean goods = null;
			String codes[] = null;
			
			if(request.getParameter("type").equals("all")) {
				for(int i=0;i<cartList.size();i++) {
					orderList.add(new OrderViewBean(cartList.get(i).getItem_code(),
								cartList.get(i).getImage(), cartList.get(i).getColor(),
								cartList.get(i).getName(), cartList.get(i).getPrice(),
								cartList.get(i).getQty() ));
				}
			} else if(request.getParameter("type").equals("sel")) {
				codes = request.getParameterValues("remove");
				for(int i=0;i<cartList.size();i++) {
					System.out.println(request.getParameter("remove"));
					
					
					for(int j=0;j<codes.length;j++) {
						
						if(cartList.get(i).getItem_code().equals(codes[j]))
							orderList.add(new OrderViewBean(cartList.get(i).getItem_code(),
								cartList.get(i).getImage(), cartList.get(i).getColor(),
								cartList.get(i).getName(), cartList.get(i).getPrice(),
								cartList.get(i).getQty() ));
						
					} 
				}
			}else if(request.getParameter("type").equals("one")) {
				
				String goo_name = request.getParameter("goo_name");
				String goo_color = request.getParameter("goo_color");
				int qty = Integer.parseInt(request.getParameter("sto_qty"));
				
				goods = goodsService.orderGoods(goo_name, goo_color);
				
				
				orderList.add(new OrderViewBean(
						goods.getGoo_id(), goods.getGoo_name(), 
						goods.getGoo_price(), goods.getGoo_model(), 
						goods.getGoo_color(), goods.getGoo_image(),
						qty ));
				
				
						
			}
			
			int totalCart = 0;
			for(int i=0; i<orderList.size(); i++ ) {
				totalCart += orderList.get(i).getPrice() * orderList.get(i).getQty();
			}
			
			
			
			MemberService memberService = new MemberService();
			MemberBean memberInfoResult = memberService.memberInfo(id);
			
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

			
			request.setAttribute("memberInfoResult", memberInfoResult);
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalCart", totalCart);

			
			request.setAttribute("pagefile", "/order/orderForm.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
		
		return forward;
	}
}
