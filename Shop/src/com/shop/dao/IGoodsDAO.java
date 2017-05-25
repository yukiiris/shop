package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.shop.vo.Goods;

public interface IGoodsDAO {

	public boolean addToCart(int gID, int uID) throws SQLException;
	public boolean buy(int gID, int uID) throws SQLException;
	public List<Goods> findAll() throws SQLException;
	public Goods findOne(int ID) throws SQLException;
}
