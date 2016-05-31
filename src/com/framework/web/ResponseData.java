package com.framework.web;

import java.io.Serializable;

public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final boolean AJAX_STATUS_SUCCESS = true;

    public static final boolean AJAX_STATUS_FAILURE = false;

    /**
     * 成功状态
     */
    private boolean success;
    /**
     * 返回消息
     */
    private String message;

    private T data;

    public ResponseData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseData(boolean success, String message, T data) {
    	this.success = success;
        this.message = message;
        this.data = data;
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
