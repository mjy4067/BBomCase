package goods_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.Cart;

public class GoodsCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsCartListService = new GoodsService();
		ArrayList<Cart> cartList = goodsCartListService.getCartList(request);
		
		int totalMoney = 0;
		int[] money = new int[cartList.size()];
		
		for(int i=0; i<cartList.size(); i++) {
			money[i] = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money[i];
		}
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("money", money);
		request.setAttribute("pagefile", "/goods/goodsCartList.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
