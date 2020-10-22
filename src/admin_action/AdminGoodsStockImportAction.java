package admin_action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.AdminService;
import vo.ActionForward;
import vo.StockBean;

public class AdminGoodsStockImportAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService goodsImport = new AdminService();
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
				
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
		}
		
		int importResult = 0;
		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sf.format(nowTime);
		StockBean stock = new StockBean(0, Integer.parseInt(request.getParameter("goo_id")),
				request.getParameter("sto_import"), null, Integer.parseInt(request.getParameter("sto_qty")), date);
		importResult = goodsImport.goodsStockImport(stock);
		
		if(importResult > 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록성공, 새로 고침 해주세요.');");
			out.println("window.close();");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패. 다시 입력하세요!');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
