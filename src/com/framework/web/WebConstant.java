/**
 * Copyright (c) 1999-2012 www.huilan.com
 *
 * Licensed under the Huilan License, Version 1.0 (the "License");
 */
package com.framework.web;

/**
 * web相关常量
 * @author wangluyang
 *
 */
public class WebConstant {
	
	/**
	 * 
	 * <p>构造函数名称:  |描述: 私有构造方法</p>
	 */
	private WebConstant(){}
	
	//-- header 常量定义 --//
	/**
	 * 编码参数名称
	 */
	public  static final String HEADER_ENCODING = "encoding";
	
	/**
	 * no-cache参数名称
	 */
	public  static final String HEADER_NOCACHE = "no-cache";
	
	/**
	 * no-cache参数值
	 */
	public static final boolean DEFAULT_NOCACHE = true;
	
	/**
	 * response渲染成功状态
	 */
	public static final int SUCCESS_STATUS = 200;
	
	/**
	 * response渲染失败状态
	 */
	public static final int FAILURE_STATUS = 500;
	
	//-- Content Type 定义 --//
	/**
	 * excel格式
	 */
	public static final String EXCEL_TYPE = "application/vnd.ms-excel";
	
	/**
	 * html格式
	 */
	public static final String HTML_TYPE = "text/html";
	
	/**
	 * javascript格式
	 */
	public static final String JS_TYPE = "text/javascript";
	
	/**
	 * JSON格式
	 */
	public static final String JSON_TYPE = "application/json";
	
	/**
	 * XML格式
	 */
	public static final String XML_TYPE = "text/xml";
	
	/**
	 * 文本格式
	 */
	public static final String TEXT_TYPE = "text/plain";

	/**
	 * Header 定义
	 */
	public static final String AUTHENTICATION_HEADER = "Authorization";
	
	//-----------//
	/** 进行增删改操作后,以redirect方式重新打开action默认页的result名.*/
	public static final String RELOAD = "reload";
}
