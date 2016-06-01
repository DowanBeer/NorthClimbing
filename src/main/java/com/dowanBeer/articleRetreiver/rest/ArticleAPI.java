package com.dowanBeer.articleRetreiver.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dowanBeer.articleRetreiver.beans.Article;
import com.dowanBeer.articleRetreiver.dao.ArticleDao;

@RestController
public class ArticleAPI {

    private ArticleDao articleDao=new ArticleDao();
    
    @RequestMapping(value="/articles", method=RequestMethod.GET)
    public List<Article> articles() {
        return articleDao.getArticles();
    }
     
     
    @RequestMapping(value="/article", method=RequestMethod.GET)
    public Article article(HttpServletRequest request) {
        if(request.getParameter("id")!=null)
        {
        return articleDao.getArticle(Integer.parseInt(request.getParameter("id")));
        }
        return null;
    }
	
}
