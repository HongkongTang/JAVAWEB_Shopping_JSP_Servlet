package edu.sdut.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdut.dao.UserDao;
import edu.sdut.entiry.User;

@SuppressWarnings("serial")
public class AddGoods extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddGoods() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String id = request.getParameter("id");

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			response.sendRedirect("../login.jsp");
			return;
		}
		String str = user.getGoods();
		
		if(user!=null){
			boolean flag = false;
			
			String[] goods = str.split(";");
			for(int i = 0;i<goods.length;i++){
				
				if(id.equals(goods[i])){
					flag = true;
					break;
				}
			}
			if(!flag){
				String add = str+""+id+";";
				user.setGoods(add);
				session.setAttribute("user", user);
				int uid = user.getUid();
				UserDao.ChangeGoods(uid, add);
				response.sendRedirect("../Mygoods.jsp");
			}else{
				response.sendRedirect("../Mygoods.jsp");
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
