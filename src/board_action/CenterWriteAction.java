package board_action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.BoardService;
import vo.ActionForward;
import vo.CenterBean;

public class CenterWriteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("location.href='memberLogin.me';");
			out.println("</script>");
		} else {
			BoardService boardService = new BoardService();
			
			int cc_id = boardService.centerNum();
			
			String realFolder = "";
			String saveFolder = "/images";
			String encType="UTF-8";
			int fileSize = 5*1024*1024;
			
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, encType, new DefaultFileRenamePolicy());
			String image = multi.getFilesystemName("cc_image");
			
			CenterBean center = new CenterBean(
					cc_id,
					id,
					multi.getParameter("cc_title"),
					multi.getParameter("cc_content"),
					image,
					null,
					0,
					cc_id,
					1,
					multi.getParameter("cc_secret")==null ? "null" : "hide"
					);
			
			boolean centerWriteResult = boardService.centerWrite(center);
			
			if(centerWriteResult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록되었습니다.');");
				out.println("location.href='./centerListAction.bo';");
				out.println("</script>");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
		
		return forward;
	}
}
