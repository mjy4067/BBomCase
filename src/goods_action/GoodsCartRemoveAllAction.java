package goods_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;

public class GoodsCartRemoveAllAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsCartRemoveAllService = new GoodsService();
	goodsCartRemoveAllService.cartRemove(request);
	
	ActionForward forward = new ActionForward("goodsCartListAction.go", true);
	return forward;
	}
}
