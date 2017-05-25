package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import com.shop.vo.Goods;

public interface ICartDAO {

	public List<Goods> show(int gID) throws SQLException;
}
