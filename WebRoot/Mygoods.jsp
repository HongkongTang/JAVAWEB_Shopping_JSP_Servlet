<%@ page language="java" import="java.util.* " contentType="text/html; charset=utf-8"%>
<%@ page import = "edu.sdut.entiry.* , edu.sdut.dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Mygoods.jsp' starting page</title>
    
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
  <h1>我的购物车</h1>
  <hr>
    <table >
    	<%
    		User user = (User)session.getAttribute("user");
    		String strGoods = user.getGoods();
    		String[] goods  =  strGoods.split(";");
    		if(goods==null||(goods.length<=0)){
    		
    	 %>
    	 <h3>您的购物车为空</h3>
    	 <%}else
    	 {
    	 	for(int i = 0;i<goods.length;i++){
    	 		int id = Integer.parseInt(goods[i]);
    	 		ItemsDao itemsDao = new ItemsDao();
    	 		Goods good = itemsDao.getGoodsById(id);
    	 		
    	  %>
    	<tr>
    		<td>
    			<div>
    				<a href="detial.jsp?id=<%=good.getSid()%>"><img src="image/<%=good.getSpicture()%>" width="200" height="260"/></a>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>商品名:<%=good.getSname() %></p>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>价格:<%=good.getSprice() %></p>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>产地:<%=good.getScity() %></p>
    			</div>
    		</td>
    		<td>
    			<div>
    				<p>商品数量:<%=good.getSnumber() %></p>
    			</div>
    		</td>
    	</tr>
    	<%}} %>
    </table>
  </body>
</html>
