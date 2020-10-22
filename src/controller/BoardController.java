package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board_action.BoardQnaWrite;
import board_action.BoardReviewList;
import board_action.BoardReviewRemove;
import board_action.BoardReviewView;
import board_action.BoardReviewWrite;
import board_action.CenterDeleteAction;
import board_action.CenterListAction;
import board_action.CenterReplyAction;
import board_action.CenterViewAction;
import board_action.CenterWriteAction;
import board_action.NotifyDeleteAction;
import board_action.NotifyListAction;
import board_action.NotifyModifyAction;
import board_action.NotifyModifyFormAction;
import board_action.NotifyViewAction;
import board_action.NotifyWriteAction;
import board_action.BoardQnaList;
import board_action.BoardQnaRemove;
import board_action.BoardQnaReply;
import board_action.BoardQnaReplyForm;
import board_action.BoardQnaView;
import vo.ActionForward;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;	
		System.out.println(command);
		
		if(command.equals("/boardQnaList.bo")) {
			action = new BoardQnaList();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardQnaList 오류" + e);
			}
		} else if(command.equals("/boardQnaWriteForm.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("pagefile", "QnaWriteForm.jsp");
			forward.setPath("index.jsp");
		} else if(command.equals("/boardQnaReplyForm.bo")) {
			action = new BoardQnaReplyForm();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardQnaReplyForm.bo 오류" + e);
			}
		} else if(command.equals("/board/boardQnaWrite.bo")) {
			action = new BoardQnaWrite();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardQnaWrite 오류" + e);
			}
		} else if(command.equals("/boardQnaView.bo")) {
			action = new BoardQnaView();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardQnaView 오류" + e);
			}
		} else if(command.equals("/boardQnaRemove.bo")) {
			action = new BoardQnaRemove();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardQnaRemove 오류" + e);
			}
		} else if(command.equals("/boardQnaReply.bo")) {
			action = new BoardQnaReply();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardQnaReply 오류" + e);
			}
		}
		
		else if(command.equals("/boardReviewWriteForm.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("pagefile", "/board/ReviewWriteForm.jsp");
			forward.setPath("index.jsp");
		} else if(command.equals("/boardReviewList.bo")) {
			action = new BoardReviewList();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardReviewList 오류" + e);
			}
		} else if(command.equals("/board/boardReviewWrite.bo")) {
			action = new BoardReviewWrite();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardReviewWrite 오류" + e);
			}
		} else if(command.equals("/boardReviewView.bo")) {
			action = new BoardReviewView();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardReviewView 오류" + e);
			}
		} else if(command.equals("/boardReviewRemove.bo")) {
			action = new BoardReviewRemove();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("BoardReviewRemove 오류" + e);
			}
		} 
		
		else if(command.equals("/notifyListAction.bo")) {
			action = new NotifyListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/notifyWrite.bo")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "/board/notifyWrite.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		} 
		
		else if(command.equals("/notifyWriteAction.bo")) {
			action = new NotifyWriteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/notifyViewAction.bo")) {
    		action = new NotifyViewAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/notifyDeleteAction.bo")) {
    		action = new NotifyDeleteAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/notifyModifyFormAction.bo")) {
    		action = new NotifyModifyFormAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/notifyModifyAction.bo")) {
    		action = new NotifyModifyAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e	) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if(command.equals("/centerListAction.bo")) {
    		action = new CenterListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/centerWrite.bo")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "/board/centerWrite.jsp");
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		} else if(command.equals("/centerWriteAction.bo")){
			action = new CenterWriteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/centerViewAction.bo")) {
    		action = new CenterViewAction();
    		try {
    			forward = action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/centerReplyAction.bo")) {
    		action = new CenterReplyAction();
    		try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("/centerDeleteAction.bo")) {
    		action = new CenterDeleteAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
		
		
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
}
