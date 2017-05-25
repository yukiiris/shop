package com.shop.dao.proxy;

import java.sql.SQLException;
import java.util.List;

import com.shop.dao.ICartDAO;
import com.shop.dao.impl.CartDaoImpl;
import com.shop.dbc.DatabaseConnection;
import com.shop.vo.Goods;

public class CartDAOProxy implements ICartDAO{

	private DatabaseConnection dbc = null;
	private CartDaoImpl dao = null;
	
	public CartDAOProxy() throws SQLException, ClassNotFoundException
	{
		try
		{
			dbc = new DatabaseConnection();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		dao = new CartDaoImpl(dbc.getConnection());
	}
	
	public List<Goods> show(int uID) throws SQLException
	{
		List<Goods> list = null;
		try
		{
			list = dao.show(uID);
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
}
