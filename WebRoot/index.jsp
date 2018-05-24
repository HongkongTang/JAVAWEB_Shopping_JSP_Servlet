<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "edu.sdut.dao.* , edu.sdut.entiry.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h1>商品浏览</h1>
    <%
    	if(session.getAttribute("user")==null){
     %>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <h3><a href="login.jsp">登陆</a></h3>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <h3><a href="reg.jsp">注册</a></h3>
    <%} else{
    	User user = (User)session.getAttribute("user");
    	user.getUname();
    %>
    <h3><%=user.getUname() %></h3>
    <%} %>
    
    <hr>
    <table >
    	<%
    		ItemsDao itd = new ItemsDao();
    		ArrayList<Goods> goodsList = itd.getAllGoods();
    		if(goodsList==null||goodsList.size()<=0){
    			out.println("<h2>该商店暂无商品....</h2>");
    		}else{
    			for(Goods goods:goodsList){
    	 %>
    	<tr>
    		<td>
    			<div>
    				<a href="detial.jsp?id=<%=goods.getSid()%>"><img src="image/<%=goods.getSpicture()%>" width="200" height="260"/></a>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>商品名:<%=goods.getSname() %></p>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>价格:<%=goods.getSprice() %></p>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>产地:<%=goods.getScity() %></p>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>商品数量:<%=goods.getSnumber() %></p>
    			</div>
    		</td>
    	</tr>
    	<%}} %>
    </table>
  </body>
</html>
