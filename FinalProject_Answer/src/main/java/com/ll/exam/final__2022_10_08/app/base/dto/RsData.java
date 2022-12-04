package com.ll.exam.final__2022_10_08.app.base.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
    private List<T> dataList;

    public static <T> RsData<T> of(String resultCode, String msg, T data, List<T> dataList) {
        return new RsData<>(resultCode, msg, data,dataList);
    }

    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null, null);
    }

    public static <T> RsData<T> successOf(T data) {
        return of("S-1", "성공", data, null);
    }

    public static <T> RsData<T> failOf(T data) {
        return of("F-1", "실패", data, null);
    }

    public boolean isSuccess() {
        return resultCode.startsWith("S-1");
    }

        return isSuccess() == false;
    }
	public RsData() {
		// TODO Auto-generated constructor stub
	}
}