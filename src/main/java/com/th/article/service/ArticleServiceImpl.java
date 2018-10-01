package com.th.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.article.dao.ArticleDao;
import com.th.article.vo.ArticleVO;
import com.th.member.vo.MemberVO;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;

	@Override
	public boolean createArticle(ArticleVO articleVO) {
		return this.articleDao.insertArticle(articleVO) > 0;
	}
	
	@Override
	public List<ArticleVO> readAllArticles() {
		return this.articleDao.selectAllArticles();
	}

	@Override
	public boolean updateArticle(ArticleVO articleVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticleVO readOneArticle(String articleId, MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVO readOneArticle(String articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteArticle(String articleId) {
		// TODO Auto-generated method stub
		return false;
	}

}
