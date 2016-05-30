package com.dowanBeer.articleRetreiver.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSITE")
public abstract class WebSite {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	public WebSite() {
	}

	public WebSite(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public abstract String getArticle(String articleId);

	public abstract List<Article> getNewArticles();

	public abstract String[] getAllArticles();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
