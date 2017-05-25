package com.shop.vo;

public class Goods {

	private int ID;
	private String name;
	private String introduction;
	private float price;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getIntroduction()
	{
		return introduction;
	}
	
	public void setIntroduction(String introduction)
	{
		this.introduction = introduction;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
}
