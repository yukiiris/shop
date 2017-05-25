package com.shop.dao;

import com.shop.vo.User;

public interface IUserDAO {

	public boolean doCreate(User user) throws Exception;
	public boolean findUser(User user) throws Exception; 
}
