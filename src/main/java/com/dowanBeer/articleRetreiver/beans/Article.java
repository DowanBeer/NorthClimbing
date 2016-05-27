package com.dowanBeer.articleRetreiver.beans;

import com.dowanBeer.articleRetreiver.website.WebSite;

public class Article {

	private String html;
	private String md5;
	private String id;
	private String text;
	private String title;
	private String body;
	private WebSite owner;

	public Article(String html, String md5, String id, String text, String title, String body, WebSite owner) {
		super();
		this.html = html;
		this.md5 = md5;
		this.id = id;
		this.text = text;
		this.title = title;
		this.body = body;
		this.owner = owner;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public WebSite getOwner() {
		return owner;
	}

	public void setOwner(WebSite owner) {
		this.owner = owner;
	}

}
