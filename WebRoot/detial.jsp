<%@ page language="java" import="java.util.*"contentType="text/html; charset=utf-8"%>
<%@ page import="edu.sdut.dao.* , edu.sdut.entiry.*"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detial.jsp' starting page</title>
    
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
    <h1>商品详细信息（包括用户浏览过的商品）</h1>
    <hr>
    <div>
	    <table>
	    	<%
	    		int id = Integer.parseInt(request.getParameter("id"));
	    		ItemsDao itd = new ItemsDao();
	    		Goods goods = itd.getGoodsById(id);
	    		if(goods==null){
	    			out.println("<h2>该商品已经下架.....</h2>");
	    		}else{
	    	 %>
	    	<tr>
	    		<td>
	    			<div>
	    				<img src="image/<%=goods.getSpicture()%>" width="200" height="260"/>
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
	    	<%} %>
	    </table>
	    <hr>
	    <a href="<%=request.getContextPath()%>/servlet/AddGoods?id=<%=id%>">加入购物车</a>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Mygoods.jsp">我的购物车</a>
    </div>
    <br><br><br><br><br>
    <hr>
    <h2>您的历史浏览记录</h2>
    <%
    	String list = "";
    	Cookie[] cookies = request.getCookies();
    	if(cookies!=null&&cookies.length>0){
    		for(Cookie c:cookies){
    			if(c.getName().equals("GoodsList")){
    				list+=c.getValue();
    			}
    		}
    	}
    	list+=request.getParameter("id")+",";
    	String[] arr = list.split(",");
    	list = "";
    	for(int i = arr.length-1;i>=Math.max(0,arr.length-5);i--){
    		list+=arr[i]+",";
    	}
    	Cookie cookie = new Cookie("GoodsList",list);
    	response.addCookie(cookie);
     %>
     <table>
	    	<%
	    		for(int i = arr.length-1;i>=Math.max(0,arr.length-5);i--){
	    			goods = itd.getGoodsById(Integer.parseInt(arr[i]));
	    			if(goods==null){
	    				out.println("<h2>该商品已经下架.....</h2>");
	    			}else{
	    	 %>
	    	<tr>
	    		<td>
	    			<div>
	    				<img src="image/<%=goods.getSpicture()%>" width="150" height="170"/>
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
	    	</tr>
	    	<%} }%>
	    </table>
  </body>
</html>
