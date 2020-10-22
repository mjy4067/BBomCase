package goods_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.GoodsBean;

public class GoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsListService = new GoodsService();
		if(request.getParameter("goo_model") == null) {
			String category = request.getParameter("goo_category");
			ArrayList<GoodsBean> categoryList = goodsListService.getCategoryGoodsList(category);
			request.setAttribute("categoryList", categoryList);
		} else {
			String model = request.getParameter("goo_model");
			ArrayList<GoodsBean> goodsList = goodsListService.getGoodsList(model);
			request.setAttribute("goodsList", goodsList);
		}
		request.setAttribute("pagefile", "/goods/goodsList.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
