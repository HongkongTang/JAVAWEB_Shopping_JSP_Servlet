package edu.sdut.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllFilter implements Filter{

	FilterConfig config = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain cha) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		String paths = config.getInitParameter("nologin");
		String[] ArrPaths = paths.split(";");
		
		if(ArrPaths!=null&&ArrPaths.length>0){
			for(String path:ArrPaths){
				if(request.getRequestURI().indexOf(path)!=-1){
					cha.doFilter(req, resp);
					return ;
				}
			}
		}
		
		if(session.getAttribute("user")!=null){
			cha.doFilter(req, resp);
		}else{
			response.sendRedirect("login.jsp");
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		config = arg0;
	}

}
