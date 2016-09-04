package com.yc.dao;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.bean.Tf;


public interface FavoriteDao {
	
	public void add(Favorite favorite);
	
	public void addtf( List<Tf> tfs);


	public List<Favorite> search(Favorite favorite);// 根据tagName
	
	public List<Favorite> searchUnType();
	
	
}
