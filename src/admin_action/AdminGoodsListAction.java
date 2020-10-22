package admin_action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.AdminService;
import vo.ActionForward;
import vo.GoodsBean;
import vo.PageInfo;

public class AdminGoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else if(!id.equals("admin")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 아님');");
			out.println("history.back();");
			out.println("</script>");
		} else {
		
		ArrayList<GoodsBean> articleList = new ArrayList<GoodsBean>();
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		AdminService adminGoodsListService = new AdminService();
		int listCount = adminGoodsListService.getListCount();
		articleList = adminGoodsListService.getArticleList(page, limit);
		int maxPage = (int)((double)listCount/limit+0.95);
		int startPage = (((int)((double)page / limitPage + 0.9)) -1) * limitPage + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		request.setAttribute("pagefile", "/admin/goodsList.jsp");
		forward = new ActionForward("index.jsp", false);
		}
		return forward;
	}

}
