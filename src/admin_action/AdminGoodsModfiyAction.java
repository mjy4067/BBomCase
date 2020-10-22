package admin_action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.AdminService;
import vo.ActionForward;
import vo.GoodsBean;

public class AdminGoodsModfiyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminService adminGoodsModifyService = new AdminService();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "utf-8";
		int maxSize = 5 * 1024 * 1024;
		String image = null;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		if(multi.getFilesystemName("mod_image") != null) {
			image = multi.getFilesystemName("mod_image");
		} else {
			image = multi.getParameter("goo_image");
		}
		
		GoodsBean goods = new GoodsBean(Integer.parseInt(multi.getParameter("mod_id")), multi.getParameter("mod_name"),
				Integer.parseInt(multi.getParameter("mod_price")), multi.getParameter("mod_model"),
				multi.getParameter("mod_color"), multi.getParameter("mod_content"), image, multi.getParameter("mod_date"),
				multi.getParameter("mod_category"));
		
		boolean isModifyGoodsSuccess = adminGoodsModifyService.goodsModify(goods);
		
		ActionForward forward = null;
		if(isModifyGoodsSuccess) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정성공');");
			out.println("location.href='adminGoodsListAction.ad';");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
