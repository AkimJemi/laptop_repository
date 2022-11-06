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
//	private String password;	// 게시글 작성자 패스워드
//	private String secret_flag;		// 게시글	
//	private String delete_flag;		// 게시글
	private String created_at;	// 게시글 작성일
	private String updated_at;	// 게시글 수정일

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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", title=" + title + ", content=" + content + ", name=" + name + ", created_at="
		+ created_at + ", updated_at=" + updated_at + "]";
	}
	
}