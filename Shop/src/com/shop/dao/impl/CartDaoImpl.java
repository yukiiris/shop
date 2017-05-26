package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.ICartDAO;
import com.shop.vo.Goods;

public class CartDaoImpl implements ICartDAO{

	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public CartDaoImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public List<Goods> show(int uID) throws SQLException
	{
		List<Goods> list = null;
		try
		{
			String sql = "SELECT * FROM cart WHERE uid=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uID);
			ResultSet rs = pstm.executeQuery();
			list = new ArrayList<Goods>();
			while (rs.next())
			{
				Goods goods = new Goods();
				goods.setPrice(rs.getFloat(2));
				goods.setName(rs.getString(4));
				list.add(goods);
			}
			rs.close();
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		finally 
		{
			try
			{
				if (pstm != null)
				{
					pstm.close();
				}
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
			try
			{
				if (conn != null)
				{
					conn.close();
				}
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
		}
		return list;
	}
}
