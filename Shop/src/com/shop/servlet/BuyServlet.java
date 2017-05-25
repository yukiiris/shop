package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.factory.DAOFactory;

public class BuyServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String path = "buy.html";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		int gID = Integer.parseInt(request.getParameter("gid"));
		int uID = Integer.parseInt(request.getParameter("uid"));
		try
		{
			if (DAOFactory.getIGoodsDAOInstance().buy(gID, uID))
			{
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doPost(request, response);
	}
}
