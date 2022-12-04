package com.sinnotech.hotel.dto;

public class SampleDTO {
	private String id;
	private String roomCd;
	private String bookingCd;
	private String info;
	private String price;
	private String deleteFlag;
	private String createdAt;
	private String updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomCd() {
		return roomCd;
	}

	public void setRoomCd(String roomCd) {
		this.roomCd = roomCd;
	}

	public String getBookingCd() {
		return bookingCd;
	}

	public void setBookingCd(String bookingCd) {
		this.bookingCd = bookingCd;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
