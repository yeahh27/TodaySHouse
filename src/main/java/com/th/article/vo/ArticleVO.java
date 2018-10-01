package com.th.article.vo;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.th.common.dao.support.Types;
import com.th.member.vo.MemberVO;

public class ArticleVO {

	private String articleId;
	private int boardId;
	@NotEmpty(message = "제목은 필수 입력 값입니다.")
	private String title;
	@NotEmpty(message = "내용은 필수 입력 값입니다.")
	private String content;
	
	@Value("A_EMAIL")
	private String email;
	private String originFileName;
	private String fileName;
	private String regDate;
	private String modifyDate;
	private int viewCount;
	private int recommend;
	private int report;

	private MultipartFile file;
	
	private MemberVO memberVO;

	public ArticleVO() {
		this.fileName = "";
		this.originFileName = "";
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "ArticleVO [articleId=" + articleId + ", boardId=" + boardId + ", title=" + title + ", content="
				+ content + ", email=" + email + ", originFileName=" + originFileName + ", fileName=" + fileName
				+ ", regDate=" + regDate + ", modifyDate=" + modifyDate + ", viewCount=" + viewCount + ", recommend="
				+ recommend + ", report=" + report + ", file=" + file + ", memberVO=" + memberVO + "]";
	}

}
