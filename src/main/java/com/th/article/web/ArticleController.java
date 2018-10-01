package com.th.article.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.th.article.service.ArticleService;
import com.th.article.vo.ArticleVO;
import com.th.common.session.Session;
import com.th.member.vo.MemberVO;

@Controller
public class ArticleController {
	
	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@Value("${C:/uploadFiles}")
	private String uploadPath;
	
	@GetMapping("/{boardId}/articleWrite")
	public String viewArticleWritePage(@PathVariable int boardId) {
		return "article/write" + boardId;
	}
	
	@PostMapping("/{boardId}/articleWrite")
	public ModelAndView doArticleWriteAction(@PathVariable int boardId, @Valid @ModelAttribute ArticleVO articleVO, Errors errors
													, HttpSession session, HttpServletRequest request) {
		ModelAndView view = new ModelAndView("redirect:/"+boardId);

		// Validation Annotation이 실패했는지 체크
		if (errors.hasErrors()) {
			view.setViewName(boardId + "/articleWrite");		// view path 지정
			view.addObject("articleVO", articleVO);
			return view;
		}
		
		MultipartFile uploadFile = articleVO.getFile();
		
		if(!uploadFile.isEmpty()) {
			// 실제 파일 이름
			String originFileName = uploadFile.getOriginalFilename();
			// 파일 시스템에 저장될 파일의 이름(난수)
			String fileName = UUID.randomUUID().toString();
			
			// 폴더가 존재하지 않는다면, 생성
			File uploadDir = new File(this.uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			// 파일이 업로드될 경로 지정
			File destFile = new File(this.uploadPath, fileName);
			
			try {
				// 업로드
				uploadFile.transferTo(destFile);
				// DB에 File 정보 저장하기 위한 정보 셋팅
				articleVO.setOriginFileName(originFileName);
				articleVO.setFileName(fileName);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		MemberVO loginMemberVO = (MemberVO) session.getAttribute(Session.MEMBER);
		articleVO.setEmail(loginMemberVO.getEmail());

		boolean isSuccess = this.articleService.createArticle(articleVO);

		String paramFormat = "IP:%s, Param:%s, Result:%s";
		logger.debug( String.format(paramFormat, request.getRemoteAddr()
				, articleVO.getTitle() + ", " + articleVO.getContent() + ", " + articleVO.getEmail() + ", " 
						+ articleVO.getFileName() + ", " + articleVO.getOriginFileName()
				, view.getViewName()) );	
		
		return view;
	}
	
	@GetMapping("/{boardId}")
	public ModelAndView viewBoardPage(@PathVariable int boardId) {
		ModelAndView view = new ModelAndView("article/list" + boardId);
		
		List<ArticleVO> articleList = this.articleService.readAllArticles();
		
		view.addObject("boardId", boardId);
		view.addObject("articleList", articleList);
		
		return view;
	}
	
	@GetMapping("/{boardId}/{articleId}")
	public ModelAndView viewArticlePage(@PathVariable int boardId, @PathVariable String articleId) {
		ModelAndView view = new ModelAndView("article/detail" + boardId);
		
		return view;
	}

}
