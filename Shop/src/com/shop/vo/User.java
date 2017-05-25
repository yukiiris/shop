package com.shop.vo;

public class User {

	private int ID = 1;
	private String name;
	private String password;

	
	public void setID(int i)
	{
		ID = i;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
}
