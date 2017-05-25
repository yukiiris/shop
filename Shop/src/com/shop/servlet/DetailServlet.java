package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.factory.DAOFactory;
import com.shop.vo.Goods;

public class DetailServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String path = "detail.jsp";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		int ID = Integer.parseInt(request.getParameter("id"));
		Goods good = new Goods();
		try
		{
			good = DAOFactory.getIGoodsDAOInstance().findOne(ID);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		request.setAttribute("good", good);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doPost(request, response);
	}
}
