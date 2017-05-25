package com.shop.dao.proxy;

import java.sql.SQLException;
import java.util.List;

import com.shop.dao.IGoodsDAO;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.dbc.DatabaseConnection;
import com.shop.vo.Goods;

public class GoodsDAOProxy implements IGoodsDAO{

	private DatabaseConnection dbc = null;
	private GoodsDaoImpl dao = null;
	
	public GoodsDAOProxy() throws SQLException, ClassNotFoundException
	{
		try
		{
			dbc = new DatabaseConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		dao = new GoodsDaoImpl(dbc.getConnection());
	}
	
	public boolean addToCart(int gID, int uID) throws SQLException
	{
		boolean isAdd = false;
		try
		{
			isAdd = dao.addToCart(gID, uID);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return isAdd;
	}
	
	public boolean buy(int gID, int uID) throws SQLException
	{
		boolean isBuy = false;
		try
		{
			isBuy = dao.buy(gID, uID);
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		return isBuy;
	}
	
	public List<Goods> findAll() throws SQLException
	{
		List<Goods> list = null;
		try
		{
			list = dao.findAll();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public Goods findOne(int ID) throws SQLException
	{
		Goods goods = new Goods();
		try
		{
			goods = dao.findOne(ID);
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		return goods;
	}
}
