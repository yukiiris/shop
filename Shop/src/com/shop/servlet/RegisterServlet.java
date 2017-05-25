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

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		String path = "register.jsp";
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		List<String> info = new ArrayList<String>();
		
		if (name == null || "".equals(name))
		{
			info.add("�û�������Ϊ��");
		}
		else if (name.length() > 9)
		{
			info.add("�û�������");
		}
		if (password == null || "".equals(password))
		{
			info.add("���벻��Ϊ��");
		}
		else if (!confirm.equals(confirm))
		{
			info.add("�����������벻һ��");
		}
		else if (password.length() > 9)
		{
			info.add("�������");
		}
		
		if (info.size() == 0)
		{
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			try
			{
				if (DAOFactory.getIUserDAOInstance().doCreate(user))
				{
					info.add("�����ɹ�");
				}
				else
				{
					info.add("����ʧ��");
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
	throws ServletException, IOException
	{
		doGet(request, response);
	}
}
