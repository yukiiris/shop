<%@page import="com.shop.vo.Goods"%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>商品</title>
</head>
<body>
<%
	request.setCharacterEncoding("GBK");
	Goods good = (Goods)request.getAttribute("good");
	if (good != null)
	{
%>
	<%=good.getName() %><br>
	<%=good.getIntroduction() %><br>
	<%=good.getPrice() %>><br>
<%
	} 
%>
<form action="BuyServlet" method="post">
	<a href="buy.html">购买</a>
</form>
</body>
</html>