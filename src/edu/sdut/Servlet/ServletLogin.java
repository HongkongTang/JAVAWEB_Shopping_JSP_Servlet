package edu.sdut.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdut.dao.UserDao;
import edu.sdut.entiry.User;

public class ServletLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ServletLogin() {
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
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		String str = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		
		User userOne = null;
		UserDao userDao = new UserDao();
		ArrayList<User> userList = userDao.getAllUser();
		boolean flag = false;
		for(User user:userList){
			if(username.equals(user.getUname())&&password.equals(user.getPassword())){
				flag = true;
				userOne = user;
				break;
			}
		}
		str = str.toLowerCase();
		checkcode = checkcode.toLowerCase();
		if(!flag){
			//用户名密码不正确
			response.sendRedirect("../userNO.jsp");
		}else if(!str.equals(checkcode)){
			
			//验证码错误
			response.sendRedirect("../checkcode.jsp");
		}else{
		response.sendRedirect("../index.jsp");
		session.setAttribute("user", userOne);
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
