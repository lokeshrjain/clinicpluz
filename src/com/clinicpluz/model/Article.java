package com.clinicpluz.model;

import java.util.Date;

public class Article  {
	private String articleId;
	private String title;
	private String bodyText;
	private String articleStatus;
    private Date articleDate;
    
    
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	public String getArticleStatus() {
		return articleStatus;
	}
	public void setArticleStatus(String articleStatus) {
		this.articleStatus = articleStatus;
	}
	public Date getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}         
	
    
}
