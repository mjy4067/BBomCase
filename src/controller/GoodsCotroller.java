package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import goods_action.GoodsCartAddAction;
import goods_action.GoodsCartListAction;
import goods_action.GoodsCartQtyDownAction;
import goods_action.GoodsCartQtyUpAction;
import goods_action.GoodsCartRemoveAction;
import goods_action.GoodsCartRemoveAllAction;
import goods_action.GoodsListAction;
import goods_action.GoodsMainAction;
import goods_action.GoodsViewAction;
import vo.ActionForward;

/**
 * Servlet implementation class GoodsCotroller
 */
@WebServlet("*.go")
public class GoodsCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		if(command.equals("/goodsListAction.go")){
			action = new GoodsListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("GoodsListAction 오류" + e);
			}
		} else if(command.equals("/goodsMainAction.go")) {
			action = new GoodsMainAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("GoodsViewAction 오류" + e);
			}
		} else if(command.equals("/goodsViewAction.go")) {
			action = new GoodsViewAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("GoodsViewAction 오류" + e);
			}
		} else if(command.equals("/goodsCartListAction.go")) {
			action = new GoodsCartListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("goodsCartList 오류" + e);
			}
		} else if(command.equals("/goodsCartAddAction.go")) {
			action = new GoodsCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("goodsCartAddAction 오류" + e);
			}
		} else if(command.equals("/goodsCartQtyUpAction.go")) {
			action = new GoodsCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("goodsCardQtyUpAction 오류" + e);
			}
		} else if(command.equals("/goodsCartQtyDownAction.go")) {
			action = new GoodsCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("goodsCarQtyDownAction 오류" + e);
			}
		} else if(command.equals("/goodsCartRemoveAction.go")) {
			action = new GoodsCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("goodsCartRemoveAction 오류"+ e);
			}
		} else if(command.equals("/goodsCartRemoveAllAction.go")) {
			action = new GoodsCartRemoveAllAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				System.out.println("goodsCartRemoveAllAction 오류"+ e);
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
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
