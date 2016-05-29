package com.dowanBeer.articleRetreiver.website;

import com.dowanBeer.articleRetreiver.beans.Article;

import java.util.List;

public abstract class WebSite {
	private String name;
	private String[] articleId;

	public WebSite(String name, String[] articleId){
		this.name = name;
		this.articleId = articleId;
	}
	
	public abstract String getArticle(String articleId);
	public abstract List<Article> getNewArticles();
	public abstract String[] getAllArticles();
	

}
