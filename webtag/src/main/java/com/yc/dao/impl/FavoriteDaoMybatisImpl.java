package com.yc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.yc.bean.Favorite;
import com.yc.bean.Tf;
import com.yc.dao.FavoriteDao;

public class FavoriteDaoMybatisImpl implements FavoriteDao {

	private SqlSessionTemplate sqlSession;

	
	public void add(Favorite favorite) {
		sqlSession.insert("com.yc.dao.favoriteDaoMapper.add", favorite);
	}

	public void addtf(List<Tf> list) {
		sqlSession.insert("com.yc.dao.favoriteDaoMapper.addtf", list);
	}

	public List<Favorite> search(Favorite favorite) {
		return sqlSession.selectList("com.yc.dao.favoriteDaoMapper.search", favorite);
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Favorite> searchUnType() {
		return sqlSession.selectList("com.yc.dao.favoriteDaoMapper.searchUnType");
		
	}
	
	

}
