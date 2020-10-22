package goods_action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.GoodsService;
import vo.ActionForward;
import vo.GoodsBean;
import vo.StockBean;

public class GoodsRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsService goodsRegistService = new GoodsService();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "utf-8";
		int maxSize = 5 * 1024 * 1024;

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("goo_image");

		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sf.format(nowTime);

		GoodsBean goods = new GoodsBean(Integer.parseInt(multi.getParameter("goo_id")), multi.getParameter("goo_name"),
				Integer.parseInt(multi.getParameter("goo_price")), multi.getParameter("goo_model"),
				multi.getParameter("goo_color"), multi.getParameter("goo_content"), image, date,
				multi.getParameter("goo_category"));
		StockBean stock = new StockBean(0, Integer.parseInt(multi.getParameter("goo_id")), multi.getParameter("sto_import"), multi.getParameter("sto_export"),
				Integer.parseInt(multi.getParameter("sto_qty")), date);

		boolean isRegistGoodsSuccess = goodsRegistService.registGoods(goods);
		boolean isRegistStockSuccess = goodsRegistService.registGoodsStock(stock, goods);
		ActionForward forward = null;

		if (isRegistGoodsSuccess && isRegistStockSuccess) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록성공');");
			out.println("location.href='adminGoodsListAction.ad';");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패.');");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;
	}

}
