package com.dowanBeer.articleRetreiver.article;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dowanBeer.articleRetreiver.beans.Article;
import com.dowanBeer.articleRetreiver.beans.WebSite;

public class ManageArticle {
	private static SessionFactory factory;

	/* Method to CREATE an article in the database */
	public Integer addArticle(String html, String md5, String id, String text, String title, String body, WebSite owner,
			LocalDateTime date, String url) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer articleOID = null;
		try {
			tx = session.beginTransaction();
			Article article = new Article(html, md5, text, title, body, owner, date, url);
			articleOID = (Integer) session.save(article);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return articleOID;
	}

	/* Method to RETREIVE all the articles */
	public List<Article> listArticles() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Article> articles = null;
		try {
			tx = session.beginTransaction();
			articles = session.createQuery("FROM Article").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return articles;
	}

	/* Method to RETREIVE one article */
	public Article getArticle(int articleID) {
		Session session = factory.openSession();
		Transaction tx = null;
		Article article = null;
		try {
			tx = session.beginTransaction();
			article = (Article) session.get(Article.class, articleID);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return article;
	}
	
	/* Method to DELETE an article from the records */
	public void deleteArticle(Integer articleID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Article article = (Article) session.get(Article.class, articleID);
			session.delete(article);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

//	public static void main(String[] args) {
//		try {
//			factory = new Configuration().configure().buildSessionFactory();
//		} catch (Throwable ex) {
//			System.err.println("Failed to create sessionFactory object." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//		ManageArticle ME = new ManageArticle();
//
//	}
}
