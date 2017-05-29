package com.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.factory.DAOFactory;
import com.shop.vo.User;

public class LoginServlet extends HttpServlet{

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException
	{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		List<String> info = new ArrayList<String>();
		String path = "show_goods.jsp";
		int i;
		
		if (name == null || "".equals(name))
		{
			info.add("名字不能为空");
		}
		if (password == null || "".equals(password))
		{
			info.add("密码不能为空");
		}
		if (info.size() == 0)
		{
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			try
			{
				if (DAOFactory.getIUserDAOInstance().findUser(user))
				{
					i = user.getID();
					request.setAttribute("i", i);
				}
				else
				{
					info.add("登录失败！");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException
	{
		doGet(request, response);
	}
}
