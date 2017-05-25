package com.shop.dao.factory;

import com.shop.dao.IGoodsDAO;
import com.shop.dao.IUserDAO;
import com.shop.dao.proxy.GoodsDAOProxy;
import com.shop.dao.proxy.UserDAOProxy;

public class DAOFactory {

	public static IUserDAO getIUserDAOInstance() throws Exception
	{
			System.out.println("���������ɹ�");
			return new UserDAOProxy();
	}
	
	public static IGoodsDAO getIGoodsDAOInstance() throws Exception
	{
		return new GoodsDAOProxy();
	}
}
