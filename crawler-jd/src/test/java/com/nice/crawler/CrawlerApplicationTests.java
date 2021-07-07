package com.nice.crawler;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

//@SpringBootTest
class CrawlerApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(111);
	}

	@Test
	void testUrl() throws Exception {
		Document doc = Jsoup.parse(new URL("http://www.itcast.cn"),1000);
		String title = doc.getElementsByTag("title").first().text();
		System.out.println(title);
	}

	@Test
	void testParseContent() throws IOException {
		String content = FileUtils.readFileToString(new File("E:\\dev\\test.html"));
		//解析字符串
		Document doc = Jsoup.parse(content);
		String title = doc.getElementsByTag("title").first().text();
		System.out.println(title);

	}

	@Test
	void testParseFile() throws IOException {
		//解析字符串
		Document doc = Jsoup.parse(new File("E:\\dev\\test.html"),"utf8");
		String title = doc.getElementsByTag("title").first().text();
		System.out.println(title);

	}

	@Test
	void testFile() throws IOException {
		//解析字符串
		Document doc = Jsoup.parse(new File("E:\\dev\\test.html"),"utf8");
		//根据ID获取元素
		Element element = doc.getElementById("test");
		//元素中获取数据
		System.out.println("element.id"+element.id());
		System.out.println("element classNames"+element.className());
		Set<String> classSet = element.classNames();
		for(String s : classSet){
			System.out.println("class" + s);
		}
		//获取属性值
		System.out.println("attr" + element.attr("class"));

		//从元素宗获取所有属性atrributes的key value
		Attributes attributes = element.attributes();
		System.out.println(attributes);
	}

	@Test
	void testSelector() throws IOException {
		//解析字符串
		Document doc = Jsoup.parse(new File("E:\\dev\\test.html"),"utf8");
		//通过标签查找 如span
//		Elements elements = doc.select("span");
		//通过ID查找
//		Elements elements = doc.select("#city_bj");
		//通过.class
//		Elements elements = doc.select(".class_a");
//		Elements elements = doc.select(".city_con");
		//通过[attribute]获取
		//Elements elements = doc.select("[abc]");
//		Elements elements = doc.select("[class=s_name]");
		//复合元素
		//1.el#id
//		Elements elements = doc.select("h3#city_bj");
		//2.el.class
//		Elements elements = doc.select("li.class_a");
		//3.el[attr]
//		Elements elements = doc.select("span[abc]");
		//4.任意组合span[abc].s_name#id
		Elements elements = doc.select("span[abc].s_name");
		for(Element element: elements){
			System.out.println(element.text());
		}
	}

	@Test
	void testAncestor() throws IOException {
		//解析字符串
		Document doc = Jsoup.parse(new File("E:\\dev\\test.html"),"utf8");
		//父元素的子元素 ancestor child 查找祖先元素下子元素
//		Elements elements = doc.select(".city_con li");
//		Elements elements = doc.select(".city_con li");
		//父元素的子元素 parent > child 查找父元素下子元素
//		Elements elements = doc.select(".city_con > ul > li");
		//父元素的子元素 parent > *  查找父元素下所有子元素
		Elements elements = doc.select(".city_con > ul > *");
		for(Element element: elements){
			System.out.println(element.text());
		}
	}


}
