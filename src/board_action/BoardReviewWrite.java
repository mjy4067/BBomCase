package board_action;

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
import svc.BoardService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReviewWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService boardService = new BoardService();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
			
		if(id==null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
			
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "utf-8";
		int maxSize = 5 * 1024 * 1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("rev_image");
		Date nowTime = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sf.format(nowTime);
		BoardBean board = new BoardBean();
		board.setMem_id(id);
		board.setGoo_id(Integer.parseInt(multi.getParameter("goo_id")));
		board.setTitle(multi.getParameter("rev_title"));
		board.setContent(multi.getParameter("rev_content"));
		board.setImage(image);
		board.setDate(date);
		
		boolean isReviewWriteSuccess = boardService.registReview(board);
		ActionForward forward = null;
		
		if(isReviewWriteSuccess) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록성공');");
			out.println("window.close();");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("window.close();");
			out.println("</script>");
		}
		
		return forward;
	}

}