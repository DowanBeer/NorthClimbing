package com.dowanBeer.articleRetreiver.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.dowanBeer.articleRetreiver.beans.Article;
import com.dowanBeer.articleRetreiver.utils.HibernateUtil;

public class ArticleDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public ArticleDao() {

	}

	public List<Article> getArticles()
	{
		Session s = sessionFactory.openSession();

		List<Article> Articles = s.createCriteria(Article.class).list();

		s.close();
		return Articles;
	}

	public Article getArticle(int articleId)
	{
		Session s = sessionFactory.openSession();

		Criteria cr = s.createCriteria(Article.class);

		cr.add(Restrictions.eq("Articleid", articleId));

		Article article = (Article) cr.list().get(0);

		s.close();
		return article;
	}
}
