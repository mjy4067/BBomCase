package goods_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.GoodsBean;

public class GoodsCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsCartAddService = new GoodsService();
		String name = request.getParameter("goo_name");
		String color = request.getParameter("goo_color");
		int qty = Integer.parseInt(request.getParameter("sto_qty"));
		GoodsBean cartGoods = goodsCartAddService.getCartGoods(name, color);
		goodsCartAddService.addCart(request, cartGoods, qty);
		ActionForward forward = new ActionForward("goodsCartListAction.go", true);
		return forward;
	}

}
