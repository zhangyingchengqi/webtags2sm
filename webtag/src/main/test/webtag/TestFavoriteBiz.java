package webtag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.TagBiz;

import junit.framework.TestCase;

//XP:   
//TDD: 测试驱动 
//自动构建,自动测试:  maven 
public class TestFavoriteBiz extends TestCase {
	ApplicationContext ac;

	@Test
	public void testAddFavorite() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		FavoriteBiz fb = (FavoriteBiz) ac.getBean("favoriteBiz");
		Map<String, Tag> tagMap = new HashMap<String, Tag>();

		Favorite fav = new Favorite();
		fav.setFdesc("好网站");
		fav.setFlabel("sina");
		fav.setFurl("http://www.sina.com");
		fav.setFtags("门户,新闻,体育");   // 没有,  查tag三次,   添加tag三次( 批量插入) ,  添加  tf三次(批量添加)
		                                 //  有,   查tag三次,   更新三次   ,    添加tf三次.

		try {
			fb.addFavorite(fav, tagMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddFavorite2() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		FavoriteBiz fb = (FavoriteBiz) ac.getBean("favoriteBiz");
		Map<String, Tag> tagMap = new HashMap<String, Tag>();

		Favorite fav = new Favorite();
		fav.setFdesc("好网站");
		fav.setFlabel("sohu");
		fav.setFurl("http://www.sohu.com");
		fav.setFtags("门户,新闻");

		try {
			fb.addFavorite(fav, tagMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddFavorite3() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		FavoriteBiz fb = (FavoriteBiz) ac.getBean("favoriteBiz");
		Tag t = new Tag();
		t.setTid(1);
		t.setTcount(2);
		t.setTname("门户");
		Map<String, Tag> tagMap = new HashMap<String, Tag>();
		tagMap.put("门户", t);

		Favorite fav = new Favorite();
		fav.setFdesc("好网站");
		fav.setFlabel("sohu");
		fav.setFurl("http://www.sohu.com");
		fav.setFtags("门户,新闻");

		try {
			fb.addFavorite(fav, tagMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddFavorite4() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		FavoriteBiz fb = (FavoriteBiz) ac.getBean("favoriteBiz");
		Favorite fav = new Favorite();
		//fav.setTname("全部");
		fav.setTname("新闻");
		//fav.setTname("未分类");
		List<Favorite> list = fb.findFavoriteByTagName(fav);
		for (Favorite f : list) {
			System.out.println(f);
		}
	}

	@Test
	public void testAddFavorite5() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		TagBiz fb = (TagBiz) ac.getBean("tagBiz");
		try {
			Map<String, Tag> map = fb.findAllTag();
			for (Map.Entry<String, Tag> entry : map.entrySet()) {
				System.out.println(entry.getKey() + "\t" + entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddFavorite6() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		TagBiz tb = (TagBiz) ac.getBean("tagBiz");
		FavoriteBiz fb = (FavoriteBiz) ac.getBean("favoriteBiz");
		try {
			Map<String, Tag> map = tb.findAllTag();  //tag有 门户,新闻,体育
			Favorite fav = new Favorite();
			fav.setFdesc("好网站");
			fav.setFlabel("aa");
			fav.setFurl("http://www.aa.com");
			fav.setFtags("美国新闻,美国军事,军事技术,门户,英国新闻,中国新闻,新闻,军事");
			fb.addFavorite(fav, map); //   favorite 1   tag 更新两条      tf: 2

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
