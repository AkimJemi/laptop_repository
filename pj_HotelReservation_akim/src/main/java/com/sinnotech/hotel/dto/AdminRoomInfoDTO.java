package com.sinnotech.hotel.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class AdminRoomInfoDTO {
	
	private int id;
	private String room_name;
	private int max_count;
	private String info;
	private String options;
	private String images;
	private int price;
	private boolean delete_flag;
	private Date created_at;
	private Date updated_at;
	
	private MultipartFile upload_file;
	
	@Override
	public String toString() {
		return "AdminRoomInfoDTO [id=" + id + ", room_name=" + room_name + ", max_count=" + max_count + ", info=" + info
				+ ", options=" + options + ", images=" + images + ", price=" + price + ", delete_flag=" + delete_flag
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
}
