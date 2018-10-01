package com.th.article.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.th.article.vo.ArticleVO;

@Repository
public class ArticleDaoImpl extends SqlSessionDaoSupport implements ArticleDao {

	private Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		logger.debug("Initiate MyBatis");
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertArticle(ArticleVO articleVO) {
		return getSqlSession().insert("ArticleDao.insertArticle", articleVO);
	}
	
	@Override
	public List<ArticleVO> selectAllArticles() {
		return getSqlSession().selectList("ArticleDao.selectAllArticles");
	}

	@Override
	public int updateArticle(ArticleVO articleVO) {
		return 0;
	}

	@Override
	public ArticleVO selectOneArticle(String articleId) {
		return null;
	}

	@Override
	public int deleteOneArticle(String articleId) {
		return 0;
	}

}
