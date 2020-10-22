package goods_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;

public class GoodsCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		GoodsService goodsCartQtyUpService = new GoodsService();
		goodsCartQtyUpService.upCartQty(request, name, color);
		ActionForward forward = new ActionForward("goodsCartListAction.go", true);
		return forward;
	}

}
