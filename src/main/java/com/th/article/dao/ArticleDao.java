package com.th.article.dao;

import java.util.List;

import com.th.article.vo.ArticleVO;

public interface ArticleDao {
	
	public int insertArticle(ArticleVO articleVO);
	
	public List<ArticleVO> selectAllArticles();
	
	public int updateArticle(ArticleVO articleVO);
	
	public ArticleVO selectOneArticle(String articleId);
	
	public int deleteOneArticle(String articleId);

}
