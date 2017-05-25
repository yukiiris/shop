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
		System.out.println("servlet�����ɹ�");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		List<String> info = new ArrayList<String>();
		String path = "login_check.jsp";
		
		if (name == null || "".equals(name))
		{
			info.add("���ֲ���Ϊ��");
		}
		if (password == null || "".equals(password))
		{
			info.add("���벻��Ϊ��");
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
					info.add("��¼�ɹ���");
				}
				else
				{
					info.add("��¼ʧ�ܣ�");
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
