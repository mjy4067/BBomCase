package admin_action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.AdminService;
import svc.GoodsService;
import vo.ActionForward;
import vo.GoodsBean;
import vo.GoodsViewBean;
import vo.PageInfo;

public class AdminGoodsStockFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 아님');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		ArrayList<GoodsBean> articleList = new ArrayList<GoodsBean>();
		int page = 1;
		int limit = 10;
		int limitPage = 3;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		GoodsService adminGoodsStockFormService = new GoodsService();
		AdminService adminGoodsListService = new AdminService();
		int listCount = adminGoodsListService.getListCount();
		int maxPage = (int)((double)listCount/limit+0.95);
		int startPage = (((int)((double)page/10+0.9))-1) * 10 + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		ArrayList<GoodsViewBean> adminStockList = adminGoodsStockFormService.getStockList(page, limit);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("adminStockList", adminStockList);
		request.setAttribute("pagefile", "/admin/goodsStockList.jsp");
		forward = new ActionForward("index.jsp", false);
		return forward;
	}

}
