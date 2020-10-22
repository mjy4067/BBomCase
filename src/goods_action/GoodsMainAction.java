package goods_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.GoodsBean;

public class GoodsMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsMainService = new GoodsService();
		ArrayList<GoodsBean> goodsRankList = goodsMainService.goodsRank();
		ArrayList<GoodsBean> goodsNewList = goodsMainService.goodsNew();
		ArrayList<GoodsBean> goodsAllList = goodsMainService.goodsList();
		
		request.setAttribute("goodsAllList", goodsAllList);
		request.setAttribute("goodsRankList", goodsRankList);
		request.setAttribute("goodsNewList", goodsNewList);
		ActionForward forward = new ActionForward("main.jsp", false);
		return forward;
	}

}
