package com.dowanBeer.articleRetreiver.website;

import com.dowanBeer.articleRetreiver.beans.Article;
import com.dowanBeer.articleRetreiver.beans.WebSite;
import com.dowanBeer.articleRetreiver.utils.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.*;

public class SacAPof extends WebSite{

	public SacAPof() {
		super("SacAPof", Constants.sacAPofArticleURLString);
	}

	@Override
	public String getArticle(String articleId) {
		// TODO Retrieve Article from DB
		return null;
	}

	@Override
	public List<Article> getNewArticles() {
		
		// TODO Retrieve md5Articles from DB		
		Set<String> md5ArticlesSet = new HashSet<String>();
        ArrayList<Article> arts = new ArrayList<Article>();
		try {
			Document doc = Jsoup.connect(Constants.sacAPofArticleURLString).get();
			Elements articles =  doc.getElementsByTag("article");
			MessageDigest md5crypter = MessageDigest.getInstance("MD5");
			for (Element article : articles){
                System.out.println(article.html());
                String md5article = new String(md5crypter.digest(article.html().getBytes("UTF-8")));
				if (!md5ArticlesSet.contains(md5article)){
                    System.out.println(md5article);
                    md5ArticlesSet.add(md5article);
					Element h1 = article.getElementsByTag("h1").first();
					String title = h1 != null ? h1.text() : null;
					Element content = article.getElementsByClass("entry-content").first();
					String body = content != null ? content.text() : null;
                    Element time = article.getElementsByTag("time").first();
                    String date = time != null ? time.attr("datetime"): null;
                    ZonedDateTime zdt = ZonedDateTime.parse(date);
                    String url = null;
                    if (h1 != null){
                    	Element link = h1.getElementsByTag("a").first();
                    	url = link!=null ? link.attr("href") : null;
                    }
					arts.add(new Article(article.html(), md5article, article.text(), title, body, this, zdt.toLocalDateTime(), url));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return arts;
	}

	@Override
	public String[] getAllArticles() {
		// TODO Retrieve all article from database
		return null;
	}
	
	public static void main(String[] args) {
//		String test = "<h1 class=\"entry-title\"><a href=\"http://sacapof.org/quelques-photo-du-demontage/\" rel=\"bookmark\">Quelques photo du d�montage&#8230;</a></h1>";
//		Document doc = Jsoup.parse(test);
//		System.out.println(doc.text());
//		Elements titre = doc.getElementsByTag("article");
//		System.out.println(titre);
//		System.out.println(titre.first());
//		System.out.println(titre.get(0).html());
//		Elements all = titre.get(0).getAllElements();
//		System.out.println("AAAA");
//		for (Element e : all){
//			System.out.println(e.html());
//			System.out.println(e.text());
//		}
        SacAPof sap = new SacAPof();
        List<Article> articles = sap.getNewArticles();
        for (Article art : articles){
            System.out.println(art.getBody());
        }
	}
}
