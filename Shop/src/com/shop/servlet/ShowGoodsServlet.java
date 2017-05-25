package com.shop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.factory.DAOFactory;
import com.shop.vo.Goods;

public class ShowGoodsServlet extends HttpServlet{
	
	String path = "show_goods.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		List<Goods> list = null;
		try 
		{
			list = DAOFactory.getIGoodsDAOInstance().findAll();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher(path).forward(request, response);
		System.out.println(list.isEmpty());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		doGet(request, response);
	}
}
