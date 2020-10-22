package goods_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.BoardBean;
import vo.GoodsBean;
import vo.PageInfo;

public class GoodsViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsViewService = new GoodsService();
		String name = request.getParameter("goo_name");
		int goo_id = Integer.parseInt(request.getParameter("goo_id"));
		GoodsBean goods = goodsViewService.getGoodsView(name);
		ArrayList<GoodsBean> list = goodsViewService.getGoodsViewName(name);
		ArrayList<BoardBean> qnaList = new ArrayList<BoardBean>();
		ArrayList<BoardBean> reviewList = new ArrayList<BoardBean>();
		
		int page = 1;
		int limit = 5;
				
		qnaList = goodsViewService.selectQnaList(page, goo_id);
		reviewList = goodsViewService.selectReviewList(page, goo_id);
		
		int q_listCount = goodsViewService.getQnaListCount(goo_id);
		int q_maxPage = (int)((double)q_listCount/limit+0.95);
		int q_startPage = (((int)((double)page/10+0.9))-1)*10+1;
		int q_endPage = q_startPage+10-1;
		if(q_endPage > q_maxPage) q_endPage = q_maxPage;

		int r_listCount = goodsViewService.getReviewListCount(goo_id);
		int r_maxPage = (int)((double)r_listCount/limit+0.95);
		int r_startPage = (((int)((double)page/10+0.9))-1)*10+1;
		int r_endPage = r_startPage+10-1;
		if(r_endPage > r_maxPage) r_endPage = r_maxPage;		
		
		PageInfo q_pageInfo = new PageInfo();
		q_pageInfo.setEndPage(q_endPage);
		q_pageInfo.setListCount(q_listCount);
		q_pageInfo.setMaxPage(q_maxPage);
		q_pageInfo.setPage(page);
		q_pageInfo.setStartPage(q_startPage);
		
		PageInfo r_pageInfo = new PageInfo();
		r_pageInfo.setEndPage(r_endPage);
		r_pageInfo.setListCount(r_listCount);
		r_pageInfo.setMaxPage(r_maxPage);
		r_pageInfo.setPage(page);
		r_pageInfo.setStartPage(r_startPage);
		
		request.setAttribute("q_pageInfo", q_pageInfo);
		request.setAttribute("r_pageInfo", r_pageInfo);
		request.setAttribute("qnaList", qnaList);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("goods", goods);
		request.setAttribute("list", list);
		request.setAttribute("pagefile", "/goods/goodsView.jsp");
		ActionForward forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
