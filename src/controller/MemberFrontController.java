package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import member_action.MemberIdFindAction;
import member_action.MemberIdTestAction;
import member_action.MemberInfoAction;
import member_action.MemberDeleteAction;
import member_action.MemberJoinAction;
import member_action.MemberListAction;
import member_action.MemberLoginAction;
import member_action.MemberLogoutAction;
import member_action.MemberModifyAction;
import member_action.MemberModifyFormAction;
import member_action.MemberMyDeleteAction;
import member_action.MemberMyModifyAction;
import member_action.MemberMyModifyFormAction;
import member_action.MemberMyPageAction;
import member_action.MemberPassFindAction;

import vo.ActionForward;
/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.me")
public class MemberFrontController extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		System.out.println(command);
		
		if(command.equals("/memberLogin.me")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/loginForm.jsp");
		} 
		else if(command.equals("/memberLoginAction.me")) {
			action = new MemberLoginAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		else if(command.equals("/memberLogoutAction.me")) {
			action = new MemberLogoutAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/memberJoin.me")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/joinForm.jsp");
		} 
		else if(command.equals("/memberJoinAction.me")) {
			action = new MemberJoinAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/dupliForm.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/dupliForm.jsp?openInit=true");
		} 
		else if(command.equals("/memberIdTestAction.me")) {
			action = new MemberIdTestAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/memberIdFind.me")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/idFindForm.jsp");
		}
		else if(command.equals("/memberIdFindAction.me")) {
			action = new MemberIdFindAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/memberPassFind.me")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/passFindForm.jsp");
		}
		else if(command.equals("/memberPassFindAction.me")) {
			action = new MemberPassFindAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		}
		
		else if(command.equals("/memberListAction.me")) {
			action = new MemberListAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberInfoAction.me")) {
			action = new MemberInfoAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} 
		else if(command.equals("/memberDeleteAction.me")) {
			action = new MemberDeleteAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/memberModifyFormAction.me")) {
			action = new MemberModifyFormAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberModifyAction.me")) {
			action = new MemberModifyAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/memberMyPageAction.me")) {
			action = new MemberMyPageAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		else if(command.equals("/memberMyModifyFormAction.me")) {
			action = new MemberMyModifyFormAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} 
		else if(command.equals("/memberMyModifyAction.me")) {
			action = new MemberMyModifyAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		else if(command.equals("/memberMyDeleteAction.me")) {
			action = new MemberMyDeleteAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if (forward != null) {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
