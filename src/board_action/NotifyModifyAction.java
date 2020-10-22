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
import vo.NotifyBean;

public class NotifyModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='memberLogin.me?turn=ok';");
			out.println("</script>");
		}else if(!id.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			BoardService boardService = new BoardService();
			
			int no_id = Integer.parseInt(request.getParameter("no_id"));
			
			String realFolder = "";
			String saveFolder = "/images";
			String encType="UTF-8";
			int fileSize = 5*1024*1024;
			
			ServletContext context = request.getServletContext();
			realFolder = context.getRealPath(saveFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, encType, new DefaultFileRenamePolicy());
			String image = multi.getFilesystemName("no_image");
			
			if(image==null&&multi.getParameter("oldImage").length()>0) {
				image = multi.getParameter("oldImage");
			}
			
			NotifyBean notify = new NotifyBean(
					no_id,
					id,
					multi.getParameter("no_title"),
					multi.getParameter("no_content"),
					image,
					null,
					0);
			
			boolean notifyModifyResult = boardService.notifyModify(notify);
			
			if(!notifyModifyResult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				String page = multi.getParameter("page");
				String path = "./notifyViewAction.bo?no_id="+no_id+"&page="+page;
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정성공');");
				out.println("location.href=encodeURI('"+path+"');");
				out.println("</script>");
				
			}
		}
		return forward;
	}
}
