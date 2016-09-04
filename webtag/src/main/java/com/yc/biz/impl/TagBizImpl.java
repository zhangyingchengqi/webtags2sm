package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.bean.Tag;
import com.yc.biz.TagBiz;
import com.yc.dao.FavoriteDao;
import com.yc.dao.TagDao;

public class TagBizImpl implements TagBiz {
	private TagDao tagDao;

	

	public Map<String,Tag> findAllTag()  {
		List<Tag> list= tagDao.searchAll();
		Map<String,Tag> map=new HashMap<String,Tag>();
		for( Tag t:list){
			map.put(t.getTname(), t);
		}
		return map;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	
	
}
