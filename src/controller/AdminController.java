package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin_action.AdminGoodsListAction;
import admin_action.AdminGoodsModfiyAction;
import admin_action.AdminGoodsModfiyFormAction;
import admin_action.AdminGoodsRemoveAction;
import admin_action.AdminGoodsStockExportAction;
import admin_action.AdminGoodsStockFormAction;
import admin_action.AdminGoodsStockImportAction;
import goods_action.GoodsRegistAction;
import vo.ActionForward;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("*.ad")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		if (command.equals("/goodsRegistFormAction.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("pagefile", "/admin/goodsRegistForm.jsp");
			forward.setPath("index.jsp");
		} else if (command.equals("/goodsRegistAction.ad")) {
			action = new GoodsRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("goodsReigstAction 오류" + e);
			}
		} else if (command.equals("/adminGoodsListAction.ad")) {
			action = new AdminGoodsListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsListAction 오류" + e);
			}
		} else if(command.equals("/adminGoodsRemoveAction.ad")) {
			action = new AdminGoodsRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsListAction 오류" + e);
			} 
		} else if(command.equals("/adminGoodsModifyFormAction.ad")) {
			action = new AdminGoodsModfiyFormAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsModifyFormAction 오류" + e);
			}
		} else if(command.equals("/adminGoodsModifyAction.ad")) {
			action = new AdminGoodsModfiyAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsModifyAction 오류" + e);
			}
		} else if(command.equals("/adminGoodsStockFormAction.ad")) {
			action = new AdminGoodsStockFormAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsStockFormAction 오류" + e);
			}
		} else if(command.equals("/admin/adminGoodsStockImportAction.ad")) {
			action = new AdminGoodsStockImportAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsStockImportAction 오류" + e);
			}
		} else if(command.equals("/admin/adminGoodsStockExportAction.ad")) {
			action = new AdminGoodsStockExportAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("adminGoodsStockExportAction 오류" + e);
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
