package com.shop.dao.proxy;

import java.sql.SQLException;

import com.shop.dao.IUserDAO;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.dbc.DatabaseConnection;
import com.shop.vo.User;

public class UserDAOProxy implements IUserDAO{

	private DatabaseConnection dbc = null;
	private IUserDAO dao = null;
	
	public UserDAOProxy() throws SQLException, ClassNotFoundException
	{
		try
		{
			dbc = new DatabaseConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		dao = new UserDaoImpl(dbc.getConnection());
	}
	
	public boolean findUser(User user) throws Exception
	{
		boolean isFind = false;
		try
		{
			isFind = dao.findUser(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				dbc.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return isFind;
	}

	public boolean doCreate(User user) throws Exception
	{
		boolean isCreate = false;
		try
		{
			isCreate = dao.doCreate(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				dbc.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return isCreate;
	}

}
