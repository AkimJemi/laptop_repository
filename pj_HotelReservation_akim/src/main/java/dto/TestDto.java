package com.sinnotech.hotel.dto;

public class TestDto {

	private int id;
	
	private String title;
	
	private String name;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("id: %d, name: %s, title: %s", this.id, this.name, this.title);
	}

}
