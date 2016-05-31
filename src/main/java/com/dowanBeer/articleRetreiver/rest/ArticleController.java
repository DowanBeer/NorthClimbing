package com.dowanBeer.articleRetreiver.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dowanBeer.articleRetreiver.beans.Article;

@RestController
public class ArticleController {

	//https://spring.io/guides/gs/rest-service/ Tutorial
    @RequestMapping("/article")
    public Article getArticle(@RequestParam(value="oid", defaultValue="null") int name) {
        return null;
    }
	
}
