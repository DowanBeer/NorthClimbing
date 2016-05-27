package website;

public abstract class WebSite {
	private String name;
	private String[] articleId;
	
	public WebSite(String name, String[] articleId){
		this.name = name;
		this.articleId = articleId;
	}
	
	public abstract String getArticle(String articleId);
	public abstract String[] getNewArticles();
	public abstract String[] getAllArticles();
	

}
