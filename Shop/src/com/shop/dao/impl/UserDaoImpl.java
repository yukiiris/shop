package com.shop.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.dao.IUserDAO;
import com.shop.vo.User;

public class UserDaoImpl implements IUserDAO{

	private Connection conn = null;
	private PreparedStatement pstm = null;
	
	public UserDaoImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	public boolean doCreate(User user) throws SQLException
	{
		boolean isCreate = false;
		try
		{
			String sql = "INSERT INTO user(id,name,password) VALUES(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user.getID());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			
			if (pstm.executeUpdate() > 0)
			{
				isCreate = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isCreate;
	}

	public boolean findUser(User user) throws Exception
	{
		boolean isFind = false;
		try
		{
			String sql = "SELECT id FROM user WHERE name=? and password=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next())
			{
				isFind = true;
				user.setID(rs.getInt(1));
			}
			pstm.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return isFind;
	}

}
