package goods_action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.Cart;

public class GoodsCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsCartRemoveService = new GoodsService();
		if(request.getParameter("item_code") == null) {
			String[] kindArray = request.getParameterValues("remove");
			goodsCartRemoveService.cartRemove(request, kindArray);		
		} else if(request.getParameter("item_code") != null){
			String item_code = request.getParameter("item_code");
			goodsCartRemoveService.cartRemove(request, item_code);
		} 
		
		
		if(goodsCartRemoveService == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제가 완료되었습니다.')");
			out.println("location.href='goodsCartListAction.go';");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("location.href='goodsCartListAction.go';");
			out.println("</script>");
			
		}
		ActionForward forward = new ActionForward("goodsCartListAction.go", true);
		return forward;
	}

}
