package com.framework.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * BaseHandler 提供控制器需要的基础方法
 * @author wangluyang
 *
 */
public class BaseHandler<T> {

	private static final Logger logger = Logger.getLogger(BaseHandler.class);
	
	protected static final String retFormat =  "{\"success\":%s,\"msg\":\"%s\",\"value\":\"%s\"}";
	protected static final String retFormat1 =  "{\"success\":%s,\"msg\":\"%s\",\"value\":%s}";
	protected static final String listFormat = "{\"success\":%s,\"msg\":\"%s\",\"dataList\":%s,\"sessname\":\"%s\"}";
	
	//-- header 常量定义 --//
	/**
	 * JSON编码规则配置
	 */
	public static final String HEADER_ENCODING = "encoding:UTF-8";
	
	/**
	 * no-cache参数配置
	 */
	public static final String HEADER_NOCACHE = "no-cache:false";
	
	/**
	 * JSON成功返回标识
	 */
	private static final String JSON_SUCCESS = "{\"success\":true}";
	
	/**
	 * 默认每页记录数
	 */
	protected static final int PAGESIZE = 10;
	
	/**
	 * 返回消息
	 * @param flag 是否成功
	 * @param msg	消息
	 * @return
	 */
	protected String retJson(boolean flag,String msg,Object value){
		return String.format(retFormat, flag,msg,value);
	}
	
	 /**
     * 获取根路径
     * <pre>
     * </pre>
     * @return
     */
	public static String getRootPath(HttpServletRequest request) {
		return (request.getRealPath("")).replace("\\", "/");
	}
	
	/**
	 * 直接输出内容的简便函数.
	 * 
	 * eg. render("text/plain", "hello", "encoding:GBK"); render("text/plain",
	 * "hello", "no-cache:false"); render("text/plain", "hello", "encoding:GBK",
	 * "no-cache:false");
	 * 
	 * @param status
	 *            返回状态(200/500)
	 * @param contentType
	 *            内容类型
	 * @param content
	 *            内容值
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	private static void render(HttpServletResponse response ,int status, String contentType, String content,
			String... headers) {
		HttpServletResponse resp = initResponseHeader(response,contentType, headers);
		try {
			// response.setStatus(status);
			resp.getWriter().write(content);
			resp.getWriter().flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 直接输出文本.
	 * 
	 * @see #render(String, String, String...)
	 * @param text
	 *            文本内容
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	public static void renderText(HttpServletResponse response ,String text, String... headers) {
		render(response,WebConstant.SUCCESS_STATUS, WebConstant.TEXT_TYPE, text, headers);
	}

	/**
	 * 直接输出HTML.
	 * 
	 * @see #render(String, String, String...)
	 * @param html
	 *            html内容
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	private static void renderHtml(HttpServletResponse response ,String html, String... headers) {
		render(response,WebConstant.SUCCESS_STATUS, WebConstant.HTML_TYPE, html, headers);
	}

	/**
	 * 直接输出XML.
	 * 
	 * @see #render(String, String, String...)
	 * @param xml
	 *            xml内容
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	private static void renderXml(HttpServletResponse response ,String xml, String... headers) {
		render(response,WebConstant.SUCCESS_STATUS, WebConstant.XML_TYPE, xml, headers);
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param status
	 *            返回状态(200/500)
	 * @param jsonString
	 *            json字符串.
	 * @see #render(String, String, String...)
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	public static void renderJson(HttpServletResponse response ,int status, String jsonString,
			String... headers) {
		render(response ,status, WebConstant.JSON_TYPE, jsonString, headers);
	}

	/**
	 * 分析并设置contentType与headers.
	 * 
	 * @param contentType
	 *            内容类型
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 * @return HttpServletResponse
	 */
	private static HttpServletResponse initResponseHeader(HttpServletResponse response ,String contentType,
			String... headers) {
		// 分析headers参数
		String encoding = "UTF-8";
		boolean noCache = WebConstant.DEFAULT_NOCACHE;
		for (String header : headers) {
			String headerName = StringUtils.substringBefore(header, ":");
			String headerValue = StringUtils.substringAfter(header, ":");

			if (StringUtils.equalsIgnoreCase(headerName,
					WebConstant.HEADER_ENCODING)) {
				encoding = headerValue;
			} else if (StringUtils.equalsIgnoreCase(headerName,
					WebConstant.HEADER_NOCACHE)) {
				noCache = Boolean.parseBoolean(headerValue);
			} else {
				throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
			}
		}
//		 设置headers参数
//		String fullContentType = contentType + ";charset=" + encoding;
//		// response.setContentType(fullContentType);
//		if (noCache) {
//			Servlets.setDisableCacheHeader(response);
//		}
		return response;
	}
}
