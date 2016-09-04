package com.yc.dao;

import java.util.List;

import com.yc.bean.Tag;

public interface TagDao {
	
	public Tag add(Tag tag);
	
	public void update( Tag tag);

	public List<Tag> searchAll();
	
	public void updateBatch(   List<Tag> list);
	
	
}
