package com.dowanBeer.articleRetreiver.website;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dowanBeer.articleRetreiver.beans.Article;
import com.dowanBeer.articleRetreiver.utils.Constants;

public class SacAPof extends WebSite{

	public SacAPof() {
		super("SacAPof", new String[0]);
	}

	@Override
	public String getArticle(String articleId) {
		// TODO Retrieve Article from DB
		return null;
	}

	@Override
	public String[] getNewArticles() {
		
		// TODO Retrieve md5Articles from DB		
		Set<String> md5ArticlesSet = new HashSet<String>();
		
		try {
			Document doc = Jsoup.connect(Constants.sacAPofArticleURLString).get();
			Elements articles =  doc.getElementsByTag("article");
			MessageDigest md5crypter = MessageDigest.getInstance("MD5");
			for (Element article : articles){
				String md5article = Arrays.toString(md5crypter.digest(article.html().getBytes(StandardCharsets.UTF_8)));
				if (!md5ArticlesSet.contains(md5article)){
					Element h1 = doc.getElementsByTag("h1").first();
					String title = h1 != null ? h1.text() : null;
					Element content = doc.getElementsByClass("entry-content").first();
					String body = h1 != null ? content.text() : null;
					new Article(doc.html(), md5article, doc.getElementsByTag("article").first().attr("id"), doc.text(), title, body, this);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String[] getAllArticles() {
		// TODO Retrieve all article from database
		return null;
	}
	/**
	 * 
	 * Example of one article with pictures
	<article id="post-813" class="post-813 post type-post status-publish format-standard hentry category-non-classe">
	<div class="blog-item-wrap">
		<a href="http://sacapof.org/quelques-photo-du-demontage/" title="Quelques photo du démontage&#8230;" ></a>
		<div class="post-inner-content">
			<header class="entry-header page-header">
				<h1 class="entry-title">
					<a href="http://sacapof.org/quelques-photo-du-demontage/" rel="bookmark">Quelques photo du démontage&#8230;</a>
				</h1>
				<div class="entry-meta">
					<span class="posted-on">
						<i class="fa fa-calendar"></i> 
						<a href="http://sacapof.org/quelques-photo-du-demontage/" rel="bookmark">
							<time class="entry-date published" datetime="2016-05-17T12:52:45+00:00">17 mai 2016</time>
						</a>
					</span>
					<span class="byline"> 
						<i class="fa fa-user"></i> 
						<span class="author vcard">
							<a class="url fn n" href="http://sacapof.org/author/matthieu/">Matthieu Drucké</a>
						</span>
					</span>				
					<span class="comments-link">
						<i class="fa fa-comment-o"></i>
						<a href="http://sacapof.org/quelques-photo-du-demontage/#respond">Laisser un commentaire</a>
					</span>
				</div><!-- .entry-meta -->
			</header><!-- .entry-header -->
			<div class="entry-content">
				<p>Voici quelques photos du démontage et lavage des prises du mur du Polyèdre qui a eu lieu le weekend dernier.</p>
				<p>Merci beaucoup à tous les bénévoles présent, petits et grands!!</p>
				<div data-carousel-extra='{"blog_id":1,"permalink":"http:\/\/sacapof.org\/quelques-photo-du-demontage\/"}' class="tiled-gallery type-rectangular" data-original-width="648">
					<div class="gallery-row" style="width: 643px; height: 179px;">
						<div class="gallery-group images-1" style="width: 321px; height: 183px;">
							<div class="tiled-gallery-item tiled-gallery-item-large">
								<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_094845/">
									<img data-attachment-id="814" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_094845.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463219325&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;50&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_094845" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_094845-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_094845-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_094845-317x179.jpg" width="317" height="179" align="left" title="20160514_094845" />
								</a>
							</div>
						</div>
						<div class="gallery-group images-1" style="width: 322px; height: 183px;">
							<div class="tiled-gallery-item tiled-gallery-item-large">
								<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_144321/">
									<img data-attachment-id="815" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_144321.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463237001&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;125&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_144321" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_144321-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_144321-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_144321-318x179.jpg" width="318" height="179" align="left" title="20160514_144321" />
								</a>
							</div>
						</div>
					</div>
					<div class="gallery-row" style="width: 643px; height: 179px;">
						<div class="gallery-group images-1" style="width: 321px; height: 183px;">
							<div class="tiled-gallery-item tiled-gallery-item-large">
								<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_170802/">
									<img data-attachment-id="816" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170802.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463245682&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;125&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_170802" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170802-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170802-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_170802-317x179.jpg" width="317" height="179" align="left" title="20160514_170802" />
								</a>
							</div>
						</div>
						<div class="gallery-group images-1" style="width: 322px; height: 183px;">
							<div class="tiled-gallery-item tiled-gallery-item-large">
								<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_170820/">
									<img data-attachment-id="817" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170820.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463245700&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;80&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_170820" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170820-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170820-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_170820-318x179.jpg" width="318" height="179" align="left" title="20160514_170820" />
								</a>
							</div>
						</div>
					</div>
						<div class="gallery-row" style="width: 643px; height: 153px;">
							<div class="gallery-group images-1" style="width: 277px; height: 157px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_131511/">
										<img data-attachment-id="818" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_131511.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463231711&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;50&quot;,&quot;shutter_speed&quot;:&quot;0.01&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_131511" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_131511-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_131511-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_131511-273x153.jpg" width="273" height="153" align="left" title="20160514_131511" />
									</a>
								</div>
							</div>
							<div class="gallery-group images-1" style="width: 90px; height: 157px;">
								<div class="tiled-gallery-item tiled-gallery-item-small">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_142734/">
										<img data-attachment-id="819" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_142734-e1463486081915.jpg" data-orig-size="2988,5312" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463236054&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;64&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;6&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_142734" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_142734-e1463486081915-169x300.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_142734-e1463486081915-576x1024.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_142734-e1463486081915-86x153.jpg" width="86" height="153" align="left" title="20160514_142734" />
									</a>
								</div>
							</div>
							<div class="gallery-group images-1" style="width: 276px; height: 157px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_170749/">
										<img data-attachment-id="820" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170749.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463245669&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;64&quot;,&quot;shutter_speed&quot;:&quot;0.01&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_170749" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170749-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170749-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_170749-272x153.jpg" width="272" height="153" align="left" title="20160514_170749" />
									</a>
								</div>
							</div>
						</div>
						<div class="gallery-row" style="width: 643px; height: 287px;">
							<div class="gallery-group images-2" style="width: 256px; height: 291px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_171113/">
										<img data-attachment-id="821" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_171113.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463245873&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;160&quot;,&quot;shutter_speed&quot;:&quot;0.04&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_171113" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_171113-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_171113-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_171113-252x141.jpg" width="252" height="141" align="left" title="20160514_171113" />
									</a>
								</div>
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_170811/">
										<img data-attachment-id="822" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170811.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463245691&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;125&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;8&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_170811" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170811-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_170811-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_170811-252x142.jpg" width="252" height="142" align="left" title="20160514_170811" />
									</a>
								</div>
							</div>
							<div class="gallery-group images-1" style="width: 387px; height: 291px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_130233/">
										<img data-attachment-id="823" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_130233.jpg" data-orig-size="2592,1944" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463230952&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;2.2&quot;,&quot;iso&quot;:&quot;125&quot;,&quot;shutter_speed&quot;:&quot;0.03030303030303&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_130233" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_130233-300x225.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_130233-1024x768.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_130233-383x287.jpg" width="383" height="287" align="left" title="20160514_130233" />
									</a>
								</div>
							</div>
						</div>
						<div class="gallery-row" style="width: 643px; height: 583px;">
							<div class="gallery-group images-1" style="width: 332px; height: 587px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_144245/">
										<img data-attachment-id="824" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_144245-e1463486061793.jpg" data-orig-size="2988,5312" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463236965&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;64&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;6&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_144245" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_144245-e1463486061793-169x300.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_144245-e1463486061793-576x1024.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_144245-e1463486061793-328x583.jpg" width="328" height="583" align="left" title="20160514_144245" />
									</a>
								</div>
							</div>
							<div class="gallery-group images-3" style="width: 311px; height: 587px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_131506/">
										<img data-attachment-id="825" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_131506.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463231706&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;40&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_131506" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_131506-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_131506-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_131506-307x173.jpg" width="307" height="173" align="left" title="20160514_131506" />
									</a>
								</div>
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_103841/">
										<img data-attachment-id="826" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_103841.jpg" data-orig-size="5312,2988" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463222321&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;160&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_103841" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_103841-300x169.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_103841-1024x576.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_103841-307x172.jpg" width="307" height="172" align="left" title="20160514_103841" />
									</a>
								</div>
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_103822/">
										<img data-attachment-id="827" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_103822.jpg" data-orig-size="2592,1944" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463222302&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;2.2&quot;,&quot;iso&quot;:&quot;64&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;1&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_103822" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_103822-300x225.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_103822-1024x768.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_103822-307x230.jpg" width="307" height="230" align="left" title="20160514_103822" />
									</a>
								</div>
							</div>
						</div>
						<div class="gallery-row" style="width: 643px; height: 301px;">
							<div class="gallery-group images-1" style="width: 643px; height: 305px;">
								<div class="tiled-gallery-item tiled-gallery-item-large">
									<a href="http://sacapof.org/quelques-photo-du-demontage/20160514_094858/">
										<img data-attachment-id="828" data-orig-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_094858-e1463485995482.jpg" data-orig-size="6624,3120" data-comments-opened="1" data-image-meta="{&quot;aperture&quot;:&quot;1.9&quot;,&quot;credit&quot;:&quot;&quot;,&quot;camera&quot;:&quot;SM-G920F&quot;,&quot;caption&quot;:&quot;&quot;,&quot;created_timestamp&quot;:&quot;1463219338&quot;,&quot;copyright&quot;:&quot;&quot;,&quot;focal_length&quot;:&quot;4.3&quot;,&quot;iso&quot;:&quot;50&quot;,&quot;shutter_speed&quot;:&quot;0.02&quot;,&quot;title&quot;:&quot;&quot;,&quot;orientation&quot;:&quot;6&quot;,&quot;keywords&quot;:&quot;Array&quot;}" data-image-title="20160514_094858" data-image-description="" data-medium-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_094858-e1463485995482-300x141.jpg" data-large-file="http://sacapof.org/wp-content/uploads/2016/05/20160514_094858-e1463485995482-1024x482.jpg" src="http://sacapof.org/wp-content/uploads/2016/05/20160514_094858-e1463485995482-639x301.jpg" width="639" height="301" align="left" title="20160514_094858" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</div><!-- .entry-content -->
			</div>
		</div>
	</article>
*/
	
	public static void main(String[] args) {
		String test = "<h1 class=\"entry-title\"><a href=\"http://sacapof.org/quelques-photo-du-demontage/\" rel=\"bookmark\">Quelques photo du démontage&#8230;</a></h1>";
		Document doc = Jsoup.parse(test);
		System.out.println(doc.text());
		Elements titre = doc.getElementsByTag("article");
		System.out.println(titre);
		System.out.println(titre.first());
		System.out.println(titre.get(0).html());
		Elements all = titre.get(0).getAllElements();
		System.out.println("AAAA");
		for (Element e : all){
			System.out.println(e.html());
			System.out.println(e.text());
		}
	}
}
