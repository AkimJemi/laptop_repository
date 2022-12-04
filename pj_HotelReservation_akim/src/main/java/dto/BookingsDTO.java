package com.sinnotech.hotel.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinnotech.hotel.util.Constants;
import com.sinnotech.hotel.util.Util;

public class BookingsDTO {
	private int id;
	private int userId;
	private int roomId;
	private int price;
	private boolean payFlag;
	private boolean cancelFlag;
	private int adultCnt;
	private int childrenCnt;
	private String startDate;
	private String endDate;
	private String options;
	private boolean deleteFlag;
	private Date createdAt;
	private Date updatedAt;
	private String createdAtForView;
	private String updatedAtForView;
	private String updatedAtForTime;
	private String userName;
	private String roomName;

	/* view 작업용 */
	private String selectPayFlagTrue;
	private String selectPayFlagFalse;
	private String selectCancelFlagTrue;
	private String selectCancelFlagFalse;
	private String inputDeleteFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isPayFlag() {
		return payFlag;
	}

	public void setPayFlag(boolean payFlag) {
		if (payFlag == true) {
			selectPayFlagTrue = Constants.SELECTED;
		} else {
			selectPayFlagFalse = Constants.SELECTED;
		}
		this.payFlag = payFlag;
	}

	public boolean isCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(boolean cancelFlag) {
		if (cancelFlag == true) {
			selectCancelFlagTrue = Constants.SELECTED;
		} else {
			selectCancelFlagFalse = Constants.SELECTED;
		}
		this.cancelFlag = cancelFlag;
	}

	public int getAdultCnt() {
		return adultCnt;
	}

	public void setAdultCnt(int adultCnt) {
		this.adultCnt = adultCnt;
	}

	public int getChildrenCnt() {
		return childrenCnt;
	}

	public void setChildrenCnt(int childrenCnt) {
		this.childrenCnt = childrenCnt;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		if (deleteFlag == true) {
			inputDeleteFlag = Constants.DELETED_USER;
		} else {
			inputDeleteFlag = Constants.EXIST_USER;
		}
		this.deleteFlag = deleteFlag;
	}

	public String getCreatedAtForView() {
		return createdAtForView;
	}

	public void setCreatedAtForView(String createdAtForView) {
		this.createdAtForView = createdAtForView;
	}

	public String getUpdatedAtForView() {
		return updatedAtForView;
	}

	public void setUpdatedAtForView(String updatedAtForView) {
		this.updatedAtForView = updatedAtForView;
	}

	public String getUpdatedAtForTime() {
		return updatedAtForTime;
	}

	public void setUpdatedAtForTime(String updatedAtForTime) {
		this.updatedAtForTime = updatedAtForTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setStartDate(String startDate) {
		if (startDate.length() == 8)
			this.startDate = Util.DateForView(startDate);
		else
			this.startDate = Util.DateForDB(startDate);

	}

	public void setEndDate(String endDate) {
		if (endDate.length() == 8)
			this.endDate = Util.DateForView(endDate);
		else
			this.endDate = Util.DateForDB(endDate);
	}

	public void setCreatedAt(Date createdAt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.createdAtForView = sdf.format(createdAt);
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdd = new SimpleDateFormat("hh:mm:ss");
		this.updatedAtForView = sdf.format(updatedAt);
		this.updatedAtForTime = sdd.format(updatedAt);
		this.updatedAt = updatedAt;
	}

	public String getSelectPayFlagTrue() {
		return selectPayFlagTrue;
	}

	public void setSelectPayFlagTrue(String selectPayFlagTrue) {
		this.selectPayFlagTrue = selectPayFlagTrue;
	}

	public String getSelectPayFlagFalse() {
		return selectPayFlagFalse;
	}

	public void setSelectPayFlagFalse(String selectPayFlagFalse) {
		this.selectPayFlagFalse = selectPayFlagFalse;
	}

	public String getSelectCancelFlagTrue() {
		return selectCancelFlagTrue;
	}

	public void setSelectCancelFlagTrue(String selectCancelFlagTrue) {
		this.selectCancelFlagTrue = selectCancelFlagTrue;
	}

	public String getSelectCancelFlagFalse() {
		return selectCancelFlagFalse;
	}

	public void setSelectCancelFlagFalse(String selectCancelFlagFalse) {
		this.selectCancelFlagFalse = selectCancelFlagFalse;
	}

	public String getInputDeleteFlag() {
		return inputDeleteFlag;
	}

	public void setInputDeleteFlag(String inputDeleteFlag) {
		this.inputDeleteFlag = inputDeleteFlag;
	}

}
