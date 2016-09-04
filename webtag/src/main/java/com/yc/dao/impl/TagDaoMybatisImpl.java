package com.yc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.yc.bean.Tag;
import com.yc.dao.TagDao;

public class TagDaoMybatisImpl implements TagDao {
	private SqlSessionTemplate sqlSession;


	public Tag add(Tag tag) {
		 sqlSession.insert("com.yc.dao.tagDaoMapper.add",tag);
		 return tag;
	}

	public void update(Tag tag) {
		sqlSession.insert("com.yc.dao.tagDaoMapper.update",tag);
	}

	public List<Tag> searchAll() {
		return sqlSession.selectList("com.yc.dao.tagDaoMapper.searchAll");
	}

	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void updateBatch(List<Tag> list) {
		sqlSession.insert("com.yc.dao.tagDaoMapper.updateBatch",list);
	}
}
