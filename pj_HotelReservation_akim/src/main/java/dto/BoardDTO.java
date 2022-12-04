package com.sinnotech.hotel.dto;

/** 
create table board_tbl (b_number number(3) primary key,
b_title varchar2(60) not null,
b_writer varchar2(30) not null,
b_time date default sysdate not null,
b_content varchar2(3000) not null);

* create sequence board_seq 
  start with 1
  increment by 1;

**/
/* 문의 게시판 관련 클래스 */
public class BoardDTO {
	private Integer id; 		// 게시글 번호
	private String title;		// 게시글 제목
	private String content;		// 게시글 내용
	private String name;		// 게시글 작성자 이름
	private String password;	// 게시글 작성자 패스워드
	private String secretFlag;		// 게시글	
	private String deleteFlag;		// 게시글
	private String createdAt;	// 게시글 작성일
	private String updatedAt;	// 게시글 수정일
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretFlag() {
		return secretFlag;
	}

	public void setSecretFlag(String secretFlag) {
		this.secretFlag = secretFlag;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
}