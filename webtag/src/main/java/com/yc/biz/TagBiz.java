package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Tag;

public interface TagBiz {
	
	
	/**
	 * 查找所有的tag
	 * @return
	 * @throws Exception
	 */
	public Map<String,Tag> findAllTag()throws Exception;
	
}
