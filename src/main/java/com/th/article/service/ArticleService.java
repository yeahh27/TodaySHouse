package com.th.article.service;

import java.util.List;

import com.th.article.vo.ArticleVO;
import com.th.member.vo.MemberVO;

public interface ArticleService {

	public boolean createArticle(ArticleVO articleVO);
	
	public List<ArticleVO> readAllArticles();
	
	public boolean updateArticle(ArticleVO articleVO);
	
	public ArticleVO readOneArticle(String articleId, MemberVO memberVO);
	
	public ArticleVO readOneArticle(String articleId);
	
	public boolean deleteArticle(String articleId);
}
