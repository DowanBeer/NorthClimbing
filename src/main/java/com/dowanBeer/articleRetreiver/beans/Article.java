package com.dowanBeer.articleRetreiver.beans;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE")
public class Article {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "html")
	private String html;
	
	@Column(name = "md5")
	private String md5;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body")
	private String body;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST }, optional = true)
	@JoinColumn(name = "website_oid", referencedColumnName = "oid", nullable = false)
	private WebSite owner;
	
	@Column(name = "date")
	private LocalDateTime date;

	public Article(String html, String md5, String text, String title, String body, WebSite owner,
			LocalDateTime date) {
		super();
		this.html = html;
		this.md5 = md5;
		this.text = text;
		this.title = title;
		this.body = body;
		this.owner = owner;
		this.date = date;
	}

	public Article() {
		super();
		this.html = null;
		this.md5 = null;
		this.text = null;
		this.title = null;
		this.body = null;
		this.owner = null;
		this.date = null;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
