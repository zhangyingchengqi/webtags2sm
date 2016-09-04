package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.bean.Tf;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.TagBiz;
import com.yc.dao.FavoriteDao;
import com.yc.dao.TagDao;

public class FavoriteBizImpl implements FavoriteBiz {
	private TagDao tagDao;
	private FavoriteDao favoriteDao;

	/**
	 * 完成了批量添加中间关系表, 批量更新tag表中的 tcount的值, 但增加tag不能使用批量添加方式
	 */
	public Favorite addFavorite(Favorite fav, Map<String, Tag> tagMap)
			throws Exception {
		// aa. 先判断是否有 ftags,没有执行 c, 有ftags,执行a
		String tags = fav.getFtags().trim(); // "体育,娱乐"
		List<Tf> list = new ArrayList<Tf>();
		List<Tag> tagListForUpdate = new ArrayList<Tag>();
		// c. 将 Favorite存到favorite表中
		favoriteDao.add(fav); // 先添加了 fav之后，就有 fid
		if (tags != null && !"".equals(tags)) {
			// a. jie取 ftags, 根据 , => String[] 存的是所有的tags
			String[] ts = tags.split(",");
			// b. 查一下，是否在 tag表中存在这个 标签名, 存在，则将 tcount++
			if (ts != null && ts.length > 0) {
				for (String t : ts) { // 体育
					Tf tf = new Tf();
					tf.setFid(fav.getFid());
					Tag tag = null;
					if (tagMap != null && tagMap.size() > 0
							&& tagMap.containsKey(t)) {
						// 更新操作
						tag = tagMap.get(t);
						tag.setTcount(tag.getTcount() + 1);
						// tagDao.update(tag); // TODO: 批量更新
						tagListForUpdate.add(tag);
						tf.setTid(tag.getTid());
					} else {
						// 添加操作
						tag = new Tag();
						tag.setTname(t);
						tag.setTcount(1);
						tagDao.add(tag);
						tf.setTid(tag.getTid());
						tagMap.put(t, tag);
					}
					list.add(tf); // tf tid( 添加了tag) fid
				}
				if (tagListForUpdate.size() > 0) {
					tagDao.updateBatch(tagListForUpdate); // 批量更新已有的tag的数量
					//update tag set    where tid in
				}
				favoriteDao.addtf(list); // 批量添加中间关系表
			}
		}
		return fav;
	}

	public List<Favorite> findFavoriteByTagName(Favorite favorite) {
		if ("未分类".equals(favorite.getTname())) {
			return favoriteDao.searchUnType();
		}
		return favoriteDao.search(favorite);
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

}
